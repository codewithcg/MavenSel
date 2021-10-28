package com.orangehr.tests;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import com.cwg.driver.Driver;
import com.cwg.driver.LocalDriver;


public class WebDriverListener implements IInvokedMethodListener {

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		if (method.isTestMethod()) {			
			WebDriver driver = Driver.getDriverInstance("chrome");
			LocalDriver.set(driver);
		}
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		if (method.isTestMethod()) {
			WebDriver driver = LocalDriver.get();
			if (driver != null) {
				// driver.quit();
			}
		}
	}
}
