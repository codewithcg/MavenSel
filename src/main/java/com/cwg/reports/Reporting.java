package com.cwg.reports;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cwg.utils.BaseUtils;

public class Reporting {

	public static ExtentReports extent;
	public static String reportPath;

	public static ExtentReports initReporting() throws IOException {

		extent = new ExtentReports();
		String time = String.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyy hh.mm a")));
		reportPath = BaseUtils.getConfigValue("report_path") + BaseUtils.getConfigValue("product") +" "+ time + ".html";
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("CWG Test Report");
		spark.config().setReportName("CWG Tutorials");

		return extent;
	}

	public void generateReport() {
		extent.flush();
	}

	public static void createTest(String methodName) {
		LocalReportManager.set(extent.createTest(methodName));
	}

}
