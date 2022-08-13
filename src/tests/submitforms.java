package tests;

import org.testng.annotations.Test;

import libraries.businesslibraries;
import utilities.BaseClass;
import utilities.ExcelUtilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class submitforms extends BaseClass{

	public WebDriver driver;

	public submitforms() {
		super();
	}

	@BeforeClass
	@Parameters({ "env", "Browser" })
	public void setUp(@Optional("DEV") String env, @Optional("Chrome") String Browser) throws Exception {

		driver = invokeBrowser(env,Browser);
		Open(URL);
	}

	@Test(dataProvider = "formDetails")
	public void testsubmitform(String Name, String Email, String Password, String Gender, String DOB) throws Exception {

		businesslibraries libraries = PageFactory.initElements(driver, businesslibraries.class);

		libraries.submitForm(Name, Email, Password, Gender, DOB);

	}

	@AfterClass
	public void tearDown() {

		driver.quit();

	}

	@DataProvider(name = "formDetails")
	public Object[][] formDetails() throws Exception, Throwable {

		//return new Object[][] {{"Ramya", "Ramya@gmail.com","Ramya@123","Female","01-01-1988" }, {"Venkat", "Venkat@gmail.com","Venkat@123","Male","01-08-1988" }};

		File file = new File("./");

		Object[][] tabarryvalues = ExcelUtilities.getCellData(file.getCanonicalPath()+"\\TestData\\formData.xls","fillForm");


		return tabarryvalues;
	}

}
