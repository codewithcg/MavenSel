package com.orangehr.tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.cwg.driver.Driver;
import com.cwg.driver.LocalDriver;
import com.cwg.reports.LocalReportManager;
import com.cwg.reports.Reporting;
import com.cwg.utils.BaseUtils;

public class BaseTest {

	@BeforeSuite
	public void setUp() throws IOException {
		Reporting.initReporting();
	}

	@BeforeMethod
	public void initDriver(Method method) throws IOException {
		Driver.initDriver();
		Reporting.createTest(method.getName());
	}

	@AfterMethod
	public void quitDriver(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			LocalReportManager.get().fail(result.getThrowable(),
					MediaEntityBuilder.createScreenCaptureFromPath(BaseUtils.getScreenShotPath(LocalDriver.get(),
							result.getInstance().getClass().getSimpleName() + "." + result.getMethod().getMethodName()))
							.build());
		}
		LocalDriver.get().quit();
	}

	@AfterSuite
	public void tearDown() throws IOException {
		Reporting.extent.flush();
		// Desktop.getDesktop().browse(new File(Reporting.reportPath).toURI());
	}

	@DataProvider
	public Object[] dataProvider(Method method) {
		return DataProviderUtils.getData(method);
	}

}
