package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class LoginPage extends TestBase {

	private By signin = By.xpath("//a[contains(text(),'Sign in')]");
	private By username = By.xpath("//input[@id='login']");
	private By password = By.xpath("//input[@id='password']");
	private By login_Button = By.xpath("//button[@class='btn btn-primary float-left']");
	private By drop_down = By.xpath("//span[@class='d-md-none d-lg-inline-block']");
	private By my_DataBase = By.xpath("//a[contains(text(),'My Databases')]");
	private By connect = By.xpath("//a[@class='btn btn-primary'][text()='Connect']");
	private By crm = By.xpath("//a[4]//div[1]");

	public WebElement getDrop_down() {
		return getElement(drop_down);
	}

	public WebElement getMy_DataBase() {
		return getElement(my_DataBase);
	}

	public WebElement getConnect() {
		return getElement(connect);
	}

	public WebElement getCrm() {
		return getElement(crm);
	}

	public WebElement getSignin() {
		return getElement(signin);
	}

	public WebElement getUsername() {
		return getElement(username);
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	public WebElement getLogin_Button() {
		return getElement(login_Button);
	}

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void login(String user, String pass) {
		Actions ac = new Actions(driver);
		getSignin().click();
		getUsername().sendKeys(user);
		getPassword().sendKeys(pass);
		getLogin_Button().click();
		ac.moveToElement(getDrop_down()).click().perform();
		ac.moveToElement(getMy_DataBase()).click().perform();
		getUsername().sendKeys(user);
		getPassword().sendKeys(pass);
		getLogin_Button().click();

		// getMy_DataBase().click();
		getConnect().click();
		getCrm().click();
	}

}
