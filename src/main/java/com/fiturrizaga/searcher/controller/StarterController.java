package com.fiturrizaga.searcher.controller;

import com.fiturrizaga.searcher.service.FileService;
import com.fiturrizaga.searcher.service.ProcessDataService;
import com.fiturrizaga.searcher.service.impl.ThreadSafeProcessDataServiceImpl;
import com.fiturrizaga.searcher.util.WordMatcher;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by frankieic on 10/28/16.
 */
public class StarterController {


    private ProcessDataService processDataService;
    private FileService fileService;
    private String type;
    private String urlPath;

    public StarterController(final ProcessDataService processDataService,
                             final FileService fileService,
                             final String type,
                             final String urlPath) {
        this.processDataService = processDataService;
        this.fileService = fileService;
        this.type = type;
        this.urlPath = urlPath;
    }

    public void launch(){

        WordMatcher.WordMatcherType type = WordMatcher.WordMatcherType.valueOf(this.type);

        try{
            Collection<String> urls = fileService.find(urlPath);

            ExecutorService executor = Executors.newFixedThreadPool(urls.size());

            urls.stream().forEach(
                (url) ->{
                    Thread thread = new Thread(
                        new ThreadSafeProcessDataServiceImpl(processDataService,url,type));
                    thread.setName("Thread " + url);
                    executor.execute(thread);
                });

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }



    }

}
