package com.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.util.WebEventListener;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	public static EventFiringWebDriver eventFiring;
	public static WebEventListener eventListner;
	FileInputStream file;

	public TestBase() {
		prop = new Properties();

		try {
			file = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/crm/config/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initilisation() {
		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"E://eclipse-java-2019-09-R-win32-x86_64//chromedriver_win32 (4)//chromedriver.exe");
			driver = new ChromeDriver();

		}
		// to register for eventlistner
		eventFiring = new EventFiringWebDriver(driver);
		eventListner = new WebEventListener();
		eventFiring.register(eventListner);
		driver = eventFiring;
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}

	public static WebElement getElement(By locator) {
		WebElement element = null;
		waitForElementPresent(locator);

		element = driver.findElement(locator);

		return element;
	}

	public static void getSelectElement(WebElement locator, String value) {
		// waitForElementPresent(locator);
		Select select = new Select(locator);
		select.selectByVisibleText(value);

	}

	public static void waitForElementPresent(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		// wait.until(ExpectedConditions.visibilityOf((WebElement) locator));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		wait.until(ExpectedConditions.elementToBeClickable(locator));

	}

}
