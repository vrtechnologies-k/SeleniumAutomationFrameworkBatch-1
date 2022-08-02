package tests;

import org.testng.annotations.Test;

import pageObjects.ProductsPage;
import utilities.BaseClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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

	@AfterClass
	public void tearDown() {

		CloseBrowser();
	}

}
