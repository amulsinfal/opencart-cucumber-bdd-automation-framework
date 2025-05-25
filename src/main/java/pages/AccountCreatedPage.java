package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.CommonUtils;

public class AccountCreatedPage {
	
	private static final Logger log = LogManager.getLogger(AccountCreatedPage.class);
	private WebDriver driver;
	private By breadCrumbLabel = By.xpath("//div[@id='common-success']/ul[@class='breadcrumb']/li[3]/a");
	private CommonUtils commonUtils; 
	
	public AccountCreatedPage(WebDriver driver) {
		this.driver = driver;
		commonUtils = new CommonUtils(driver);
	}
	
	public boolean isOnAccountCreatedPage() {
//		WebElement element = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(ConfigReader.getValue("implicitWait")))).until(ExpectedConditions.visibilityOf(driver.findElement(breadCrumbLabel)));
		WebElement element = commonUtils.waitForElementToBeClickable(driver.findElement(breadCrumbLabel));
		boolean isDisplayed = element.getText().contains("Your Account Has Been Created!");
		if (isDisplayed) {
			log.info("Account Created Page displayed.");
			return isDisplayed;
		} else {
			log.info("Account Created Page not displayed.");
			return isDisplayed;
		}
	}
	
}
