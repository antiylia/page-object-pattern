package by.htp.email.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;

public class Locators {

	static FileInputStream fis;
	static Properties property = new Properties();

	/**
	 * Method returns locator (using Xpath) from property's file, according key
	 *
	 */
	public static By getLocator(String key) {
		String locatorStr = getValueAccodKey(key);
		By locator = By.xpath(locatorStr);
		return locator;
	}

	/**
	 * Method returns value from property's file, according key
	 *
	 */	
	public static String getValueAccodKey(String key) {
		String value = "";
		try {
			fis = new FileInputStream("src//main//java//locators.properties");
			property.load(fis);
			value = property.getProperty(key);

		} catch (IOException e) {
			System.err.println("ОШИБКА: Файл свойств не найден!");
		}
		return value;
	}

}
