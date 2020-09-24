package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import util.PropertiesReader;

import java.util.concurrent.TimeUnit;

public class StepDefinitions {

	private String URL;
	private WebDriver driver = null;

	@Given("^i read the properties file$")
	public void iReadThePropertiesFile() {
		PropertiesReader.load(System.getProperty("user.dir") + "/src/test/java/resources/env.properties");
		URL = PropertiesReader.get("url");
	}

	@Given("^I navigate to the website$")
	public void iNavigateToTheWebsite() {
		WebDriverManager.chromedriver().browserVersion(" 85.0.4183.121").setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("enable-automation");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
	}

	@When("^I click on payAToll button$")
	public void iClickOnPayATollButton() {
		driver.findElement(By.xpath("//div[1]/div/div[2]/ul/li[5]/a/span")).click();
	}

	@And("^I click on buyOrPayToll button$")
	public void iClickOnBuyOrPayTollButton() {
		driver.findElement(By.xpath("//*[text()='Buy or pay a toll']")).click();
	}

	@And("^I checked the declare button$")
	public void iCheckedTheDeclareButton() {
		driver.findElement(By.name("declare")).click();
	}

	@And("^I click on Continue button$")
	public void iClickOnContinueButton() throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
	}


	@And("^I enter \"([^\"]*)\"$")
	public void iEnter(String number) {
		driver.findElement(By.id("plate_number")).click();
		driver.findElement(By.id("plate_number")).sendKeys(number);
	}

	@And("^I enter \"([^\"]*)\" amount in NORTH_GW_TOLL field$")
	public void iEnterAmountInNORTH_GW_TOLLField(String NORTH_GW_TOLL) {
		driver.findElement(By.id("trip_2")).click();
		driver.findElement(By.id("trip_2")).sendKeys(NORTH_GW_TOLL);
	}

	@And("^I enter \"([^\"]*)\" amount in TAURANGA_EAST_TOLL field$")
	public void iEnterAmountInTAURANGA_EAST_TOLLField(String TAURANGA_EAST_TOLL) {
		driver.findElement(By.id("trip_3")).click();
		driver.findElement(By.id("trip_3")).sendKeys(TAURANGA_EAST_TOLL);
	}

	@And("^I enter \"([^\"]*)\" amount in TAKITIMU_TOLL field$")
	public void iEnterAmountInTAKITIMU_TOLLField(String TAKITIMU_TOLL)  {
		driver.findElement(By.id("trip_6")).click();
		driver.findElement(By.id("trip_6")).sendKeys(TAKITIMU_TOLL);
	}

	@And("^I click on noThanksRadioButton$")
	public void iClickOnNoThanksRadioButton() {
		driver.findElement(By.xpath("//label[text()='No thanks']")).click();
	}


	@And("^I click on payNow button$")
	public void iClickOnPayNowButton() {
		driver.findElement(By.xpath("//input[@value='Pay now']")).click();
	}

	@And("^I close the application$")
	public void iCloseTheApplication() {
		driver.quit();
	}

	@And("^I click on vehicleDetailsConfirm button$")
	public void iClickOnVehicleDetailsConfirmButton() {
		driver.findElement(By.xpath("//*[@id=\"form-future-trips-confirm-vehicle\"]/div/span/input")).click();
	}
}

