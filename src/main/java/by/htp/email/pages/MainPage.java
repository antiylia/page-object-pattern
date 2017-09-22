package by.htp.email.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import by.htp.email.utils.Locators;

public class MainPage extends Page {

	private static final String URL = "https://mail.ru";

	private static final By LOGIN_LOCATOR = Locators.getLocator("xpath.loginfield");
	private static final By PASSWORD_LOCATOR = Locators.getLocator("xpath.passwordfield");
	private static final By SUBMIT_LOCATOR = Locators.getLocator("xpath.submit_button");
	
	
	
	public MainPage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		super.open(URL);
	}	
	
	public InBoxPage logIn() {
		waitSpecifiedElement(Locators.getValueAccodKey("xpath.logomailru"));
		
		fillForm (LOGIN_LOCATOR, "tathtp");
		fillForm (PASSWORD_LOCATOR, "Klopik123");
		clickElement (SUBMIT_LOCATOR);		
	  return new InBoxPage(driver);
	}	
	
}
