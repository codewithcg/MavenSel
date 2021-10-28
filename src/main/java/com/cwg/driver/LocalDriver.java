package com.cwg.driver;

import org.openqa.selenium.WebDriver;

public class LocalDriver {

	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	public static WebDriver get() {
		return webDriver.get();
	}

	public static void set(WebDriver driver) {
		webDriver.set(driver);
	}

}
