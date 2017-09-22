package by.htp.email.pagetest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.htp.email.pages.InBoxPage;
import by.htp.email.pages.MainPage;
import by.htp.email.utils.Locators;
import by.htp.email.utils.UtilTest;

public class LogInTest {

	private MainPage mainPage;
	private WebDriver driver;
	private InBoxPage inBoxPage;
	
	private static final By EXIT = Locators.getLocator("xpath.for_test_exit");

	@BeforeClass
	public void init() {
		System.setProperty("webdriver.gecko.driver", "D:\\geckoDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		mainPage = new MainPage(driver);
	}

	@Test
	public void logOutIsFound() {

		mainPage.open();
		inBoxPage = mainPage.logIn();
		driver.navigate().refresh();
		
		WebElement elementLogOut = UtilTest.findElement(driver, EXIT);	
		assertNotNull(inBoxPage);
		assertEquals("выход", elementLogOut.getText());
	}

	@AfterClass
	public void logout() {
		if (inBoxPage !=null) {
		   inBoxPage.logOut();
		 //  mainPage.closeBrower();
		}
	
	}
	
	
}
