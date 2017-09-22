package by.htp.email.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import by.htp.email.utils.Locators;

public class InBoxPage extends Page {
	
	private static final By LOGOUT_LOCATOR = Locators.getLocator("xpath.logout");
	private static final By BUTTON_WRITE_EMAIL = Locators.getLocator("xpath.button_write_email");
	
	
	public InBoxPage(WebDriver driver) {
		super(driver);		
	}

	public WriteEmailPage startWrittingEmail() {
		driver.navigate().refresh();
		clickElement (BUTTON_WRITE_EMAIL);	
		return new WriteEmailPage(driver);
	}	
	
	public MainPage logOut() {
		driver.navigate().refresh();
		clickElement (LOGOUT_LOCATOR);
		return new MainPage(driver);
	}	
}
