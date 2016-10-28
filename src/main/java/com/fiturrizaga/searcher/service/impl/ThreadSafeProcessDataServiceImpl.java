package com.fiturrizaga.searcher.service.impl;

import com.fiturrizaga.searcher.service.ProcessDataService;
import com.fiturrizaga.searcher.util.WordMatcher;

/**
 * Created by frankieic on 10/28/16.
 */
public class ThreadSafeProcessDataServiceImpl implements Runnable{

    private ProcessDataService processDataService;
    private String source;
    private WordMatcher.WordMatcherType type;

    public ThreadSafeProcessDataServiceImpl(final ProcessDataService processDataService,
                                            final String source,
                                            final WordMatcher.WordMatcherType type) {
        this.processDataService = processDataService;
        this.source = source;
        this.type = type;
    }

    @Override
    public void run() {
        processDataService.process(source,type);
    }
}
