package nl.centric.webwinkel.cucumber.features;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStappen extends AbstractStappen{
	
	WebDriver driver;
	
	@Before
	public void init(){
		driver = getDriver(true);
	}
	
	@Given("^Ga naar de inlogpagina van Webwinkel Roellemans$")
	public void gaNaarLoginpagina() throws Throwable {
		driver.navigate().to("http://localhost:8081/Webwinkel/Winkel");
	}
		
	@When("^Vul de login gegevens \"([^\"]*)\" en \"([^\"]*)\" in$")
	public void vulLoginGegevens(String username, String password) throws Throwable {
		driver.findElement(By.name("j_username")).sendKeys(username);
		driver.findElement(By.name("j_password")).sendKeys(password);
		driver.findElement(By.id("Submit")).click();
	}

	@Then("^Controleer de foutieve login$")
	public void controleerVerkeerdeLogin() throws Throwable {
		Thread.sleep(2000);
		Assert.assertTrue("Niet geslaagd" , driver.getCurrentUrl().equals("http://localhost:8081/Webwinkel/loginMislukt"));
		driver.quit();
	}
	
	@Then("^Controleer de juiste login$")
	public void controleerJuisteLogin() throws Throwable {
		Thread.sleep(3000);
		Assert.assertTrue("Niet geslaagd" , driver.getCurrentUrl().equals("http://localhost:8081/Webwinkel/Winkel"));	
	}

	@After
	public void close(){
		driver.quit();
	}
	

}
