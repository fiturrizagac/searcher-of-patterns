package com.fiturrizaga.searcher.service.impl;

import com.fiturrizaga.searcher.repository.DataAccessException;
import com.fiturrizaga.searcher.repository.WebSiteRepository;
import com.fiturrizaga.searcher.service.FileService;
import com.fiturrizaga.searcher.service.ProcessDataService;
import com.fiturrizaga.searcher.service.WordMatcherServiceLocator;
import com.fiturrizaga.searcher.util.WordMatcher;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by frankieic on 10/28/16.
 */
public class ProcessDataServiceImpl implements ProcessDataService{

    private WebSiteRepository webSiteRepository;

    private FileService fileService;

    private WordMatcherServiceLocator wordMatcherServiceLocator;

    private int chunkSize;

    public ProcessDataServiceImpl(final WebSiteRepository webSiteRepository,
                                  final FileService fileService,
                                  final WordMatcherServiceLocator wordMatcherServiceLocator,
                                  final int chunkSize) {
        this.wordMatcherServiceLocator = wordMatcherServiceLocator;
        this.webSiteRepository = webSiteRepository;
        this.fileService = fileService;
        this.chunkSize = chunkSize;
    }

    @Override
    public synchronized void process(final String source, final WordMatcher.WordMatcherType type) {

        WordMatcher wordMatcher = wordMatcherServiceLocator.getWordMatcher(type);

        try{
            Set<String> result =  new HashSet<>();
            long total =  webSiteRepository.count(source);
            int start = 0;
            int seek = start+chunkSize;
            while (seek<total){
                String text = webSiteRepository.find(start,seek,source);
                result.addAll(wordMatcher.match(text));

                System.out.println(Thread.currentThread().getName() + " - Parsed " + seek+ " lines");
                start = ++seek;
                seek += chunkSize;

            }
            fileService.createReportFromRows(result,source);

        }catch (DataAccessException e){
            e.printStackTrace();
        }
    }

}
