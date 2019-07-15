package com.duckduckgo.steps;

import com.duckduckgo.pages.HomePage;

public class HomeSteps {
	
	HomePage onHomePage;
	
	public void login(String email, String pwd) {
		onHomePage.enterUserName(email);
		onHomePage.enterPassword(pwd);
	}
	
	public void loginWithEmptyEmail(String email, String pwd) {
		onHomePage.cleanEmptyFiled();
		onHomePage.enterPassword(pwd);
	}

}
