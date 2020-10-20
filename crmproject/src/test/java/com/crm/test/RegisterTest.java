package com.crm.test;

import org.openqa.selenium.Alert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.RegisterCrm;
import com.crm.util.TestUtilCrm;

public class RegisterTest extends TestBase {

	RegisterCrm register;
	String sheetName = "Sheet1";

	public RegisterTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initilisation();
		register = new RegisterCrm();
	}

	@Test(priority = 1, enabled = false)
	public void registerTest() {
		register.register();

	}

	@DataProvider
	public Object[][] getRegisterTestData() {
		Object data[][] = TestUtilCrm.readSheet(sheetName);
		return data;

	}

	@Test(priority = 2, dataProvider = "getRegisterTestData")
	public void createNewAccount(String name, String email, String company, String phone, String country,
			String language, String comapny_size, String interest) {
		register.register();
		register.registerUser(name, email, company, phone, country, language, comapny_size, interest);

	}

	@AfterMethod
	public void tearDown() {
		//driver.close();
		
	}
}
