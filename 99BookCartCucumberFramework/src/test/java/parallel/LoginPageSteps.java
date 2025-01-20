/**
 * @author Ravikumar Lubdhi
 * https://www.linkedin.com/in/ravikumar-lubdhi/
 * https://github.com/ravikumarsl
 **/

package parallel;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("user is on home page")
	public void user_is_on_home_page() {
		DriverFactory.getDriver().get("https://www.99bookscart.com");
	}
	
	@Then("home page title should be {string}")
	public void home_page_title_should_be(String expectedTitle) {
		String actualTitle = DriverFactory.getDriver().getTitle();
	    Assert.assertEquals("Home page title does not match!", expectedTitle, actualTitle);
	}
	
	@When("user clicks on login account")
	public void user_clicks_on_login_account() {
		loginPage.clickLoginAccount();
		
	}
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("https://www.99bookscart.com/login");
	}
	
	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("Page title is: " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		Assert.assertTrue("Page title does not match!", title.equals(expectedTitleName));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLoginButton();
	}
	
	@Then("after login title of the page")
	public void after_login__title_of_the_page() {
		title = loginPage.getHomePageTitle();
		System.out.println("Page title is: " + title);
	}
}
