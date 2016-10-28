package com.fiturrizaga.searcher.launch;

import com.fiturrizaga.searcher.controller.StarterController;
import com.fiturrizaga.searcher.repository.FileRepository;
import com.fiturrizaga.searcher.repository.WebSiteRepository;
import com.fiturrizaga.searcher.repository.impl.FileRepositoryImpl;
import com.fiturrizaga.searcher.repository.impl.UrlWebSiteRepositoryImpl;
import com.fiturrizaga.searcher.service.FileService;
import com.fiturrizaga.searcher.service.ProcessDataService;
import com.fiturrizaga.searcher.service.WordMatcherServiceLocator;
import com.fiturrizaga.searcher.service.impl.FileServiceImpl;
import com.fiturrizaga.searcher.service.impl.ProcessDataServiceImpl;
import com.fiturrizaga.searcher.service.impl.WordMatcherServiceLocatorImpl;
import com.fiturrizaga.searcher.util.ReportFormatter;
import com.fiturrizaga.searcher.util.impl.HashTagWordMatcherImpl;
import com.fiturrizaga.searcher.util.impl.ListResportFormatter;
import com.fiturrizaga.searcher.util.impl.ProperNameWordMatcherImpl;
import com.fiturrizaga.searcher.util.impl.TwitterAccountWordMatcherImpl;

/**
 * Created by frankieic on 10/27/16.
 */
public class AppSearch {

    public static void main(final String[] args) {

        String patternType = args[0];
        String urlFilePath = args[1];

        String fileRepositoryPath = "./files";
        int chunksize = 600;

        // Repositories
        FileRepository fileRepository = new FileRepositoryImpl(fileRepositoryPath);

        WebSiteRepository webSiteRepository = new UrlWebSiteRepositoryImpl();

        // Util
        ReportFormatter reportFormatter = new ListResportFormatter();

        // Services
        FileService fileService = new FileServiceImpl(fileRepository,reportFormatter);

        WordMatcherServiceLocator  wordMatcherServiceLocator = new WordMatcherServiceLocatorImpl(
            new HashTagWordMatcherImpl(),
            new ProperNameWordMatcherImpl(),
            new TwitterAccountWordMatcherImpl());

        ProcessDataService processDataService = new ProcessDataServiceImpl(
            webSiteRepository,
            fileService,
            wordMatcherServiceLocator,
            chunksize);

        // Controller
        StarterController starterController = new StarterController(
            processDataService,
            fileService,
            patternType,
            urlFilePath);
        starterController.launch();

    }

}
