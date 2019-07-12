package com.duckduckgo.features;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
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

	public void openDriver() {
		chromedriver.get(baseUrl);
	}

}
