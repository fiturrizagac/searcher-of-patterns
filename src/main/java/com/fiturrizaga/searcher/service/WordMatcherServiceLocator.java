package com.fiturrizaga.searcher.service;

import com.fiturrizaga.searcher.util.WordMatcher;

/**
 * Created by frankieic on 10/28/16.
 */
public interface WordMatcherServiceLocator {

    WordMatcher getWordMatcher(WordMatcher.WordMatcherType type);

}
