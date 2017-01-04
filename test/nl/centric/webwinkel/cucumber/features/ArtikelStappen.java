package nl.centric.webwinkel.cucumber.features;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ArtikelStappen extends AbstractStappen {
	
	WebDriver driver = getDriver(false);
	
	@And("^Klik op het artikel \"([^\"]*)\"$")
	public void gaNaarArtikel(String artikelnaam) throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.id(artikelnaam)).click();
	}

	@Then("^Controleer of de artikelpagina van \"([^\"]*)\" is weergegeven$")
	public void controleArtikelPagina(String artikelnaam) throws Throwable {
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.id(artikelnaam));
		Assert.assertTrue("Niet geslaagd" , element != null);	
	}
	
}
