package com.fiturrizaga.searcher.service.impl;

import com.fiturrizaga.searcher.service.WordMatcherServiceLocator;
import com.fiturrizaga.searcher.util.WordMatcher;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by frankieic on 10/28/16.
 */
public class WordMatcherServiceLocatorImpl implements WordMatcherServiceLocator{

    private Map<WordMatcher.WordMatcherType,WordMatcher> locator;

    public WordMatcherServiceLocatorImpl(final WordMatcher... wordMatchers) {
        this.locator = new HashMap<>();
        for(WordMatcher wordMatcher:wordMatchers){
            locator.put(wordMatcher.type(),wordMatcher);
        }
    }

    @Override
    public WordMatcher getWordMatcher(WordMatcher.WordMatcherType type) {
        return locator.get(type);
    }
}
