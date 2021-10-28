package com.cwg.reports;

public class Log {

	public static void info(String message) {
		LocalReportManager.get().info(message);
	}

	public static void pass(String message) {
		LocalReportManager.get().pass(message);
	}

	public static void fail(String message) {
		LocalReportManager.get().fail(message);
	}

}
