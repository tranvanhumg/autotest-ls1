package com.duckduckgo.pages;

import com.duckduckgo.features.PageObject;

public class HomePage extends PageObject{
	
	
	private String idUserString="ajd";
	
	public void enterUserName(String email) {
		typeIntoById(idUserString, email);
	}
	
	public void cleanEmptyFiled() {
		emptyField(idUserString);
	}

	public void enterPassword(String pwd) {
		typeIntoById("passwork", pwd);
		
	}
	
	

}
