package nl.centric.webwinkel.cucumber.features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractStappen {

	protected static WebDriver driver;

	protected WebDriver getDriver(boolean waarde) {

		if (waarde) {
			String locatie = "C:\\Program Files\\Geckodriver\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", locatie);
			driver = new FirefoxDriver();
		}
		return driver;
	}

}
