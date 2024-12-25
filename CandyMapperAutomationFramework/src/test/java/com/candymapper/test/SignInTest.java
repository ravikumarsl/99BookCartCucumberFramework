package com.candymapper.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.candymapper.base.TestBase;
import com.candymapper.pages.SignInPage;

public class SignInTest extends TestBase {
	
	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(TestBase.class.getName());

	@BeforeTest
	public void initialize() throws IOException  {
		setUp(null);
		loadProperties();  // Explicitly load properties here
	    driver = TestBase.getDriver();
	    Log.info("Driver is initialized");
	    String url = prop.getProperty("baseUrl"); // Now this will not throw null
	    driver.get(url);
	    Log.info("Navigated to url");
	}

@Test(priority = 1, description = "TC01_SignInTest", groups = {"REGRESSION"})
public void SignIn() throws InterruptedException {
	Log.info("Verifying successful sign-in");

	SignInPage signin = new SignInPage(driver);

	// Verify the title of the page
	String actualTitle = getDriver().getTitle();
	String expectedTitle = "CandyMapper.Com"; // Adjust as per actual expected title
	Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");
	System.out.println(actualTitle + " Page title matched!");
	signin.Account().click();
	signin.Login().click();
	signin.Username().sendKeys("ravikumar.test@gmail.com"); //dummy user
	signin.Password().sendKeys("Admin@1234"); //dummy password
	signin.Submit().click();
	Thread.sleep(2000);
	Log.info("Successfully Signin in!");

}

@AfterTest
public void tearDown() {
	if (getDriver() != null) {
		getDriver().quit();
	}
}
}


