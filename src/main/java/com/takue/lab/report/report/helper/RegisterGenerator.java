package com.takue.lab.report.report.helper;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegisterGenerator {
    private  static String PATH = "src/main/resources/jasper/lab-request-report.jrxml";
    private static final String REPORT_PATH = "/home/takue/Desktop";

    public static  <T> String generateReport(String reportFormat, List<T> data) throws FileNotFoundException, JRException {
        File file = ResourceUtils.getFile(PATH);
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Takudzwa Nhema");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, REPORT_PATH + "/register.html");
        } else {
            JasperExportManager.exportReportToPdfFile(jasperPrint, REPORT_PATH + "/register.pdf");
        }

        return "report generated in path " + REPORT_PATH;

    }
}
