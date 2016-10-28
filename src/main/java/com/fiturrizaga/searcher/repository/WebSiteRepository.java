package com.fiturrizaga.searcher.repository;

/**
 * Created by frankieic on 10/28/16.
 */
public interface WebSiteRepository {

    long count(String website) throws DataAccessException;

    String find(int start, int finish, String website) throws DataAccessException;

}
