package com.fiturrizaga.searcher.repository;

import java.util.Collection;

/**
 * Created by frankieic on 10/28/16.
 */
public interface FileRepository {

    void save(String data, String file) throws DataAccessException;

    Collection<String> find(String file) throws DataAccessException;

}
