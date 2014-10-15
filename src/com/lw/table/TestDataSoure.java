package com.lw.table;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wei.Li by 14/10/14.
 */
public class TestDataSoure {

    protected static List<TestField> resoureList = new ArrayList<TestField>();
    private static List<TestBean> dataBeanList = new ArrayList<TestBean>();

    static {
        getDataSoure();
    }

    private static void getDataSoure() {

        for (int i = 0; i < 200; i++) {
            dataBeanList.add(new TestBean("EZSonar System", 100, 78, "98.3%", 8, "10.2%"));
        }

        TestField testField = new TestField();
        testField.setTitle("系统每日交易量报表 - 2014/10/14");
        testField.setHeader("报表头信息内容");
        testField.setSummary("summary message");
        testField.setTableList(new JRBeanCollectionDataSource(dataBeanList));

        resoureList.add(testField);
    }
}
