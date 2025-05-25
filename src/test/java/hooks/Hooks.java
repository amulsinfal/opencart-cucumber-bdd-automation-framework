package hooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class Hooks {
	protected WebDriver driver;
	private static final Logger log = LogManager.getLogger(Hooks.class);

	@Before
	public void setup() {
		driver = DriverFactory.intializeDriver(ConfigReader.getValue("browser"));
		driver.get(ConfigReader.getValue("testUrl"));
		log.info("Navigating to url: '" + ConfigReader.getValue("testUrl") + "'");
	}
	
	@After
	public void tearDown(Scenario scenario) {
		String screenshotname = scenario.getName().replaceAll(" ", "_");
		if(scenario.isFailed()) {
			byte[] sourceScreenshot = ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourceScreenshot, "image/png", screenshotname);
		}
		log.info("Quitting the browser.");
		DriverFactory.getDriver().quit();
	}
}
