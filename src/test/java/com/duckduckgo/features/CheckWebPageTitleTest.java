package com.duckduckgo.features;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CheckWebPageTitleTest extends PageObject {

	@Test
	public void testTitleEquals() {

		browseWeb();

		// interact with any element on page
		typeIntoById("search_form_input_homepage", "Selenium Vietnam");
		ClickById("search_button_homepage"); 
		
		// check something: Web page title
		String acutalTitle = getDriver().getTitle();
		String actualExpect = "Selenium Vietnam at DuckDuckGo";

		// Verify
		assertEquals(acutalTitle, actualExpect);
	}


	public void testTitleNotEquals() {

		// set browser is Coccoc using chromeOptions
		// ChromeOptions options = new ChromeOptions();
		// options.setBinary("C:\\Users\\tranvan\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");
		// chromeDriver = new ChromeDriver(options);

		browseWeb();

		// find element
		typeIntoById("search_form_input_homepage", "Selenium Vietnam");
		ClickById("search_button_homepage");

		String actualString = getDriver().getTitle();
		String expectedString = "SeleniumVietnam";

		// Verify
		assertNotEquals(actualString, expectedString);
	}

	
	public void testTitleContains() {

		browseWeb();
		// find element
		typeIntoById("search_form_input_homepage", "Selenium Vietnam");
		ClickById("search_button_homepage");

		String actualString = getDriver().getTitle();
		String expectedString = "Seleniumvn";

		// Verify
		// "Page title is contain "+expectedString,
		assertTrue(actualString.contains(expectedString));
	}
}