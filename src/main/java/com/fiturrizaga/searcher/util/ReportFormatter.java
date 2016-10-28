package com.fiturrizaga.searcher.util;

import com.fiturrizaga.searcher.om.dto.ReportResult;

import java.util.Collection;

/**
 * Created by frankieic on 10/28/16.
 */
public interface ReportFormatter<T> {

    ReportResult format(Collection<T> rows);

}
