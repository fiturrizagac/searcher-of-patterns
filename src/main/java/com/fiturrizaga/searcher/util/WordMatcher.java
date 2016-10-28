package com.fiturrizaga.searcher.util;

import java.util.Collection;

/**
 * Created by frankieic on 10/28/16.
 */
public interface WordMatcher {

    Collection<String> match(String text);

    WordMatcherType type();

    enum WordMatcherType{
        HASHTAG, TWITTER_NAME, PROPER_NAME
    }

}