package com.fiturrizaga.searcher.util.impl;

import com.fiturrizaga.searcher.util.WordMatcher;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.fiturrizaga.searcher.util.WordMatcher.WordMatcherType.HASHTAG;

/**
 * Created by frankieic on 10/28/16.
 */
public class HashTagWordMatcherImpl implements WordMatcher {

//    protected final static String PATTERN = "/(<a[^>]*>.*?[#][a-zA-Z_]+.*?<\\/a>)|([#][a-zA-Z_]+)/g";
    protected final static String PATTERN = "(?:)[#]([A-Za-z0-9-_]+)[^<]";
//    (?:\s|\A)[##]+([A-Za-z0-9-_]+)

    public Set<String> match(String text) {
        Set<String> matches = new HashSet<>();
        Matcher matcher = Pattern.compile(getPattern()).matcher(text);
        while (matcher.find()){
            matches.add(matcher.group().trim());
        }
        return matches;
    }

    @Override
    public WordMatcherType type() {
        return HASHTAG;
    }

    protected String getPattern(){
        return PATTERN;
    }

}
