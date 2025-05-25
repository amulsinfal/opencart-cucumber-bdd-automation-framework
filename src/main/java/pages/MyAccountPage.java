package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {

	private static final Logger log = LogManager.getLogger(MyAccountPage.class);
	private WebDriver driver;
	private By breadCrumbLabel = By.xpath("//div[@id='account-account']/ul[@class='breadcrumb']/li[2]/a");

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isOnMyAccountPage(){
		boolean result =  driver.findElement(breadCrumbLabel).getText().contains("Account");
		if(result) {
			log.info("My account page is displayed.");
			return result;
		} else {
			log.error("My account page is not displayed.");
			return result;
		}
	}
}
