/**
 * @author Ravikumar Lubdhi
 * https://www.linkedin.com/in/ravikumar-lubdhi/
 * https://github.com/ravikumarsl
 **/

package com.qa.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	/*
	 * This method is used to initialize the thradlocal driver on the basis of given browser
	 * @param browser
	 * @return this will return tldriver.
	 */
	public WebDriver init_driver(String browser) {

		System.out.println("browser is: " + browser);

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ravikumar\\Documents\\Drivers\\chromedriver.exe");
			WebDriver getDriver = new ChromeDriver();
			//options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			//WebDriver getDriver = new ChromeDriver(options);
			tlDriver.set(getDriver);
			//tlDriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equals("safari")) {
			tlDriver.set(new SafariDriver());
		} else {
			System.out.println("Please provide the correct browser: " + browser);
		}

		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}
	public static synchronized WebDriver getDriver() {
		WebDriver driver = tlDriver.get();

		// Add implicit wait here
		if (driver != null) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		return driver;
	}
}
