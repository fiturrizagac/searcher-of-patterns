package com.fiturrizaga.searcher.om.dto;

/**
 * Created by frankieic on 10/28/16.
 */
public class ReportResult {

    private String body;

    private String extension;

    public ReportResult(final String body, final String extension) {
        this.body = body;
        this.extension = extension;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
