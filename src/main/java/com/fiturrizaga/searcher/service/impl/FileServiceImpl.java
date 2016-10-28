package com.fiturrizaga.searcher.service.impl;

import com.fiturrizaga.searcher.om.dto.ReportResult;
import com.fiturrizaga.searcher.repository.DataAccessException;
import com.fiturrizaga.searcher.repository.FileRepository;
import com.fiturrizaga.searcher.service.FileService;
import com.fiturrizaga.searcher.util.ReportFormatter;

import java.io.FileNotFoundException;
import java.util.Collection;

/**
 * Created by frankieic on 10/28/16.
 */
public class FileServiceImpl implements FileService{

    private FileRepository fileRepository;

    private ReportFormatter reportFormatter;

    public FileServiceImpl(FileRepository fileRepository, ReportFormatter reportFormatter) {
        this.fileRepository = fileRepository;
        this.reportFormatter = reportFormatter;
    }

    @Override
    public void createReportFromRows(final Collection<String> rows, final String reportName) {
        try{
            ReportResult report = reportFormatter.format(rows);
            fileRepository.save(report.getBody(),reportName + report.getExtension());
            System.out.println(Thread.currentThread().getName() + "Create " + reportName + report.getExtension());
        }catch (DataAccessException e){
            e.printStackTrace();
        }

    }

    @Override
    public Collection<String> find(String file) throws FileNotFoundException{
        try{
            return fileRepository.find(file);
        }catch (DataAccessException e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }

}
