package com.fiturrizaga.searcher.service;

import java.io.FileNotFoundException;
import java.util.Collection;

/**
 * Created by frankieic on 10/28/16.
 */
public interface FileService {

    void createReportFromRows(Collection<String> rows, String report);

    Collection<String> find(String file) throws FileNotFoundException;

}
