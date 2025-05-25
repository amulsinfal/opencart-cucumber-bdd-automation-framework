package stepdefinitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class Login {
	private	HomePage homePage;
	private LoginPage loginPage;
	private MyAccountPage myAccountPage;
	
	@Given("User navigates to login page")
	public void User_navigates_to_login_page() {
		homePage = new HomePage(DriverFactory.getDriver());
		homePage.clickMyAccountLink();
		loginPage = homePage.clickLoginLink();
		assertTrue(loginPage.isOnLoginPage());
	}

	@When("^User enters valid email address (.+) into the email field$")
	public void user_enters_valid_email_address_into_the_email_field(String validEmailText) {
		loginPage.enterEmailAddress(validEmailText);
	}

	@And("^User enters valid password (.+) into the password field$")
	public void user_enters_valid_password_into_the_password_field(String validPasswordText) {
		loginPage.enterPassword(validPasswordText);
	}
	
	@And("User clicks on the Login button")
	public void user_clicks_on_the_login_button() {
		myAccountPage = loginPage.clickLogin();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		assertTrue(myAccountPage.isOnMyAccountPage());
	}

	@When("User enters invalid email address {string} into the email field")
	public void user_enters_invalid_email_address_into_the_email_field(String invalidEmailText) {
		loginPage.enterEmailAddress(invalidEmailText);
	}

	@And("User enters invalid password {string} into the password field")
	public void user_enters_invalid_password_into_the_password_field(String invalidPasswordText) {
		loginPage.enterPassword(invalidPasswordText);
	}

	@Then("User should get warning message about invalid credentials")
	public void user_should_get_warning_message_about_invalid_credentials() {
		assertTrue(loginPage.isAlertMessageDisplayed());
	}

	@When("User has not entered any email address into the email field")
	public void user_has_not_entered_any_email_address_into_the_email_field() {
		loginPage.enterEmailAddress();
	}

	@When("User has not entered any password into the password field")
	public void user_has_not_entered_any_password_into_the_password_field() {
		loginPage.enterPassword();
	}

}
