package tests;

import org.testng.annotations.Test;
import libraries.businesslibraries;
import utilities.BaseClass;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class PlaceOrderTest extends BaseClass {

	public WebDriver driver;

	public PlaceOrderTest() {
		super();
	}

	@BeforeClass
	public void setup() throws Exception {

		driver = invokeBrowser();

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
