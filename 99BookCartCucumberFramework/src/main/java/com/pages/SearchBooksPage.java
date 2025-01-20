/**
 * @author Ravikumar Lubdhi
 * https://www.linkedin.com/in/ravikumar-lubdhi/
 * https://github.com/ravikumarsl
 **/

package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchBooksPage {

	private WebDriver driver;
	
	private By emailId = By.xpath("(//input[@id='outlined-basic'])[1]");
	private By password = By.xpath("(//input[@id='outlined-basic'])[2]");
	private By signInButton = By.cssSelector("button[type='submit']");
	
	private By searchIcon = By.cssSelector("svg[aria-label='search']");
	private By searchBooks = By.cssSelector("input[placeholder='Title,Author & ISBN']");
	private By enter = By.cssSelector("button[type='submit']");
	private By clickProduct = By.cssSelector("body main div div div div div:nth-child(2) a div span");
	private By addTo = By.cssSelector(".btn-primary.addtocart");
	private By added = By.cssSelector(".MuiTypography-root.MuiTypography-subtitle");
	private By openCart = By.cssSelector("a[name='cart'] svg path");
	private By verifyfirstitem = By.cssSelector(".cart-item-title");
	private By priceOfFirst = By.xpath("(//span[@class='cart-productPrice'])[1]");
	private By verifyseconditem = By.xpath("//div[normalize-space()='Shadows of the Workhouse-1']");
	private By priceOfSecond = By.xpath("(//span[@class='cart-productPrice'])[2]");
	private By priceOfThird = By.xpath("(//span[@class='cart-productPrice'])[3]");
	private By priceOfFourth = By.xpath("(//span[@class='cart-productPrice'])[4]");
	private By priceOfFifth = By.xpath("(//span[@class='cart-productPrice'])[5]");
	private By nonFiction = By.linkText("Non Fiction");
	private By genres = By.cssSelector("body > div:nth-child(2) > main > div > div:nth-child(3) > a:nth-child(2) > span");
	private By addSecondItem = By.xpath("(//button[@type='button'][normalize-space()='Add'])[1]");
	private By addThirdItem = By.xpath("(//button[@type='button'][normalize-space()='Add'])[1]");
	private By addFourthItem = By.xpath("(//button[@type='button'][normalize-space()='Add'])[1]");
	private By addFifthItem = By.xpath("(//button[@type='button'][normalize-space()='Add'])[1]");
	private By totalPrice = By.cssSelector("div.col-sm-4.col-12 div:nth-of-type(2) strong span");
	
	

	public SearchBooksPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}

	public void clickSearchIcon() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 10); // 10-second wait
		WebElement clickSearch = wait.until(ExpectedConditions.elementToBeClickable(searchIcon));
		clickSearch.click();
	}
	
	public void clickOnSearch(String books) {
		driver.findElement(searchBooks).sendKeys(books + Keys.ENTER);
	}
	
	public void enterSearch() {
		WebDriverWait wait = new WebDriverWait(driver, 10); // 10-second wait
		WebElement search = wait.until(ExpectedConditions.elementToBeClickable(enter));
		search.click();
	}
	
	public void clickOnProduct()throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 10); // 10-second wait
		WebElement click = wait.until(ExpectedConditions.elementToBeClickable(clickProduct));
		click.click();
	}
	
	public void addToCart()throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 10); // 10-second wait
		WebElement add = wait.until(ExpectedConditions.elementToBeClickable(addTo));
		add.click();
	}
	
	public void addedOnCart() {
		driver.findElement(added).isDisplayed();
		System.out.println("Item added in Cart " + driver.findElement(added).isDisplayed());
	}
	public void goToCart()throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(openCart).click();
	}
	
	public void verifyFirstProduct()throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(verifyfirstitem).isDisplayed();
	}
	
	public void priceOfItem1()throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(priceOfFirst).getText();
	}
	
	public void clickNonFiction() {
		driver.findElement(nonFiction).click();
	}
	
	public void clickGenres()throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(genres).click();
	}
	
	public void addSecondProduct()throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(addSecondItem).click();
	}
	
	public void addThirdProduct()throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(addThirdItem).click();
	}
	
	public void addFourthProduct()throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(addFourthItem).click();
	}
	
	public void addFifthProduct()throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(addFifthItem).click();
	}
	
	public void verifySecondProduct()throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(verifyseconditem).isDisplayed();
	}
	
	public void priceOfItem2()throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(priceOfSecond).getText();	
	}
	
	public void priceOfItem3()throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(priceOfThird).getText();	
	}
	
	public void priceOfItem4()throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(priceOfFourth).getText();	
	}
	
	public void priceOfItem5()throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(priceOfFifth).getText();	
	}
	
	public void totalPriceOfItems()throws InterruptedException {
		Thread.sleep(20000);
		driver.findElement(totalPrice).getText();
	}
	
	
	public SearchBooksPage performLogin(String username, String pwd) {
        driver.findElement(emailId).sendKeys(username);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signInButton).click();
		return new SearchBooksPage(driver);
    }	
	
	/*
	public List<String> getAccountsSectionsList() {

		List<String> accountsList = new ArrayList<>();
		List<WebElement> accountsHeaderList = driver.findElements(accountSections);

		for (WebElement e : accountsHeaderList) {
			String text = e.getText();
			System.out.println(text);
			accountsList.add(text);
		}

		return accountsList;
	}
*/
}
