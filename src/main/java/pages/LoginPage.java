package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private static final Logger log = LogManager.getLogger(LoginPage.class);
	private WebDriver driver;
	private By emailTxt = By.id("input-email");
	private By passwordTxt = By.id("input-password");
	private By loginBtn = By.xpath("//button[@type='submit' and text()='Login']");
	private By alertMessage = By.xpath("//div[contains(@class,'alert-dismissible')]");
	private By breadCrumbLabel = By.xpath("//div[@id='account-login']/ul[@class='breadcrumb']/li[3]/a");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterEmailAddress(String emailAddressText) {
		driver.findElement(emailTxt).sendKeys(emailAddressText);
		log.info("'" + emailAddressText + "' entered in the email address text box.");
	}

	public void enterEmailAddress() {
		driver.findElement(emailTxt).clear();
		log.info("No text entered in the email address text box.");
	}
	
	public void enterPassword(String passwordText) {
		driver.findElement(passwordTxt).sendKeys(passwordText);
		log.info("'" + passwordText + "' entered in the password text box.");
	}

	public void enterPassword() {
		driver.findElement(passwordTxt).clear();
		log.info("No text entered in the password text box.");
	}
	
	public MyAccountPage clickLogin() {
		driver.findElement(loginBtn).click();
		log.info("Clicked on the login button.");
		return new MyAccountPage(driver);
	}

	public boolean isAlertMessageDisplayed() {
		boolean isdisplayed =  driver.findElement(alertMessage).isDisplayed();
		if(isdisplayed) {
			log.info("Alert message was displayed.");
			log.info("Alert message is '" + driver.findElement(alertMessage).getText() + "'");
			return isdisplayed;
		} else {
			log.error("Alert message was not displayed.");
			return isdisplayed;
		}
	}
	
	public boolean isOnLoginPage(){
		boolean result =  driver.findElement(breadCrumbLabel).getText().contains("Login");
		if(result) {
			log.info("Login page is displayed.");
			return result;
		} else {
			log.error("Login page is not displayed.");
			return result;
		}
	}
}
