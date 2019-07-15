package com.duckduckgo.features;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageObject {

	private WebDriver driver;
	private final static String baseUrl = "https://duckduckgo.com/";;

	@Before
	public void tearUp() {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void emptyField(String id) {
		findElementById(id).clear();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void browseWeb() {
		driver.get(baseUrl);
	}
	
	public WebElement find(By by) {
		return driver.findElement(by);
	}
	
	public WebElement findElementById(String id) {
		return find(By.id(id));
	}
	
	public WebElement findElementByXPath(String xPath) {
		return find(By.xpath(xPath));
	}

	// Find element
	public void typeIntoById(String id, String val) {
		findElementById(id).sendKeys(val);
	}

	public void typeIntoByName(String name, String val) {
		find(By.name(name)).sendKeys(val);
	}

	public void typeIntoByClassName(String className, String val) {
		find(By.className(className)).sendKeys(val);
	}

	public void typeIntoByXPath(String xpathExpression, String val) {
		findElementByXPath(xpathExpression).sendKeys(val);
	}

	// Click element
	public void ClickById(String id) {
		findElementById(id).click();
	}

	public void ClickByName(String name) {
		find(By.name(name)).click();
	}

	public void ClickByClassName(String className) {
		find(By.className(className)).click();
	}

	public void ClickByXPath(String xpathExpression) {
		findElementByXPath(xpathExpression).click();
	}
}
