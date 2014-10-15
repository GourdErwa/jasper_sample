package com.lw.table;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @author wei.Li by 14/10/14.
 */
public class TestField {

    private String title;
    private String header;
    private String summary;
    private JRBeanCollectionDataSource tableList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public JRBeanCollectionDataSource getTableList() {
        return tableList;
    }

    public void setTableList(JRBeanCollectionDataSource tableList) {
        this.tableList = tableList;
    }
}
