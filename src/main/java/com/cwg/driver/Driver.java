package com.cwg.driver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cwg.utils.BaseUtils;

public class Driver {

	public static WebDriver getDriverInstance(String browser) {
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		}

		else if (browser.equals("firefox")) {
			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.get().manage().window().setPosition(new Point(2000, 100));
		driver.manage().window().maximize();
		return driver;
	}

	public static void initDriver() throws IOException {
		LocalDriver.set(Driver.getDriverInstance(BaseUtils.getConfigValue("browser")));
		LocalDriver.get().get(BaseUtils.getConfigValue("url"));
	}

	public static void closeDriver(WebDriver driver) {
		driver.quit();
	}
}
