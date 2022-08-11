package tests;

import org.testng.annotations.Test;
import libraries.businesslibraries;
import utilities.BaseClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class PlaceOrderTest extends BaseClass {

	public WebDriver driver;

	public PlaceOrderTest() {
		super();
	}

	@BeforeClass
	@Parameters({ "env", "Browser" })
	public void setup(@Optional("DEV") String env, @Optional("Firefox") String Browser) throws Exception {

		driver = invokeBrowser(env,Browser);
		Open(URL);
	}

	@Test
	public void placeOrderTest() throws Exception {

		businesslibraries libraries = PageFactory.initElements(driver, businesslibraries.class);
		
		libraries.placeOrder();
	}

	@AfterClass
	public void tearDown() {

		CloseBrowser();
	}

}
