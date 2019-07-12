package com.duckduckgo.features;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TestCheckWebPageTitleUsingAssertj extends PageObject {

	@Test
	public void testTitleEquals() {
		browseWeb();
		typeIntoById("search_form_input_homepage", "Selenium Vietnam");
		ClickById("search_button_homepage");
		// check something: Web page title

		String acutalTitle = getDriver().getTitle();
		String actualExpect = "Selenium Vietnam at DuckDuckGo";
		// Verify
		assertThat(acutalTitle).isEqualTo(actualExpect);
	}

	@Test
	public void testTitleNotEquals() {
		browseWeb();
		typeIntoById("search_form_input_homepage", "Selenium Vietnam");
		ClickById("search_button_homepage");

		String actualString = getDriver().getTitle();
		String expectedString = "SeleniumVietnam";

		// Verify
		assertThat(actualString).isNotEqualTo(expectedString);
	}

	@Test
	public void testTitleContains() {
		browseWeb();
		typeIntoById("search_form_input_homepage", "Selenium Vietnam");
		ClickById("search_button_homepage");

		String actualString = getDriver().getTitle();
		String expectedString = "Seleniumvn";

		// Verify
		assertThat(actualString).contains(expectedString);
	}
}
