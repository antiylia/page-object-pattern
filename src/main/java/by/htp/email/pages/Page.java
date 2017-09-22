package by.htp.email.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	protected final WebDriver driver;

	public Page (WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return this.driver;
	}	
	
	public void open(String url) {
		getDriver().get(url);
	}
	
	public WebDriver configureWindow () {
		driver.manage().window().maximize();
		return driver;
	}
	
	public WebDriver globalWait () {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		return driver;
	}
	
	public WebDriver waitSpecifiedElement (String xPathElement) {		
		Wait<WebDriver> wait = new WebDriverWait(driver, 20L, 1000L).withMessage("Element was not found");
	    wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(xPathElement))));
		return driver;
		
	}	
	
	protected WebDriver fillForm (By locator, String text) {
		driver.findElement(locator).sendKeys(text);
		return driver;
	}
	protected WebDriver fillFormWithClick (By locator, String text) {
		driver.findElement(locator).sendKeys(text);
		driver.findElement(locator).click();
		return driver;
	}
	
	protected WebDriver clickElement (By locator) {
		driver.findElement(locator).click();
		return driver;
	}	
		
	public void closeBrower () {
		driver.quit();
	}
	
	
}
