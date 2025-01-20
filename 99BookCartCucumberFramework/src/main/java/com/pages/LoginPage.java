/**
 * @author Ravikumar Lubdhi
 * https://www.linkedin.com/in/ravikumar-lubdhi/
 * https://github.com/ravikumarsl
 **/

package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;

	// 1. By Locators: OR
	private By clickLoginAcc = By.xpath("//*[name()='path' and contains(@d,'M256 288c7')]");
	private By emailId = By.xpath("(//input[@id='outlined-basic'])[1]");
	private By password = By.xpath("(//input[@id='outlined-basic'])[2]");
	private By signInButton = By.cssSelector("button[type='submit']");
	private By forgotPwdLink = By.linkText("Forgot password?");

	// 2. Constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page the form of methods:

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public String getLoginPageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 10); // 10-second wait
		wait.until(ExpectedConditions.titleContains("Login"));
		return driver.getTitle();
	}

	public void clickLoginAccount() {
		WebDriverWait wait = new WebDriverWait(driver, 30); // 10-second wait
		WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(clickLoginAcc));
		loginButton.click();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnLoginButton() {
		driver.findElement(signInButton).click();
		WebDriverWait wait = new WebDriverWait(driver, 10); // 10-second wait
		wait.until(ExpectedConditions.titleContains("Home to India's Best Book Boxes"));
	}

	public SearchBooksPage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(clickLoginAcc).click();
		driver.findElement(signInButton).click();
		return new SearchBooksPage(driver);
	}


}
