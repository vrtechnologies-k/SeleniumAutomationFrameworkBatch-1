package libraries;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pageObjects.HomePage;
import pageObjects.ProductsPage;
import utilities.BaseClass;

public class businesslibraries extends BaseClass{

	private WebDriver driver;

	public businesslibraries(WebDriver driver) {
		this.driver = driver;
	}

	public void placeOrder() throws Exception {

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		driver.manage().window().maximize();

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

	public void submitForm() throws Exception {

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.manage().window().maximize();

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);

		homePage.nameEditBox.sendKeys("Venkat");

		Thread.sleep(2000);

		String nameattribute = homePage.nameEditBox.getAttribute("value");

		System.out.println(nameattribute);

		homePage.emailEditBox.sendKeys("venkat@gmail.com");

		homePage.pwdEditBox.sendKeys("venkat");

		homePage.checkbox.click();

		if (homePage.checkbox.isSelected()) {
			System.out.println("CheckBox is selected");
		} else {
			System.out.println("CheckBox is not selected");
		}

		new Select(homePage.select).selectByVisibleText("Female");

		Thread.sleep(5000);

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

		if (homePage.radiobuttons.get(1).isSelected()) {
			System.out.println("Employye Radio Button is selected");
		} else {
			System.out.println("Employee Radio Button is not selected");
		}

		homePage.DOB.sendKeys("01-08-1988");

		homePage.submitBtn.click();

		String sucmsg = homePage.alertmessage.getText();

		System.out.println(sucmsg);

		if (sucmsg.contains("The Form has been submitted successfully")) {

			System.out.println("Expected and actual texts are matched");
		}

	}
}
