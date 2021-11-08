package com.qa.ExtentReporterNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.File;

public abstract class ExtentManager {
    private static String reportBaseDirectory;
    private static ExtentReports extent;
    public static final String OUTPUT_FOLDER_SCREENSHOTS ="/Screenshots/";
    public static final String REPORT_FILE_PATH =System.getProperty("C:\\Users\\Sachini Nayanathara\\Documents\\Projects\\SQA_Assignment_Test\\Automation");
    private static com.qa.ExtentReporterNG.ExtentManager ExtentManager;

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }
    //Create an extent report instance
    public static void createInstance() {
        ExtentManager.initDirectories();
        setReportBaseDirectory(REPORT_FILE_PATH);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(REPORT_FILE_PATH+"Test-Automaton-Report.html");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Automation Test Results");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setJS("$('.brand-logo').text('FarEye');");
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS",  System.getProperty("os.name"));
        extent.setSystemInfo("Java",  System.getProperty("java.specification.version"));
        extent.setSystemInfo("User",  System.getProperty("user.name"));
    }

    public synchronized static String getReportBaseDirectory() {
        return reportBaseDirectory;
    }
    public synchronized static void setReportBaseDirectory(String reportBaseDirectory) {
        ExtentManager.reportBaseDirectory = reportBaseDirectory;
    }

    public static void initDirectories() {
        try {
            createFolder(REPORT_FILE_PATH + OUTPUT_FOLDER_SCREENSHOTS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void createFolder(String folderPath) {
        File file = new File(folderPath);
        if (!file.exists()) file.mkdirs();
    }

    public abstract void onStart(ITestContext context);

    public abstract void onFinish(ITestContext context);

    public abstract void onTestStart(ITestResult result);

    public abstract void onTestSuccess(ITestResult result);

    public abstract void onTestFailure(ITestResult result);

    public abstract void onTestSkipped(ITestResult result);

    public abstract void onTestFailedButWithinSuccessPercentage(ITestResult result);
}
