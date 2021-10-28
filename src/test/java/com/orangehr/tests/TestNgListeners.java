package com.orangehr.tests;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.cwg.driver.Driver;
import com.cwg.driver.LocalDriver;
import com.cwg.utils.BaseUtils;
import com.cwg.reports.LocalReportManager;

public class TestNgListeners implements ITestListener {

	ExtentReports extent;
	ExtentTest log;

	@Override
	public void onTestStart(ITestResult result) {
		// ITestListener.super.onTestStart(result);
		try {
			LocalDriver.set(Driver.getDriverInstance(BaseUtils.getConfigValue("browser")));
			LocalDriver.get().get(BaseUtils.getConfigValue("url"));
			log = extent.createTest(result.getMethod().getMethodName());
			LocalReportManager.set(log);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
