package com.lw.jsondatasource;

import com.lw.Params;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.oasis.JROdsExporter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.query.JsonQueryExecuterFactory;
import net.sf.jasperreports.engine.util.AbstractSampleApp;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.*;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


/**
 * @author Narcis Marcu (narcism@users.sourceforge.net)
 * @version $Id: JsonDataSourceApp.java 7199 2014-08-27 13:58:10Z teodord $
 */
public class JsonDataSourceApp extends AbstractSampleApp {

    public static final String JASPER_PATH = Params.getReportPath("jsondatasource", "JsonCustomersReport.jasper");
    public static final String JRPRINT_PATH = Params.getReportPath("jsondatasource", "JsonCustomersReport.jrprint");
    
    /**
     *
     */
    public static void main(String[] args) throws JRException {
        new JsonDataSourceApp().test();
    }


    /**
     *
     */
    public void test() throws JRException {
        fill();
        pdf();
       /* xmlEmbed();
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
        xhtml();*/
    }


    /**
     *
     */
    public void fill() throws JRException {
        long start = System.currentTimeMillis();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(JsonQueryExecuterFactory.JSON_DATE_PATTERN, "yyyy-MM-dd");
        params.put(JsonQueryExecuterFactory.JSON_NUMBER_PATTERN, "#,##0.##");
        params.put(JsonQueryExecuterFactory.JSON_LOCALE, Locale.ENGLISH);
        params.put(JRParameter.REPORT_LOCALE, Locale.US);
        params.put(JsonQueryExecuterFactory.JSON_SOURCE, "data/northwind.json");

        JasperFillManager.fillReportToFile(JASPER_PATH, params);
        System.err.println("Filling time : " + (System.currentTimeMillis() - start));
    }


    /**
     *
     */
    public void print() throws JRException {
        long start = System.currentTimeMillis();
        JasperPrintManager.printReport(JRPRINT_PATH, true);
        System.err.println("Printing time : " + (System.currentTimeMillis() - start));
    }


    /**
     *
     */
    public void pdf() throws JRException {
        long start = System.currentTimeMillis();
        JasperExportManager.exportReportToPdfFile(JRPRINT_PATH);
        System.err.println("PDF creation time : " + (System.currentTimeMillis() - start));
    }


    /**
     *
     */
    public void rtf() throws JRException {
        long start = System.currentTimeMillis();
        File sourceFile = new File(JRPRINT_PATH);

        JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);

        File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".rtf");

        JRRtfExporter exporter = new JRRtfExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleWriterExporterOutput(destFile));

        exporter.exportReport();

        System.err.println("RTF creation time : " + (System.currentTimeMillis() - start));
    }


    /**
     *
     */
    public void xml() throws JRException {
        long start = System.currentTimeMillis();
        JasperExportManager.exportReportToXmlFile(JRPRINT_PATH, false);
        System.err.println("XML creation time : " + (System.currentTimeMillis() - start));
    }


    /**
     *
     */
    public void xmlEmbed() throws JRException {
        long start = System.currentTimeMillis();
        JasperExportManager.exportReportToXmlFile(JRPRINT_PATH, true);
        System.err.println("XML creation time : " + (System.currentTimeMillis() - start));
    }


    /**
     *
     */
    public void html() throws JRException {
        long start = System.currentTimeMillis();
        JasperExportManager.exportReportToHtmlFile(JRPRINT_PATH);
        System.err.println("HTML creation time : " + (System.currentTimeMillis() - start));
    }


    /**
     *
     */
    public void xls() throws JRException {
        long start = System.currentTimeMillis();
        File sourceFile = new File(JRPRINT_PATH);

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
        File sourceFile = new File(JRPRINT_PATH);

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
        File sourceFile = new File(JRPRINT_PATH);

        JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);

        File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".csv");

        JRCsvExporter exporter = new JRCsvExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleWriterExporterOutput(destFile));
        //exporter.setParameter(JRCsvExporterParameter.FIELD_DELIMITER, "|");

        exporter.exportReport();

        System.err.println("CSV creation time : " + (System.currentTimeMillis() - start));
    }


    /**
     *
     */
    public void odt() throws JRException {
        long start = System.currentTimeMillis();
        File sourceFile = new File(JRPRINT_PATH);

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
        File sourceFile = new File(JRPRINT_PATH);

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
        File sourceFile = new File(JRPRINT_PATH);

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
        File sourceFile = new File(JRPRINT_PATH);

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
        File sourceFile = new File(JRPRINT_PATH);

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
        File sourceFile = new File(JRPRINT_PATH);

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
