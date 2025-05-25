package stepdefinitions;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import pages.SearchPage;

public class Search {
	private HomePage homePage;
	private SearchPage searchPage;
	
	@Given("User navigates to homepage")
	public void user_navigates_to_homepage() {
		homePage = new HomePage(DriverFactory.getDriver());
		assertTrue(homePage.isOnHomePage());
	}
	
	@And("User enters valid product {string} in the search box")
	public void user_enters_valid_product_in_the_search_box(String validProductName) {
		homePage.enterSearchText(validProductName);
	}

	@And("User clicks on the search button")
	public void user_clicks_on_the_search_button() {
		searchPage = homePage.clickSearchButton();
	}

	@Then("User should get the valid product {string} in the search result")
	public void user_should_get_the_valid_product_in_the_search_result(String validProductName) {
		Assert.assertTrue(searchPage.isProductPresent(validProductName));
	}

	@Given("User enters invalid product {string} in the search box")
	public void user_enters_invalid_product_in_the_search_box(String invalidProductName) {
		homePage.enterSearchText(invalidProductName);
	}

	@Given("User enters no product in the search box")
	public void user_enters_no_product_in_the_search_box() {
		homePage.enterSearchText();	
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		Assert.assertEquals("There is no product that matches the search criteria.", searchPage.getSearchResultText());
	}

}
