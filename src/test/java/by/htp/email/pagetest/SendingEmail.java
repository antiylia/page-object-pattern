package by.htp.email.pagetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.htp.email.pages.InBoxPage;
import by.htp.email.pages.MainPage;
import by.htp.email.pages.WriteEmailPage;
import by.htp.email.utils.Locators;


public class SendingEmail {
	
	private WriteEmailPage writeEmailPage;
	private MainPage mainPage;
	private WebDriver driver;
	private InBoxPage inBoxPage;
	
	
	private static final By RESPONSE_LOCATOR = Locators.getLocator("xpath.response");
	private String letter = "-----";
	private String theme = "Антипирович Юлия ДЗ: Page Object Pattern";
	private String recipient = "sviatlana.zakharenka@gmail.com";
	// private String recipient = "tathtp@mail.ru";
	

	@BeforeClass
	public void init() {
		System.setProperty("webdriver.gecko.driver", "D:\\geckoDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		mainPage = new MainPage(driver);
		mainPage.open();
		writeEmailPage = mainPage.logIn().startWrittingEmail();
	}
		
	@Test
	public void sendsEmail() {
		writeEmailPage.writeEmail(recipient, theme, letter);
		WebElement responseEmailSent = driver.findElement(RESPONSE_LOCATOR);
		Assert.assertNotNull(responseEmailSent);	
	}	
		
	
	@AfterClass
    public void logoutExit() {	
		inBoxPage = writeEmailPage.comeTolistNewEmail();
		inBoxPage.logOut();
	//	inBoxPage.closeBrower();		
    }	
  
}
