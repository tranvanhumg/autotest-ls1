package com.duckduckgo.features;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckWebPageTitleTest {

	private WebDriver chromeDriver;

	@Before
	public void tearUp() {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");

		chromeDriver = new ChromeDriver();

		chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		chromeDriver.manage().window().maximize();

	}

	@After
	public void tearDown() {
		chromeDriver.quit();
	}

	@Test
	public void testTitleEquals() {

		// open a web page
		chromeDriver.get("https://duckduckgo.com/");
		// interact with any element on page

		chromeDriver.findElement(By.id("search_form_input_homepage")).sendKeys("Selenium Vietnam");
		chromeDriver.findElement(By.id("search_button_homepage")).click();
		// check something: Web page title

		String acutalTitle = chromeDriver.getTitle();
		String actualExpect = "Selenium Vietnam at DuckDuckGo";
		// Verify
		assertEquals(acutalTitle, actualExpect);
	}

	@Test
	public void testTitleNotEquals() {

		// set browser is Coccoc using chromeOptions
		// ChromeOptions options = new ChromeOptions();
		// options.setBinary("C:\\Users\\tranvan\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");
		// chromeDriver = new ChromeDriver(options);

		chromeDriver.get("https://duckduckgo.com/");
		// find element

		chromeDriver.findElement(By.id("search_form_input_homepage")).sendKeys("Selenium Vietnam");
		chromeDriver.findElement(By.id("search_button_homepage")).click();

		String actualString = chromeDriver.getTitle();
		String expectedString = "SeleniumVietnam";

		// Verify
		assertNotEquals(actualString, expectedString);
	}

	@Test
	public void testTitleContains() {

		chromeDriver.get("https://www.google.com.vn/");
		// find element

		chromeDriver.findElement(By.name("q")).sendKeys("Selenium Vietnam");
		chromeDriver.findElement(By.name("btnK")).click();

		String actualString = chromeDriver.getTitle();
		String expectedString = "Seleniumvn";

		// Verify
		// "Page title is contain "+expectedString,
		assertTrue(actualString.contains(expectedString));
	}
}