package by.htp.email.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UtilTest {
		
	public static WebElement findElement (WebDriver driver, By xPath) {
		WebElement element = driver.findElement(xPath);
		return element;
	}
	

}
