package pages;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonUtils;
import utils.ConfigReader;

public class SearchPage {
	
	private static final Logger log = LogManager.getLogger(SearchPage.class);
	private WebDriver driver;
	private By searchResultLabel = By.xpath("//div[@id='content']/p");
	private CommonUtils commonUtils;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		commonUtils = new CommonUtils(driver);
	}

	public String getSearchResultText() {
		new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(ConfigReader.getValue("implicitWait")))).until(ExpectedConditions.visibilityOf(driver.findElement(searchResultLabel)));
		log.info("Search Message text retrieved : '" + driver.findElement(searchResultLabel).getText() + "'.");
		return driver.findElement(searchResultLabel).getText();
	}

//	public boolean isProductPresent(String productName) {
//		By xpathString = By.xpath("//div[@class='description']/h4/a[contains(text(),'" + productName + "')]");
//		new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(ConfigReader.getValue("implicitWait")))).until(ExpectedConditions.visibilityOfAllElements(driver.findElements(xpathString)));
//		boolean isPresent = !driver.findElements(xpathString).isEmpty();
//		if (isPresent) {
//			log.info("Product present: '" + isPresent + "'.");
//			log.info("Product found.");
//			return isPresent;
//		} else {
//			log.error("Product present: '" + isPresent + "'.");
//			log.error("Product not found.");
//			return isPresent;
//		}
//	}
	
	public boolean isProductPresent(String productName) {
		By xpathString = By.xpath("//div[@class='description']/h4/a[contains(text(),'" + productName + "')]");
		List<WebElement> elements = commonUtils.waitForElementsToBeVisible(driver.findElement(xpathString));
		boolean isPresent = !elements.isEmpty();
		if (isPresent) {
			log.info("Product present: '" + isPresent + "'.");
			log.info("Product found.");
			return isPresent;
		} else {
			log.error("Product present: '" + isPresent + "'.");
			log.error("Product not found.");
			return isPresent;
		}
	}

}
