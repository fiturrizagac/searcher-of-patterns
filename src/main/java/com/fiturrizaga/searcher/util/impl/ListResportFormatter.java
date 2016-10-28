package com.fiturrizaga.searcher.util.impl;

import com.fiturrizaga.searcher.om.dto.ReportResult;
import com.fiturrizaga.searcher.util.ReportFormatter;

import java.util.Collection;

/**
 * Created by frankieic on 10/28/16.
 */
public class ListResportFormatter implements ReportFormatter<String>{

    protected final static String EXTENSION = ".txt";

    @Override
    public ReportResult format(Collection<String> rows) {
        StringBuilder sb = new StringBuilder();
        rows.stream().forEach((row)-> sb.append(row).append("\n"));
        return new ReportResult(sb.toString(), EXTENSION);
    }

}
