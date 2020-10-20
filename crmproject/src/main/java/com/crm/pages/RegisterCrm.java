package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class RegisterCrm extends TestBase {

	WebElement element;
	private By tryit = By.xpath("//a[@class='btn btn-primary btn-lg'][contains(text(),'Start Now')]");
	//private By tryit = By.xpath("//a[@class='btn btn-primary']");
	private By crm = By.xpath(
			"//body/div[@id='wrapwrap']/main/div[@class='subscription-widget']/div[@class='subscription-widget-container bg-white']/div[@class='container']/div[@class='row choose-app-step o_trial_step_1']/div[@class='choose-app-list col-12 col-lg-10 offset-lg-1 mt24 o_animate_in_children o_visible']/div[1]/label[1]/div[1]");

	private By cont = By
			.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]");

	private By first_Name = By.xpath("//input[@id='username']");
	private By email = By.xpath("//input[@id='email']");
	private By company = By.xpath("//input[@id='company-name']");
	private By phone = By.xpath("//input[@id='phone']");
	private By country = By.xpath("//select[@id='country-id']");
	private By language = By.xpath("//select[@name='lang']");
	private By company_Size = By.xpath("//select[@name='company_size']");
	private By interest = By.xpath("//select[@id='plan']");

	public WebElement getFirst_Name() {
		return getElement(first_Name);
	}

	public WebElement getEmail() {
		return getElement(email);
	}

	public WebElement getCompany() {
		return getElement(company);
	}

	public WebElement getPhone() {
		return getElement(phone);
	}

	public WebElement getCountry() {
		return getElement(country);
	}

	public WebElement getLanguage() {
		return getElement(language);
	}

	public WebElement getCompany_Size() {
		return getElement(company_Size);
	}

	public WebElement getInterest() {
		return getElement(interest);
	}

	public WebElement getTryit() {

		return getElement(tryit);
	}

	public WebElement getCrm() {
		return getElement(crm);
	}

	public WebElement getCont() {
		return getElement(cont);
	}

	public RegisterCrm() {
		PageFactory.initElements(driver, this);
	}

	public void register() {
		getTryit().click();
		getCrm().click();
		getCont().click();

	}

	public void registerUser(String name, String email, String company, String phone, String country, String language,
			String comapny_size, String interest) {
		getFirst_Name().sendKeys(name);
		getEmail().sendKeys(email);
		getCompany().sendKeys(company);
		getPhone().sendKeys(phone);
		element = getCountry();
		getSelectElement(element, country);
		element = getLanguage();
		getSelectElement(element, language);
		element = getCompany_Size();
		getSelectElement(element, comapny_size.trim());
		element = getInterest();
		getSelectElement(element, interest.trim());

	}

}
