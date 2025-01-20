/**
 * @author Ravikumar Lubdhi
 * https://www.linkedin.com/in/ravikumar-lubdhi/
 * https://github.com/ravikumarsl
 **/

package parallel;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.pages.SearchBooksPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchBooksPageSteps {

	private static String title;
	private int price1;
	private int price2;
	private int price3;
	private int price4;
	private int price5;
	private SearchBooksPage searchBooksPage = new SearchBooksPage(DriverFactory.getDriver());

	@Given("user is logged into the application")
	public void user_is_logged_into_application() {
		// Check if user is already logged in, if not, perform login
		if (DriverFactory.getDriver().manage().getCookies().isEmpty()) {
			DriverFactory.getDriver().get("https://www.99bookscart.com/login");
			// Reuse your login steps here to log in if cookies do not exist
			searchBooksPage.performLogin("ravikumar.lubdhi@gmail.com", "Tester@1234");
		}
	}
	
	@Given("user clicks the search option")
	public void user_clicks_search_option() throws InterruptedException{
		searchBooksPage.clickSearchIcon();
	}

	@Given("user is on Search page")
	public void user_is_on_search_page() {
		DriverFactory.getDriver().getCurrentUrl().contains("search");
		System.out.println("URL is : " + DriverFactory.getDriver().getCurrentUrl());
	}

	@When("title of the page")
	public void title_of_the_page() {
		title = searchBooksPage.getPageTitle();
	}

	@Then("search page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		Assert.assertEquals(expectedTitleName, title);
	}

	@When("user searches books {string}")
	public void user_searches_books(String book) throws InterruptedException {
		searchBooksPage.clickSearchIcon();  // Click on search icon
		searchBooksPage.clickOnSearch(book);  // Enter book name in the search field
	}

	@When("enter the search")
	public void enter_search() {
		searchBooksPage.enterSearch();
	}

	@Then("the search results should show books related to {string}")
	public void verify_search_results(String book) {
		// Implement code to verify the search results based on the book name
	}

	@When("click on product")
	public void click_on_product() throws InterruptedException {
		searchBooksPage.clickOnProduct();
	}

	@When("add to cart")
	public void add_to_cart() throws InterruptedException {
		searchBooksPage.addToCart();
	}
	
	@When("product added to cart")
	public void product_added_to_cart() {
		searchBooksPage.addedOnCart();
	}
	
	@When("open cart")
	public void open_cart() throws InterruptedException {
		searchBooksPage.goToCart();
	}
	
	@Then("verify first product")
	public void verify_first_product() throws InterruptedException {
		searchBooksPage.verifyFirstProduct();
	}
	
	@Then("price of first product {string}")
	public void price_of_first_product(String price) throws InterruptedException {
		searchBooksPage.priceOfItem1();
		price1 = Integer.parseInt(price); // Store as an integer
	    System.out.println("Price of First Item: " + price1);
	}
	
	@When("click on non fiction")
	public void click_on_non_fiction() {
		searchBooksPage.clickNonFiction();
	}
	
	@When("click on genres")
	public void click_on_genres() throws InterruptedException {
		searchBooksPage.clickGenres();
	}
	
	@When("add second product to cart")
	public void add_second_product() throws InterruptedException {
		searchBooksPage.addSecondProduct();
	}
	
	@When("add third product to cart")
	public void add_third_product() throws InterruptedException {
		searchBooksPage.addThirdProduct();
	}
	
	@When("add fourth product to cart")
	public void add_fourth_product() throws InterruptedException {
		searchBooksPage.addFourthProduct();
	}
	
	@When("add fifth product to cart")
	public void add_fifth_product() throws InterruptedException {
		searchBooksPage.addFifthProduct();
	}

	@Then("verify second product")
	public void verify_second_product() throws InterruptedException {
		searchBooksPage.verifySecondProduct();
	}
	
	@Then("price of second product {string}")
	public void price_of_second_product(String price) throws InterruptedException {
		searchBooksPage.priceOfItem2();	
		price2 = Integer.parseInt(price); // Store as an integer
	    System.out.println("Price of Second Item: " + price2);
		
	}
	
	@Then("price of third product {string}")
	public void price_of_third_product(String price) throws InterruptedException {
		searchBooksPage.priceOfItem3();
		price3 = Integer.parseInt(price); // Store as an integer
	    System.out.println("Price of Second Item: " + price3);
		
	}
	
	@Then("price of fourth product {string}")
	public void price_of_fourth_product(String price) throws InterruptedException {
		searchBooksPage.priceOfItem4();
		price4 = Integer.parseInt(price); // Store as an integer
	    System.out.println("Price of Second Item: " + price4);
		
	}
	
	@Then("price of fifth product {string}")
	public void price_of_fifth_product(String price) throws InterruptedException {
		searchBooksPage.priceOfItem5();
		price5 = Integer.parseInt(price); // Store as an integer
	    System.out.println("Price of Second Item: " + price5);
	}
	
	@Then("total price of products {string}")
	public void total_price_of_products(String price) throws InterruptedException {
		searchBooksPage.totalPriceOfItems();
		//System.out.println(price3);
		
	    int totalPrice = price1 + price2 + price3 + price4 + price5;
		
	    System.out.println("Total Price of Products: " + totalPrice);
	    
	    Assert.assertEquals(765, totalPrice);
	    
	}
	
}



