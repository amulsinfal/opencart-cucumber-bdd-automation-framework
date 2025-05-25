package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private static final Logger log = LogManager.getLogger(HomePage.class);
	private WebDriver driver;
	private By myAccountLink = By.xpath("//span[text()='My Account']");
	private By registerLink = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right show']/li/a[text()='Register']");
	private By loginLink = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right show']/li/a[text()='Login']");
	private By searchtxt = By.name("search");
	private By searchBtn = By.xpath("//input[@name='search']/following::button[@type='submit'][1]");
	private By carouselBanner = By.id("carousel-banner-0");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickMyAccountLink() {
		driver.findElement(myAccountLink).click();
		log.info("Clicked on the My Account link.");
	}

	public RegisterPage clickRegisterLink() {
		driver.findElement(registerLink).click();
		log.info("Clicked on the Register link.");
		return new RegisterPage(driver);
	}

	public LoginPage clickLoginLink() {
		driver.findElement(loginLink).click();
		log.info("Clicked on the Login link.");
		return new LoginPage(driver);
	}
	
	public void enterSearchText(String productName) {
		driver.findElement(searchtxt).sendKeys(productName);
		log.info("'" + productName + "' entered in the search text box.");
	}
	
	public void enterSearchText() {
		driver.findElement(searchtxt).clear();
		log.info("No product name was entered in the search text box.");
	}
	
	public SearchPage clickSearchButton() {
		log.info("Clicked on the search button.");
		driver.findElement(searchBtn).click();
		return new SearchPage(driver);
	}
	
	public boolean isOnHomePage(){
		boolean isDisplayed = driver.findElement(carouselBanner).isDisplayed();
		if (isDisplayed) {
			log.info("Home Page displayed.");
			return isDisplayed;
		} else {
			log.info("Home Page is not displayed.");
			return isDisplayed;
		}
	}

}
