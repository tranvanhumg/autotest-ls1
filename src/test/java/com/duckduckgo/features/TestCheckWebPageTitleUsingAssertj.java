package com.duckduckgo.features;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCheckWebPageTitleUsingAssertj {
	private WebDriver chromeDriver;

	@Before
	public void tearUp() {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");

		chromeDriver = new ChromeDriver();

		chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		chromeDriver.manage().window().maximize();

		// open a web page
		chromeDriver.get("https://duckduckgo.com/");

	}

	@After
	public void tearDown() {
		chromeDriver.quit();
	}

	@Test
	public void testTitleEquals() {

		chromeDriver.findElement(By.id("search_form_input_homepage")).sendKeys("Selenium Vietnam");
		chromeDriver.findElement(By.id("search_button_homepage")).click();
		// check something: Web page title

		String acutalTitle = chromeDriver.getTitle();
		String actualExpect = "Selenium Vietnam at DuckDuckGo";
		// Verify
		assertThat(acutalTitle).isEqualTo(actualExpect);
	}

	@Test
	public void testTitleNotEquals() {

		chromeDriver.findElement(By.id("search_form_input_homepage")).sendKeys("Selenium Vietnam");
		chromeDriver.findElement(By.id("search_button_homepage")).click();

		String actualString = chromeDriver.getTitle();
		String expectedString = "SeleniumVietnam";

		// Verify
		assertThat(actualString).isNotEqualTo(expectedString);
	}

	@Test
	public void testTitleContains() {

		chromeDriver.findElement(By.id("search_form_input_homepage")).sendKeys("Selenium Vietnam");
		chromeDriver.findElement(By.id("search_button_homepage")).click();

		String actualString = chromeDriver.getTitle();
		String expectedString = "Seleniumvn";

		// Verify
		assertThat(actualString).contains(expectedString);
	}
}
