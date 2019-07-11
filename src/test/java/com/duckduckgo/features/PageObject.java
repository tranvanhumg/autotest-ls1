package com.duckduckgo.features;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {
	
	private  WebDriver chromedriver;
	@Before
	public void tearUp()
	{
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		chromedriver=new ChromeDriver();
		chromedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		chromedriver.manage().window().maximize();
	}
	@After
	public void tearDown()
	{
		chromedriver.quit();
	}
	public WebDriver getDriver()
	{
		return chromedriver;
	}
	
	public WebDriver getDriver(String urlString)
	{
		chromedriver.get(urlString);
		return chromedriver;
	}

}
