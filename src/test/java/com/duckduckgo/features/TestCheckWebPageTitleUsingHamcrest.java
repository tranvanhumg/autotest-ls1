package com.duckduckgo.features;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

import org.junit.Test;
import org.openqa.selenium.By;

public class TestCheckWebPageTitleUsingHamcrest extends PageObject {

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
		assertThat(acutalTitle, is(equalTo(actualExpect)));
	}

	@Test
	public void testTitleNotEquals() {
		getDriver(urlString);
		getDriver().findElement(By.id("search_form_input_homepage")).sendKeys("Selenium Vietnam");
		getDriver().findElement(By.id("search_button_homepage")).click();

		String actualString = getDriver().getTitle();
		String expectedString = "SeleniumVietnam";

		// Verify
		assertThat(actualString, is(not(equalTo(expectedString))));
	}

	@Test
	public void testTitleContains() {
		getDriver(urlString);
		getDriver().findElement(By.id("search_form_input_homepage")).sendKeys("Selenium Vietnam");
		getDriver().findElement(By.id("search_button_homepage")).click();

		String actualString = getDriver().getTitle();
		String expectedString = "Seleniumvn";

		// Verify
		assertThat(actualString, containsString(expectedString));
	}
}
