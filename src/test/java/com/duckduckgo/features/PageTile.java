package com.duckduckgo.features;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageTile {
	
	@Test
	public void CheckPageTile() {
		
		System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
		// test code open browser
		WebDriver chromeDriver = new ChromeDriver(); 
		
		chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		chromeDriver.manage().window().maximize();
		// open a web page
		chromeDriver.get("https://duckduckgo.com/");
		// interact with any element on page
		try
		{
		chromeDriver.findElement(By.id("search_form_input_homepage")).sendKeys("Selenium Vietnam");
		chromeDriver.findElement(By.id("search_button_homepage")).click();
		// check something: Web page title
		
		String acutalTile = chromeDriver.getTitle();
		String actualExpect = "Selenium Vietnam at DuckDuckGo";
		// Verify
		assertEquals(acutalTile, actualExpect);		
		}
		finally {
			chromeDriver.close();
			chromeDriver.quit();
		} 
	}

}
