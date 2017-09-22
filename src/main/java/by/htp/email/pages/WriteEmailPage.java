package by.htp.email.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import by.htp.email.utils.Locators;

public class WriteEmailPage extends Page {
	
	private static final By RECEPIENT_LOCATOR = Locators.getLocator("xpath.recipient");
	private static final By THEME_LOCATOR = Locators.getLocator("xpath.theme");
	private static final By IFRAME_LOCATOR = Locators.getLocator("xpath.iframe");
	private static final By BUTTON_SEND = Locators.getLocator("xpath.button_send_email");
	private static final By BUTTON_NEW_EMAIL = Locators.getLocator("xpath.new_email");
	
	
	public WriteEmailPage(WebDriver driver) {
		super(driver);		
	}

	public void writeEmail (String recipient, String theme, String letter) {
		fillFormWithClick (RECEPIENT_LOCATOR, recipient);
		fillFormWithClick (THEME_LOCATOR, theme);
		fillEmailContent (letter);	
		clickElement (BUTTON_SEND);
	}
	
	
	private void fillEmailContent (String content) {
		WebElement iframe = driver.findElement(IFRAME_LOCATOR); 

		driver.switchTo().frame(iframe);
		driver.findElement(By.id("tinymce")).click();
		driver.findElement(By.id("tinymce")).sendKeys(content);
		driver.findElement(By.id("tinymce")).click();
		
		driver.switchTo().defaultContent();
	}

	public InBoxPage comeTolistNewEmail() {
		clickElement(BUTTON_NEW_EMAIL);
		return new InBoxPage(driver);
	}		
	
}
