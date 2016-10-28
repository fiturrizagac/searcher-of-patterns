package com.fiturrizaga.searcher.util.impl;

import com.fiturrizaga.searcher.util.WordMatcher;

import static com.fiturrizaga.searcher.util.WordMatcher.WordMatcherType.TWITTER_NAME;

/**
 * Created by frankieic on 10/28/16.
 */
public class TwitterAccountWordMatcherImpl extends HashTagWordMatcherImpl {

    protected final static String PATTERN = "(?:)[@]([A-Za-z0-9-_]+)[^<]";

    protected String getPattern(){
        return PATTERN;
    }

    @Override
    public WordMatcherType type() {
        return TWITTER_NAME;
    }
}
