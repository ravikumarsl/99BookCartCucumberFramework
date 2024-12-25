package com.candymapper.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private static final Logger log = LogManager.getLogger(SignInPage.class);

	By account = By.id("4");
	By login = By.id("n-5044950488-membership-sign-in");
	By user = By.className("email");
	By pass = By.className("password");
	By submit = By.xpath("//button[normalize-space()='Sign in']");
	
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5);
	}

	public WebElement Account()
	{
		return driver.findElement(account);

	}
	
	public WebElement Login()
	{
		return driver.findElement(login);

	}
	
	public WebElement Username()
	{
		return driver.findElement(user);

	}

	public WebElement Password()
	{
		return driver.findElement(pass);

	}
	
	public WebElement Submit()
	{
		return driver.findElement(submit);

	}
	
}


