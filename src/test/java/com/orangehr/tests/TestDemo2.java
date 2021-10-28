package com.orangehr.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.cwg.pages.LoginPage;

public class TestDemo2 extends BaseTest {

	@Test
	public void test03() throws Exception {		
		new LoginPage().EnterUsername("TestUser");
		Assert.assertEquals("Lakshmi", "Lakshmi");
	}

	@Test
	public void test04() throws Exception {		
		new LoginPage().EnterUsername("TestUser");
		Assert.assertEquals("Lakshmi", "Lakshmi");
	}

}
