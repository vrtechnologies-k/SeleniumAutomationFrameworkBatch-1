package libraries;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import pageObjects.HomePage;
import pageObjects.ProductsPage;
import utilities.BaseClass;

public class businesslibraries extends BaseClass{

	private WebDriver driver;

	public businesslibraries(WebDriver driver) {
		this.driver = driver;
	}

	public void placeOrder() throws Exception {

		//driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		//driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		ProductsPage product = PageFactory.initElements(driver, ProductsPage.class); 

		product.searchItem();

		int prodcucount = product.products.size();

		System.out.println(prodcucount);

		ArrayList<String> array1 = new ArrayList<String>();

		ArrayList<String> array2 = new ArrayList<String>();

		for (int i = 0; i<product.productbtns.size(); i++) {

			product.productbtns.get(i).click();

			String veggies = product.productbtns.get(i).findElement(By.xpath(product.productName)).getText();

			array1.add(veggies);

		}

		System.out.println(array1);

		product.getcart();

		product.getCheckout();

		Thread.sleep(2000);

		for (int j =0 ; j<product.productnames.size(); j++) {

			String vegnames = product.productnames.get(j).getText();

			array2.add(vegnames);

		}

		System.out.println(array2);

		if (array1.equals(array2)) {

			System.out.println("Page 1 products are matched with page 2");
		} else {

			System.out.println("Page 1 products not matching with page 2");
		}

		int sum = 0;

		for (int k = 0; k<product.productprice.size(); k++) {

			String price = product.productprice.get(k).getText();

			sum = sum + Integer.parseInt(price);  // 48+160+180
		}

		System.out.println(sum);

		String totalamount = product.totalAmount.getText();

		if (sum == Integer.parseInt(totalamount)) {

			System.out.println("Total amount matches with sum of prodcuts amount");
		} else {

			System.out.println("Total amount not matches with sum of prodcuts amount");
		}

		product.getPromocode();
		product.getPromobutton();

		waituntilelementvisible(driver, product.promoInfo1);

		String promoinfo = product.promoInfo.getText();

		System.out.println(promoinfo);

		//WebDriverWait wait = new WebDriverWait(driver,10);


		String disamount = product.discountAmount.getText();

		Double d = Double.parseDouble(disamount);

		System.out.println(d);

		if (sum > d) {
			System.out.println("Sum of total price is greather than discount");
		} else {
			System.out.println("Sum of total price is less than or equal to discount");
		}

		product.placeOrder.click();

		selectbyvalue(product.selectcountry, "India");

		product.agreehk.click();

		product.proceed.click();

		Thread.sleep(5000);

	}

	public void submitForm(String Name, String Email, String Password, String Gender, String DOB) throws Exception {

		//driver.get("https://rahulshettyacademy.com/angularpractice/");

		//driver.manage().window().maximize();

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);

		homePage.nameEditBox.sendKeys(Name);

		Thread.sleep(2000);

		Reporter.log("Enter the Name into the Name Editbox");
		
		String nameattribute = homePage.nameEditBox.getAttribute("value");

		System.out.println(nameattribute);

		homePage.emailEditBox.sendKeys(Email);
		
		Reporter.log("Enter the Eamil into the Email Editbox");

		homePage.pwdEditBox.sendKeys(Password);
		
		Reporter.log("Enter the Password into the Password Editbox");

		homePage.checkbox.click();
		
		Reporter.log("Click on the Checkbox");

		if (homePage.checkbox.isSelected()) {
			System.out.println("CheckBox is selected");
		} else {
			System.out.println("CheckBox is not selected");
		}

		new Select(homePage.select).selectByVisibleText(Gender);

		Thread.sleep(5000);
		
		Reporter.log("Select the gender from the Dropdown is :"+Gender);

		int ddcount = homePage.options.size();

		for (int i=0; i<ddcount; i++) {

			String ddoptions = homePage.options.get(i).getText();

			System.out.println(ddoptions);

		}


		int rcount = homePage.radiobuttons.size();

		System.out.println(rcount);

		homePage.radiobuttons.get(1).click();

		Thread.sleep(5000);

		homePage.radio1.click();

		Thread.sleep(5000);
		
		Reporter.log("Click on the Radio button");

		if (homePage.radiobuttons.get(1).isSelected()) {
			System.out.println("Employye Radio Button is selected");
		} else {
			System.out.println("Employee Radio Button is not selected");
		}

		homePage.DOB.sendKeys(DOB);
		
		Reporter.log("Enter the Date of Birth");

		homePage.submitBtn.click();
		
		Reporter.log("click on submit button");

		String sucmsg = homePage.alertmessage.getText();

		System.out.println(sucmsg);
		
		Reporter.log("Alert Message is: "+sucmsg);

		if (sucmsg.contains("The Form has been submitted successfully")) {

			System.out.println("Expected and actual texts are matched");
		}
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destinationFile = new File("Screenshots/screenshot.png");
		
		FileUtils.copyFile(file, destinationFile);
		
		Reporter.log("<a target=\"_blank\" href=\"D:\\TrainingProjects\\SeleniumJavaFrameworkBatch-1\\Screenshots\\screenshot.png\">screenshot</a>");
		
	}

}
