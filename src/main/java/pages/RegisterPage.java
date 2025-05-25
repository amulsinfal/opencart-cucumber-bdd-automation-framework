package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

	private static final Logger log = LogManager.getLogger(RegisterPage.class);
	private WebDriver driver;
	private By firstNameTxt = By.id("input-firstname");
	private By firstNameErrorLbl = By.id("error-firstname");
	private By lastNameTxt = By.id("input-lastname");
	private By lastNameErrorLbl = By.id("error-lastname");
	private By emailTxt = By.id("input-email");
	private By emailErrorLbl = By.id("error-email");
	private By passwordTxt = By.id("input-password");
	private By passwordErrorLbl = By.id("error-password");
	private By subscribeChk = By.id("input-newsletter");
	private By privacyPolicyChk = By.name("agree");
	private By continueBtn = By.xpath("//div[@class='text-end']/button[@type='submit' and text() = 'Continue']");
	private By alertMessage = By.xpath("//div[@id='alert']/div[@class='alert alert-danger alert-dismissible']");
	private By breadCrumbLabel = By.xpath("//div[@id='account-register']/ul[@class='breadcrumb']/li[3]/a");

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isOnRegisterPage() {
		boolean isDisplayed = driver.findElement(breadCrumbLabel).getText().contains("Register");
		if (isDisplayed) {
			log.info("Register Page displayed.");
			return isDisplayed;
		} else {
			log.error("Register Page was not displayed.");
			return isDisplayed;
		}
	}

	public void enterFirstName(String firstName) {
		driver.findElement(firstNameTxt).sendKeys(firstName);
		log.info("'" + firstName + "' entered in the first name text box.");
	}

	public void enterFirstName() {
		driver.findElement(firstNameTxt).clear();
		log.info("No first name entered in the first name text box.");
	}
	
	public void enterLastName(String lastName) {
		driver.findElement(lastNameTxt).sendKeys(lastName);
		log.info("'" + lastName + "' entered in the last name text box.");
	}

	public void enterLastName() {
		driver.findElement(lastNameTxt).clear();
		log.info("No last name entered in the last name text box.");
	}
	
	public void enterEmail(String email) {
		driver.findElement(emailTxt).sendKeys(email);
		log.info("'" + email + "' entered in the email text box.");
	}	
	
	public void enterEmail() {
		driver.findElement(emailTxt).clear();
		log.info("No email entered in the email text box.");
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordTxt).sendKeys(password);
		log.info("'" + password + "' entered in the password text box.");
	}	
	
	public void enterPassword() {
		driver.findElement(passwordTxt).clear();
		log.info("No password entered in the password text box.");
	}
	
	public void clickSubscribe() {
		driver.findElement(subscribeChk).click();
		log.info("Clicked on the subscribe slide button.");
	}
	
	public void clickPrivacyPolicy() {
		driver.findElement(privacyPolicyChk).click();
		log.info("Clicked on the privacy policy slide button.");
	}
	
	public AccountCreatedPage clickContinue() {
		driver.findElement(continueBtn).click();
		log.info("Clicked on the Continue button.");
		return new AccountCreatedPage(driver);
	}

	public boolean isAlertMessageDisplayed() {
		boolean isdisplayed =  driver.findElement(alertMessage).isDisplayed();
		if(isdisplayed) {
			log.info("Alert message was displayed.");
			return isdisplayed;
		} else {
			log.error("Alert message was not displayed.");
			return isdisplayed;
		}
	}

	public String getAlertMessageText() {
		log.info("Alert message is '" + driver.findElement(alertMessage).getText() + "'");
		return driver.findElement(alertMessage).getText();
	}
	
	public boolean isFirstNameErrorDisplayed() {
		boolean isdisplayed =  driver.findElement(firstNameErrorLbl).isDisplayed();
		if(isdisplayed) {
			log.info("First name error message was displayed.");
			return isdisplayed;
		} else {
			log.error("First name error message was not displayed.");
			return isdisplayed;
		}
	}
	
	public String getFirstNameError() {
		log.info("First name error message is '" + driver.findElement(firstNameErrorLbl).getText() + "'");
		return driver.findElement(firstNameErrorLbl).getText();
	}
	
	public boolean isLastNameErrorDisplayed() {
		boolean isDisplayed =  driver.findElement(lastNameErrorLbl).isDisplayed();
		if(isDisplayed) {
			log.info("Last name error message was displayed.");
			return isDisplayed;
		} else {
			log.error("Last name error message was not displayed.");
			return isDisplayed;
		}
	}
	
	public String getLastNameError() {
		log.info("Last name error message is '" + driver.findElement(lastNameErrorLbl).getText() + "'");
		return driver.findElement(lastNameErrorLbl).getText();
	}

	public boolean isEmailErrorDisplayed() {
		boolean isDisplayed =  driver.findElement(emailErrorLbl).isDisplayed();
		if(isDisplayed) {
			log.info("Email error message was displayed.");
			return isDisplayed;
		} else {
			log.error("Email error message was not displayed.");
			return isDisplayed;
		}
	}
	
	public String getEmailNameError() {
		log.info("Email error message is '" + driver.findElement(emailErrorLbl).getText() + "'");
		return driver.findElement(emailErrorLbl).getText();
	}

	public boolean isPasswordErrorDisplayed() {
		boolean isDisplayed =  driver.findElement(passwordErrorLbl).isDisplayed();
		if(isDisplayed) {
			log.info("Password error message was displayed.");
			return isDisplayed;
		} else {
			log.error("Password error message was not displayed.");
			return isDisplayed;
		}
	}

	public String getPasswordError() {
		log.info("Password error message is '" + driver.findElement(passwordErrorLbl).getText() + "'");
		return driver.findElement(passwordErrorLbl).getText();
	}

}
