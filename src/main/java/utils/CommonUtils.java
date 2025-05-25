package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public CommonUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement waitForElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(ConfigReader.getValue("explicitWait"))));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public WebElement waitForElementToBeVisible(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(ConfigReader.getValue("explicitWait"))));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public List<WebElement> waitForElementsToBeVisible(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(ConfigReader.getValue("explicitWait"))));
		return wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

}
