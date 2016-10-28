package com.fiturrizaga.searcher.repository.impl;

import com.fiturrizaga.searcher.repository.DataAccessException;
import com.fiturrizaga.searcher.repository.WebSiteRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by frankieic on 10/28/16.
 */
public class UrlWebSiteRepositoryImpl implements WebSiteRepository{

    private URL url;

    @Override
    public String find(int start, int finish, String website) throws DataAccessException {

        try{
            url = new URL(website);
            StringBuilder sb = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            long counter = 0L;
            while((inputLine = in.readLine()) != null){
                if(counter<start) continue;
                if(inputLine!=null) sb.append(inputLine);
                if(counter==finish) break;
            }
            return sb.toString();
        }catch (IOException e){
            throw new DataAccessException(e.getMessage(),e);
        }
    }

    @Override
    public long count(String website) throws DataAccessException{
        try{
            url = new URL(website);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            return in.lines().count();
        }catch (IOException e){
            throw new DataAccessException(e.getMessage(),e);
        }
    }
}
