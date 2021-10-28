package com.cwg.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.cwg.driver.LocalDriver;


public class Finder {

	public WebElement findElement(By element) {
		return LocalDriver.get().findElement(element);
	}
}
