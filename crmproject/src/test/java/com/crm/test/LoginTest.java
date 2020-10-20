package com.crm.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.LoginPage;

public class LoginTest extends TestBase {

	LoginPage loginPage;

	public LoginTest() {

		super();

	}

	@BeforeMethod
	public void setup() {
		initilisation();
		loginPage = new LoginPage();
	}

	@Test
	public void loginTest() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod(enabled = false)
	public void teardown() {
		driver.close();
	}

}
