package factory;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigReader;

public class DriverFactory {
	private static WebDriver driver;
	private static final Logger log = LogManager.getLogger(DriverFactory.class);

	public static WebDriver intializeDriver(String browserName) {

		if (browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
			log.info("Chrome browser launched.");
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			log.info("Firefox browser launched.");
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
			log.info("Edge browser launched.");
		} else {
			log.error("'" + browserName+ "' browser name is invalid. Please check the browser name. Launching the test in chrome browser.");
			driver = new ChromeDriver();
			log.info("Chrome browser launched.");
		}
		driver.manage().window().maximize();
		log.info("Browser maximised.");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.getValue("implicitWait"))));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(ConfigReader.getValue("pageLoadTime"))));
		driver.manage().deleteAllCookies();
		return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
}
