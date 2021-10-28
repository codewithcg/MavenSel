package com.cwg.actions;

import org.openqa.selenium.By;

import com.cwg.reports.Log;

public class SeleniumActions extends Finder {

	public void click(String elementName, By element) throws Exception {
		try {
			findElement(element).click();
			Log.info(elementName + "was clicked");
		} catch (Exception e) {
			Log.info("An exception was caught while clicking : " + elementName);
			throw e;
		}

	}

	public void enterText(String elementName, By element, String text) throws Exception {
		try {
			findElement(element).sendKeys(text);
			Log.info(text + " was entered in the field : " + elementName);
		} catch (Exception e) {
			Log.info("An exception was caught while entering text in : " + elementName);
			throw e;
		}

	}

}
