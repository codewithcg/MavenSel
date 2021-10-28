package com.orangehr.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cwg.pages.LoginPage;
import com.cwg.utils.CommonUtils;

public class TestDemo extends BaseTest {

	@Test(dataProvider = "dataProvider")
	public void test01(Map<String, String> data) throws Exception {
		new LoginPage().EnterUsername(CommonUtils.getKeyValues(data.get("TestData")).get("Username"));
		Assert.assertEquals("Lakshmi", "Lakshmi");
	}

	@Test(dataProvider = "dataProvider")
	public void test02(Map<String, String> data) throws Exception {
		new LoginPage().EnterUsername(CommonUtils.getKeyValues(data.get("TestData")).get("Username"));
		Assert.assertEquals("Lakshmi", "Lakshmi");
	}

	// @Test(dataProvider = "data")
	public void test01(String user) throws Exception {
		new LoginPage().EnterUsername(user);
		Assert.assertEquals("Lakshmi", "Lakshmi");
	}

	// @Test(dataProvider = "data")
	public void test02(String data2) throws Exception {
		new LoginPage().EnterUsername(data2);
		Assert.assertEquals("Lakshmi", "Lakshmi");
	}

	@DataProvider(name = "data")
	public Object[][] getDatalocal() {
		return new Object[][] { { "TestUse" } };
	}

}
