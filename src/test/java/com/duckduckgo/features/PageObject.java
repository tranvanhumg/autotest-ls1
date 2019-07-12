package com.duckduckgo.features;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {

	private WebDriver chromedriver;
	private final static String baseUrl = "https://duckduckgo.com/";;

	@Before
	public void tearUp() {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		chromedriver = new ChromeDriver();
		chromedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		chromedriver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		chromedriver.quit();
	}

	public WebDriver getDriver() {
		return chromedriver;
	}

	public void browseWeb() {
		chromedriver.get(baseUrl);
	}

	// Find element
	public void typeIntoById(String id, String val) {
		getDriver().findElement(By.id(id)).sendKeys(val);
	}

	public void typeIntoByName(String name, String val) {
		getDriver().findElement(By.name(name)).sendKeys(val);
	}

	public void typeIntoByClassName(String className, String val) {
		getDriver().findElement(By.name(className)).sendKeys(val);
	}

	public void typeIntoByXPath(String xpathExpression, String val) {
		getDriver().findElement(By.name(xpathExpression)).sendKeys(val);
	}

	// Click element
	public void ClickById(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public void ClickByName(String name) {
		getDriver().findElement(By.name(name)).click();
	}

	public void ClickByClassName(String className) {
		getDriver().findElement(By.className(className)).click();
	}

	public void ClickByXPath(String xpathExpression) {
		getDriver().findElement(By.xpath(xpathExpression)).click();
	}
}
