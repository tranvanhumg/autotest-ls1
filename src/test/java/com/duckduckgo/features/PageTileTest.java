package com.duckduckgo.features;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageTileTest {
	
	@Test
	public void see_page_tile_is_correct() {
		
		System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
		// test code open browser
		WebDriver chromeDriver = new ChromeDriver(); 
		
		chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		chromeDriver.manage().window().maximize();
		// open a web page
		chromeDriver.get("https://duckduckgo.com/");
		// interact with any element on page
		
		chromeDriver.findElement(By.id("search_form_input_homepage")).sendKeys("Selenium Vietnam");
		chromeDriver.findElement(By.id("search_button_homepage")).click();
		// check something: Web page title
		
		String acutalTile = chromeDriver.getTitle();
		String actualExpect = "Selenium Vietnam at DuckDuckGo";
		// Verify
		assertEquals(acutalTile, actualExpect);		
		
			chromeDriver.close();
			chromeDriver.quit();
		
	}
	@Test
public void see_page_tile_is_not_correct() {
		
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		
		chromeDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		chromeDriver.manage().window().maximize();
		
		chromeDriver.get("https://duckduckgo.com/");
		//find element
		
			chromeDriver.findElement(By.id("search_form_input_homepage")).sendKeys("Selenium Vietnam");
			chromeDriver.findElement(By.id("search_button_homepage")).click();
			
			String actualString =chromeDriver.getTitle();
			String expectedString = "SeleniumVietnam";
			
			//Verify
			assertNotEquals(actualString, expectedString);
					
			chromeDriver.close();
			chromeDriver.quit();
}
	@Test
public void see_page_tile_contain_correct() {
	
	System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
	WebDriver chromeDriver = new ChromeDriver();
	
	chromeDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	chromeDriver.manage().window().maximize();
	
	chromeDriver.get("https://duckduckgo.com/");
	//find element
	
		chromeDriver.findElement(By.id("search_form_input_homepage")).sendKeys("Selenium Vietnam");
		chromeDriver.findElement(By.id("search_button_homepage")).click();
		
		String actualString =chromeDriver.getTitle();
		String expectedString = "Seleniumvn";
		
		//Verify
		//"Page tile is contain "+expectedString,
	    assertTrue(actualString.contains(expectedString));

		chromeDriver.close();
		chromeDriver.quit();
					
}
}