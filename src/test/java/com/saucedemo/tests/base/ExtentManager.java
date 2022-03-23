package com.saucedemo.tests.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.saucedemo.utill.Util;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;
    protected static final String USER_DIRECTORY = System.getProperty("user.dir");
    public static final String REPORTS_DIRECTORY = USER_DIRECTORY + "//reports/";

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }

    public static synchronized ExtentReports createInstance() {
        String fileName = Util.getReportName();
        String reportsDirectory = REPORTS_DIRECTORY;
        new File(reportsDirectory).mkdirs();
        String path = reportsDirectory + fileName;

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Automation Run");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);

        extent = new ExtentReports();
        extent.setSystemInfo("Organization","Hayblec");
        extent.setSystemInfo("Automation Framework","Selenium WebDriver");
        extent.attachReporter(htmlReporter);

        return extent;
    }

}
