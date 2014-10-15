package com.lw.jfreechart;/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2014 TIBCO Software Inc. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.oasis.JROdsExporter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.AbstractSampleApp;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.*;

import java.io.File;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JFreeChartApp.java 7199 2014-08-27 13:58:10Z teodord $
 */
public class JFreeChartApp extends AbstractSampleApp {


    /**
     *
     */
    public static void main(String[] args) throws JRException {
        new JFreeChartApp().test();

    }


    /**
     *
     */
    public void test() throws JRException {
        fill();
        pdf();
        xmlEmbed();
        xml();
        html();
        rtf();
        xls();
        jxl();
        csv();
        odt();
        ods();
        docx();
        xlsx();
        pptx();
        xhtml();
    }


    /**
     *
     */
    public void fill() throws JRException {
        long start = System.currentTimeMillis();
        JasperFillManager.fillReportToFile("build/reports/JFreeChartReport.jasper", null, new JREmptyDataSource());
        System.err.println("Filling time : " + (System.currentTimeMillis() - start));
    }


    /**
     *
     */
    public void print() throws JRException {
        long start = System.currentTimeMillis();
        JasperPrintManager.printReport("build/reports/JFreeChartReport.jrprint", true);
        System.err.println("Printing time : " + (System.currentTimeMillis() - start));
    }


    /**
     *
     */
    public void pdf() throws JRException {
        long start = System.currentTimeMillis();
        JasperExportManager.exportReportToPdfFile("build/reports/JFreeChartReport.jrprint");
        System.err.println("PDF creation time : " + (System.currentTimeMillis() - start));
    }


    /**
     *
     */
    public void rtf() throws JRException {
        long start = System.currentTimeMillis();
        File sourceFile = new File("build/reports/JFreeChartReport.jrprint");

        JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);

        File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".rtf");

        JRRtfExporter exporter = new JRRtfExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleHtmlExporterOutput(destFile));

        exporter.exportReport();

        System.err.println("RTF creation time : " + (System.currentTimeMillis() - start));
    }


    /**
     *
     */
    public void xml() throws JRException {
        long start = System.currentTimeMillis();
        JasperExportManager.exportReportToXmlFile("build/reports/JFreeChartReport.jrprint", false);
        System.err.println("XML creation time : " + (System.currentTimeMillis() - start));
    }


    /**
     *
     */
    public void xmlEmbed() throws JRException {
        long start = System.currentTimeMillis();
        JasperExportManager.exportReportToXmlFile("build/reports/JFreeChartReport.jrprint", true);
        System.err.println("XML creation time : " + (System.currentTimeMillis() - start));
    }


    /**
     *
     */
    public void html() throws JRException {
        long start = System.currentTimeMillis();
        JasperExportManager.exportReportToHtmlFile("build/reports/JFreeChartReport.jrprint");
        System.err.println("HTML creation time : " + (System.currentTimeMillis() - start));
    }


    /**
     *
     */
    public void xls() throws JRException {
        long start = System.currentTimeMillis();
        File sourceFile = new File("build/reports/JFreeChartReport.jrprint");

        JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);

        File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".xls");

        JRXlsExporter exporter = new JRXlsExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFile));
        SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
        configuration.setOnePagePerSheet(true);
        exporter.setConfiguration(configuration);

        exporter.exportReport();

        System.err.println("XLS creation time : " + (System.currentTimeMillis() - start));
    }


    /**
     *
     */
    @SuppressWarnings("deprecation")
    public void jxl() throws JRException {
        long start = System.currentTimeMillis();
        File sourceFile = new File("build/reports/JFreeChartReport.jrprint");

        JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);

        File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".jxl.xls");

        net.sf.jasperreports.engine.export.JExcelApiExporter exporter =
                new net.sf.jasperreports.engine.export.JExcelApiExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFile));
        net.sf.jasperreports.export.SimpleJxlReportConfiguration configuration =
                new net.sf.jasperreports.export.SimpleJxlReportConfiguration();
        configuration.setOnePagePerSheet(true);
        exporter.setConfiguration(configuration);

        exporter.exportReport();

        System.err.println("XLS creation time : " + (System.currentTimeMillis() - start));
    }


    /**
     *
     */
    public void csv() throws JRException {
        long start = System.currentTimeMillis();
        File sourceFile = new File("build/reports/JFreeChartReport.jrprint");

        JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);

        File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".csv");

        JRCsvExporter exporter = new JRCsvExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleWriterExporterOutput(destFile));

        exporter.exportReport();

        System.err.println("CSV creation time : " + (System.currentTimeMillis() - start));
    }


    /**
     *
     */
    public void odt() throws JRException {
        long start = System.currentTimeMillis();
        File sourceFile = new File("build/reports/JFreeChartReport.jrprint");

        JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);

        File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".odt");

        JROdtExporter exporter = new JROdtExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFile));

        exporter.exportReport();

        System.err.println("ODT creation time : " + (System.currentTimeMillis() - start));
    }


    /**
     *
     */
    public void ods() throws JRException {
        long start = System.currentTimeMillis();
        File sourceFile = new File("build/reports/JFreeChartReport.jrprint");

        JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);

        File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".ods");

        JROdsExporter exporter = new JROdsExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFile));
        SimpleOdsReportConfiguration configuration = new SimpleOdsReportConfiguration();
        configuration.setOnePagePerSheet(true);
        exporter.setConfiguration(configuration);

        exporter.exportReport();

        System.err.println("ODS creation time : " + (System.currentTimeMillis() - start));
    }


    /**
     *
     */
    public void docx() throws JRException {
        long start = System.currentTimeMillis();
        File sourceFile = new File("build/reports/JFreeChartReport.jrprint");

        JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);

        File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".docx");

        JRDocxExporter exporter = new JRDocxExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFile));

        exporter.exportReport();

        System.err.println("DOCX creation time : " + (System.currentTimeMillis() - start));
    }


    /**
     *
     */
    public void xlsx() throws JRException {
        long start = System.currentTimeMillis();
        File sourceFile = new File("build/reports/JFreeChartReport.jrprint");

        JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);

        File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".xlsx");

        JRXlsxExporter exporter = new JRXlsxExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFile));
        SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
        configuration.setOnePagePerSheet(true);
        exporter.setConfiguration(configuration);

        exporter.exportReport();

        System.err.println("XLSX creation time : " + (System.currentTimeMillis() - start));
    }


    /**
     *
     */
    public void pptx() throws JRException {
        long start = System.currentTimeMillis();
        File sourceFile = new File("build/reports/JFreeChartReport.jrprint");

        JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);

        File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".pptx");

        JRPptxExporter exporter = new JRPptxExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFile));

        exporter.exportReport();

        System.err.println("PPTX creation time : " + (System.currentTimeMillis() - start));
    }


    /**
     *
     */
    @SuppressWarnings("deprecation")
    public void xhtml() throws JRException {
        long start = System.currentTimeMillis();
        File sourceFile = new File("build/reports/JFreeChartReport.jrprint");

        JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);

        File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".x.html");

        net.sf.jasperreports.engine.export.JRXhtmlExporter exporter =
                new net.sf.jasperreports.engine.export.JRXhtmlExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleHtmlExporterOutput(destFile));

        exporter.exportReport();

        System.err.println("XHTML creation time : " + (System.currentTimeMillis() - start));
    }


}
