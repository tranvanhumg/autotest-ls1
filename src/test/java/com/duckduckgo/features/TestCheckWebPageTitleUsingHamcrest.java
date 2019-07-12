package com.duckduckgo.features;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

import org.junit.Test;

public class TestCheckWebPageTitleUsingHamcrest extends PageObject {

	@Test
	public void testTitleEquals() {
		browseWeb();
		typeIntoById("search_form_input_homepage", "Selenium Vietnam");
		ClickById("search_button_homepage");
		// check something: Web page title

		String acutalTitle = getDriver().getTitle();
		String actualExpect = "Selenium Vietnam at DuckDuckGo";
		// Verify
		assertThat(acutalTitle, is(equalTo(actualExpect)));
	}

	@Test
	public void testTitleNotEquals() {
		browseWeb();
		typeIntoById("search_form_input_homepage", "Selenium Vietnam");
		ClickById("search_button_homepage");

		String actualString = getDriver().getTitle();
		String expectedString = "SeleniumVietnam";

		// Verify
		assertThat(actualString, is(not(equalTo(expectedString))));
	}

	@Test
	public void testTitleContains() {
		browseWeb();
		typeIntoById("search_form_input_homepage", "Selenium Vietnam");
		ClickById("search_button_homepage");

		String actualString = getDriver().getTitle();
		String expectedString = "Seleniumvn";

		// Verify
		assertThat(actualString, containsString(expectedString));
	}
}
