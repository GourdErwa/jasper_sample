package com.lw.charts;

import com.lw.Params;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRCsvDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.oasis.JROdsExporter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.*;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;


/**
 */
public class ChartApp {

    public static final String JASPER_PATH = Params.getReportPath("charts", "charts.jasper");
    public static final String JRPRINT_PATH = Params.getReportPath("charts", "charts.jrprint");
    public static final String DATA_PATH = Params.getReportDataPath("charts");

    /**
     *
     */
    public static void main(String[] args) throws JRException {
        new ChartApp().test();
    }


    /**
     *
     */
    public void test() throws JRException {
        fill();
        pdf();
        /*xmlEmbed();
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
   /* public void themes() throws JRException {
        long start = System.currentTimeMillis();
        XmlChartTheme.saveSettings(
                SimpleSettingsFactory.createChartThemeSettings(),
                new File(JASPER + "/simple.JASPER")
        );
        XmlChartTheme.saveSettings(
                EyeCandySixtiesSettingsFactory.createChartThemeSettings(),
                new File(JASPER + "/eye.candy.sixties.JASPER")
        );
        XmlChartTheme.saveSettings(
                AegeanSettingsFactory.createChartThemeSettings(),
                new File(JASPER + "/aegean.JASPER")
        );
        System.err.println("Theme saving time : " + (System.currentTimeMillis() - start));
    }*/


    /**
     *
     */
    public void fill() throws JRException {
        long start = System.currentTimeMillis();
        Map<String, Object> parameters = new HashMap<String, Object>();

        putDataSources(parameters);

        JasperFillManager.fillReportToFile(JASPER_PATH, parameters, new JREmptyDataSource());
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
    public void xls() throws JRException {
        long start = System.currentTimeMillis();
        File sourceFile = new File(JRPRINT_PATH);
        Map<String, String> dateFormats = new HashMap<String, String>();
        dateFormats.put("EEE, MMM d, yyyy", "ddd, mmm d, yyyy");
        JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);
        File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".xls");

        JRXlsExporter exporter = new JRXlsExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFile));
        SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
        configuration.setOnePagePerSheet(true);
        configuration.setDetectCellType(true);
        configuration.setFormatPatternsMap(dateFormats);
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
        SimpleJxlReportConfiguration configuration =
                new SimpleJxlReportConfiguration();
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
        Map<String, String> dateFormats = new HashMap<String, String>();
        dateFormats.put("EEE, MMM d, yyyy", "ddd, mmm d, yyyy");
        JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);
        File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".xlsx");

        JRXlsxExporter exporter = new JRXlsxExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFile));
        SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
        configuration.setOnePagePerSheet(true);
        configuration.setDetectCellType(true);
        configuration.setFormatPatternsMap(dateFormats);
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


    /**
     *
     */
    public static void putDataSources(Map<String, Object> parameters) throws JRException {
        try {
           /* JRCsvDataSource cds1 = new JRCsvDataSource(JRLoader.getLocationInputStream(JASPER + "data/categoryDatasource.csv"), "UTF-8");
            cds1.setRecordDelimiter("\r\n");
            cds1.setUseFirstRowAsHeader(true);
            parameters.put("categoryDatasource1", cds1);

            JRCsvDataSource cds2 = new JRCsvDataSource(JRLoader.getLocationInputStream(JASPER + "data/categoryDatasource.csv"), "UTF-8");
            cds2.setRecordDelimiter("\r\n");
            cds2.setUseFirstRowAsHeader(true);
            parameters.put("categoryDatasource2", cds2);

            JRCsvDataSource cds3 = new JRCsvDataSource(JRLoader.getLocationInputStream(JASPER + "data/categoryDatasource.csv"), "UTF-8");
            cds3.setRecordDelimiter("\r\n");
            cds3.setUseFirstRowAsHeader(true);
            parameters.put("categoryDatasource3", cds3);

            JRCsvDataSource cds4 = new JRCsvDataSource(JRLoader.getLocationInputStream(JASPER + "data/categoryDatasource.csv"), "UTF-8");
            cds4.setRecordDelimiter("\r\n");
            cds4.setUseFirstRowAsHeader(true);
            parameters.put("categoryDatasource4", cds4);

            JRCsvDataSource cds5 = new JRCsvDataSource(JRLoader.getLocationInputStream(JASPER + "data/categoryDatasource.csv"), "UTF-8");
            cds5.setRecordDelimiter("\r\n");
            cds5.setUseFirstRowAsHeader(true);
            parameters.put("categoryDatasource5", cds5);

            JRCsvDataSource cds6 = new JRCsvDataSource(JRLoader.getLocationInputStream(JASPER + "data/categoryDatasource.csv"), "UTF-8");
            cds6.setRecordDelimiter("\r\n");
            cds6.setUseFirstRowAsHeader(true);
            parameters.put("categoryDatasource6", cds6);

            JRCsvDataSource cds7 = new JRCsvDataSource(JRLoader.getLocationInputStream(JASPER + "data/categoryDatasource.csv"), "UTF-8");
            cds7.setRecordDelimiter("\r\n");
            cds7.setUseFirstRowAsHeader(true);
            parameters.put("categoryDatasource7", cds7);

            JRCsvDataSource pds1 = new JRCsvDataSource(JRLoader.getLocationInputStream(JASPER + "data/pieDatasource.csv"), "UTF-8");
            pds1.setRecordDelimiter("\r\n");
            pds1.setUseFirstRowAsHeader(true);
            parameters.put("pieDatasource1", pds1);

            JRCsvDataSource pds2 = new JRCsvDataSource(JRLoader.getLocationInputStream(JASPER + "data/pieDatasource.csv"), "UTF-8");
            pds2.setRecordDelimiter("\r\n");
            pds2.setUseFirstRowAsHeader(true);
            parameters.put("pieDatasource2", pds2);

            JRCsvDataSource tpds1 = new JRCsvDataSource(JRLoader.getLocationInputStream(JASPER + "data/timePeriodDatasource.csv"), "UTF-8");
            tpds1.setRecordDelimiter("\r\n");
            tpds1.setUseFirstRowAsHeader(true);
            parameters.put("timePeriodDatasource1", tpds1);
            */

            JRCsvDataSource tsds1 = new JRCsvDataSource(JRLoader.getLocationInputStream(DATA_PATH + "timeSeriesDatasource.csv"), "UTF-8");
            tsds1.setRecordDelimiter("\r\n");
            tsds1.setUseFirstRowAsHeader(true);
            tsds1.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
            parameters.put("timeSeriesDatasource1", tsds1);

            /*
            JRCsvDataSource tsds2 = new JRCsvDataSource(JRLoader.getLocationInputStream(JASPER + "data/timeSeriesDatasource.csv"), "UTF-8");
            tsds2.setRecordDelimiter("\r\n");
            tsds2.setUseFirstRowAsHeader(true);
            tsds2.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
            parameters.put("timeSeriesDatasource2", tsds2);

            JRCsvDataSource tsds3 = new JRCsvDataSource(JRLoader.getLocationInputStream(JASPER + "data/timeSeriesDatasource.csv"), "UTF-8");
            tsds3.setRecordDelimiter("\r\n");
            tsds3.setUseFirstRowAsHeader(true);
            tsds3.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
            parameters.put("timeSeriesDatasource3", tsds3);

            JRCsvDataSource xyds1 = new JRCsvDataSource(JRLoader.getLocationInputStream(DATA_PATH + "xyDatasource.csv"), "UTF-8");
            xyds1.setRecordDelimiter("\r\n");
            xyds1.setUseFirstRowAsHeader(true);
            parameters.put("xyDatasource1", xyds1);


            JRCsvDataSource xyds2 = new JRCsvDataSource(JRLoader.getLocationInputStream(JASPER + "data/xyDatasource.csv"), "UTF-8");
            xyds2.setRecordDelimiter("\r\n");
            xyds2.setUseFirstRowAsHeader(true);
            parameters.put("xyDatasource2", xyds2);

            JRCsvDataSource xyds3 = new JRCsvDataSource(JRLoader.getLocationInputStream(JASPER + "data/xyDatasource.csv"), "UTF-8");
            xyds3.setRecordDelimiter("\r\n");
            xyds3.setUseFirstRowAsHeader(true);
            parameters.put("xyDatasource3", xyds3);

            JRCsvDataSource xyds4 = new JRCsvDataSource(JRLoader.getLocationInputStream(JASPER + "data/xyDatasource.csv"), "UTF-8");
            xyds4.setRecordDelimiter("\r\n");
            xyds4.setUseFirstRowAsHeader(true);
            parameters.put("xyDatasource4", xyds4);

            JRCsvDataSource xyds5 = new JRCsvDataSource(JRLoader.getLocationInputStream(JASPER + "data/xyDatasource.csv"), "UTF-8");
            xyds5.setRecordDelimiter("\r\n");
            xyds5.setUseFirstRowAsHeader(true);
            parameters.put("xyDatasource5", xyds5);*/
        } catch (UnsupportedEncodingException e) {
            throw new JRException(e);
        }
    }

}
