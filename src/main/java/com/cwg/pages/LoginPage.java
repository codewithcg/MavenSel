package com.cwg.pages;

import org.openqa.selenium.By;

import com.cwg.actions.SeleniumActions;

public class LoginPage extends SeleniumActions {

	By username = By.id("txtUsername");

	public void EnterUsername(String user) throws Exception {
		enterText("User name", username, user);
		findElement(username);
	}

}
