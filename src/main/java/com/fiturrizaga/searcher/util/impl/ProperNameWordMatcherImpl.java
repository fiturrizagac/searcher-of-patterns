package com.fiturrizaga.searcher.util.impl;

import com.fiturrizaga.searcher.util.WordMatcher;

import java.util.Collection;

import static com.fiturrizaga.searcher.util.WordMatcher.WordMatcherType.PROPER_NAME;

/**
 * Created by frankieic on 10/28/16.
 */
public class ProperNameWordMatcherImpl implements WordMatcher{

    @Override
    public Collection<String> match(String text) {
        //TODO: implement how perform this feature.
        return null;
    }

    @Override
    public WordMatcherType type() {
        return PROPER_NAME;
    }
}
