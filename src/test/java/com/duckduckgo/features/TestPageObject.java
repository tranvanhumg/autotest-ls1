package com.duckduckgo.features;

import com.duckduckgo.steps.HomeSteps;
import com.duckduckgo.steps.OrderSteps;

public class TestPageObject {
	
	HomeSteps homeSteps;
	
	OrderSteps orderSteps;
	
	
	public void loginToApp() {
		
		homeSteps.login("abd@tét.com", "234");
		
		orderSteps.something();
		
	}

}
