package stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountCreatedPage;
import pages.HomePage;
import pages.RegisterPage;

public class Register  {
	private HomePage homePage;
	private RegisterPage registerPage;
	private AccountCreatedPage accountCreatedPage;
	
	@Given("User has navigated to register page")
	public void user_has_navigated_to_register_page() {
		homePage = new HomePage(DriverFactory.getDriver());
		homePage.clickMyAccountLink();
		registerPage = homePage.clickRegisterLink();
		assertTrue(registerPage.isOnRegisterPage());
	}

	@When("User enters details in the below fields")
	public void user_enters_details_in_the_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		registerPage.enterEmail(dataMap.get("email"));
		registerPage.enterPassword(dataMap.get("password"));
	}

	@And("User selects Privacy policy")
	public void user_selects_privacy_policy() {
		registerPage.clickPrivacyPolicy();	
	}

	@And("User clicks on the Continue button")
	public void user_clicks_on_the_continue_button() {
		accountCreatedPage = registerPage.clickContinue();
	}

	@Then("Account should get created successfully")
	public void account_should_get_created_successfully() {
		Assert.assertTrue(accountCreatedPage.isOnAccountCreatedPage());
	}

	@And("User selects Subscribe option")
	public void user_selects_subscribe_option() {
		registerPage.clickSubscribe();	
	}

	@Then("Account should get warning message about duplicate email")
	public void account_should_get_warning_message_about_duplicate_email() {
		Assert.assertTrue(registerPage.getAlertMessageText().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User does not enter any data into the fields")
	public void user_does_not_enter_any_data_into_the_fields() {
		registerPage.enterFirstName();
		registerPage.enterLastName();
		registerPage.enterEmail();
		registerPage.enterPassword();
	}

	@Then("Account should get proper warning messages for all the mandatory fields")
	public void account_should_get_proper_warning_messages_for_all_the_mandatory_fields() {
		Assert.assertTrue(registerPage.isAlertMessageDisplayed());
		Assert.assertEquals("Warning: You must agree to the Privacy Policy!", registerPage.getAlertMessageText());
		Assert.assertTrue(registerPage.isFirstNameErrorDisplayed());	
		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerPage.getFirstNameError());		
		Assert.assertTrue(registerPage.isLastNameErrorDisplayed());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerPage.getLastNameError());
		Assert.assertTrue(registerPage.isEmailErrorDisplayed());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.getEmailNameError());
		Assert.assertTrue(registerPage.isPasswordErrorDisplayed());
		Assert.assertEquals("Password must be between 6 and 40 characters!", registerPage.getPasswordError());
	}
}
