package com.cwg.reports;

import com.aventstack.extentreports.ExtentTest;

public class LocalReportManager {

	private static ThreadLocal<ExtentTest> extentlog = new ThreadLocal<ExtentTest>();

	public static ExtentTest get() {
		return extentlog.get();
	}

	public static void set(ExtentTest log) {
		extentlog.set(log);
	}

}
