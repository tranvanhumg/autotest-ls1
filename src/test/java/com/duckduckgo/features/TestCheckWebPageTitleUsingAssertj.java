package com.duckduckgo.features;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.openqa.selenium.By;

public class TestCheckWebPageTitleUsingAssertj extends PageObject {
	
	String urlString = "https://duckduckgo.com/";
	
	@Test
	public void testTitleEquals() {
		getDriver(urlString);
		getDriver().findElement(By.id("search_form_input_homepage")).sendKeys("Selenium Vietnam");
		getDriver().findElement(By.id("search_button_homepage")).click();
		// check something: Web page title

		String acutalTitle = getDriver().getTitle();
		String actualExpect = "Selenium Vietnam at DuckDuckGo";
		// Verify
		assertThat(acutalTitle).isEqualTo(actualExpect);
	}

	@Test
	public void testTitleNotEquals() {
		getDriver(urlString);
		getDriver().findElement(By.id("search_form_input_homepage")).sendKeys("Selenium Vietnam");
		getDriver().findElement(By.id("search_button_homepage")).click();

		String actualString = getDriver().getTitle();
		String expectedString = "SeleniumVietnam";

		// Verify
		assertThat(actualString).isNotEqualTo(expectedString);
	}

	@Test
	public void testTitleContains() {
		getDriver(urlString);
		getDriver().findElement(By.id("search_form_input_homepage")).sendKeys("Selenium Vietnam");
		getDriver().findElement(By.id("search_button_homepage")).click();

		String actualString = getDriver().getTitle();
		String expectedString = "Seleniumvn";

		// Verify
		assertThat(actualString).contains(expectedString);
	}
}
