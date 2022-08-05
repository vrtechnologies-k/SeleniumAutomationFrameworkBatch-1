package tests;

import org.testng.annotations.Test;

import libraries.businesslibraries;
import utilities.BaseClass;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class submitforms extends BaseClass{

	public WebDriver driver;

	public submitforms() {
		super();
	}

	@BeforeClass
	public void setUp() throws Exception {

		driver = invokeBrowser();
	}

	@Test
	public void testsubmitform() throws Exception {

		businesslibraries libraries = PageFactory.initElements(driver, businesslibraries.class);
		
		libraries.submitForm();

	}

	@AfterClass
	public void tearDown() {

		driver.quit();

	}

}
