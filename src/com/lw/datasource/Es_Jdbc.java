/*
 * Written by wei.Li and released to the public domain
 * Welcome to correct discussion as explained at
 *
 * -----------------------------------------------------------------
 *
 * GitHub:  https://github.com/GourdErwa
 * CSDN  :	http://blog.csdn.net/xiaohulunb
 * WeiBo :	http://www.weibo.com/xiaohulunb  	@GourdErwa
 * Email :	gourderwa@163.com
 *
 * Personal home page: http://grouderwa.com
 */

package com.lw.datasource;

import net.sf.jasperreports.engine.*;

import java.util.HashMap;

/**
 * @author wei.Li by 14/10/11.
 */
public class Es_Jdbc {

    private void writeData() throws JRException {

        String jrxmlPath = "/lw/sample.jrxml";
        CustomDataSource cds = new CustomDataSource();
        JasperReport report = JasperCompileManager.compileReport(jrxmlPath);

        JasperPrint jasperPrint = JasperFillManager
                .fillReport(report, new HashMap<String, Object>(), cds);
        JasperExportManager.exportReportToPdfFile(jasperPrint, "/lw/a.pdf");

    }

    public static void main(String[] args) throws JRException {
        Es_Jdbc es_jdbc = new Es_Jdbc();
        es_jdbc.writeData();
    }

}
