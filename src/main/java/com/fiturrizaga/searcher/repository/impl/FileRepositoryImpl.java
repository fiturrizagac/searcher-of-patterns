package com.fiturrizaga.searcher.repository.impl;

import com.fiturrizaga.searcher.repository.DataAccessException;
import com.fiturrizaga.searcher.repository.FileRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

/**
 * Created by frankieic on 10/28/16.
 */
public class FileRepositoryImpl implements FileRepository{

    private String fileRepositoryPath;

    public FileRepositoryImpl(String fileRepositoryPath) {
        this.fileRepositoryPath = fileRepositoryPath;
    }

    @Override
    public void save(final String data, final String file) throws DataAccessException{
        try {
            String path = getAbsolutePath(file);
            PrintWriter pw = new PrintWriter(path,"UTF-8");
            pw.print(data);
            pw.close();
        }catch (FileNotFoundException | UnsupportedEncodingException e){
            throw new DataAccessException(e.getMessage(),e);
        }
    }

    @Override
    public Collection<String> find(final String file) throws DataAccessException {
        try{
            Path path = Paths.get(getAbsolutePath(file));
            List<String> result = Files.readAllLines(path);
            return result;
        }catch (IOException e){
            throw new DataAccessException(e.getMessage(),e);
        }

    }

    protected String getAbsolutePath(final String filename){
        StringBuilder sb = new StringBuilder();
        sb.append(fileRepositoryPath).append(File.separator).append(filename);
        return sb.toString();
    }

}
