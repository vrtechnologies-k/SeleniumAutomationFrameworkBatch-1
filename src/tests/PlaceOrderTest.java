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
		// Scope of implicitly wait is global
		//wait until object not displayed, if object is displayed before the defined time, it will skip the remainig the time
		// resume the execution

		// Difference b/w Implicitly and explicitly wait
		// scope of implicitly wait is global
		// scope of explicitly wait is targeted to specific webelement
		// In implicitly wait object is displayed before the defined time, webdriver will skip the remaining time and resume the execution
		// In explicitly wait object is displayed before the defined time, webdriver will wait until specified time and then move to the next statement
		// for list of web element scope of implicitly wait is limted

		//driver.findElement(By.className("search-keyword")).sendKeys("ber");

		ProductsPage product = PageFactory.initElements(driver, ProductsPage.class); 
		
		product.searchItem();
		
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='product']"));

		int prodcucount = products.size();

		System.out.println(prodcucount);

		ArrayList<String> array1 = new ArrayList<String>();

		ArrayList<String> array2 = new ArrayList<String>();

		List<WebElement> productbtns = driver.findElements(By.xpath("//div[@class='product']/div/button"));

		for (int i = 0; i<productbtns.size(); i++) {

			productbtns.get(i).click();

			String veggies = productbtns.get(i).findElement(By.xpath("parent::div/parent::div/h4")).getText();

			array1.add(veggies);

		}

		System.out.println(array1);

		driver.findElement(By.className("cart-icon")).click();

		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

		Thread.sleep(2000);

		List<WebElement> productnames = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));

		for (int j =0 ; j<productnames.size(); j++) {

			String vegnames = productnames.get(j).getText();

			array2.add(vegnames);

		}

		System.out.println(array2);

		if (array1.equals(array2)) {

			System.out.println("Page 1 products are matched with page 2");
		} else {

			System.out.println("Page 1 products not matching with page 2");
		}

		List<WebElement> eachproductprices = driver.findElements(By.xpath("//table/tbody/tr/td[5]/p"));

		int sum = 0;

		for (int k = 0; k<eachproductprices.size(); k++) {

			String price = eachproductprices.get(k).getText();

			//System.out.println(price);

			sum = sum + Integer.parseInt(price);  // 48+160+180
		}

		System.out.println(sum);

		String totalamount = driver.findElement(By.className("totAmt")).getText();

		if (sum == Integer.parseInt(totalamount)) {

			System.out.println("Total amount matches with sum of prodcuts amount");
		} else {

			System.out.println("Total amount not matches with sum of prodcuts amount");
		}

		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");

		driver.findElement(By.className("promoBtn")).click();

		//Thread.sleep(5000);

		// Explicitly Wait:
		// Webdriver will wait until lobject not displayed and if object is not displayed with in the defiened
		// time, getting exception like element not found, visible etc.. and if object is available with in time it will not 
		// through any exception and if object displayed before the time, it will not skip remaining time and wait untill defined time completed
		// Scope of explicitly wait is targeted to the specific web element

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("promoInfo")));

		//WebElement promomsg =driver.findElement(By.className("promoInfo"));

		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.className("promoInfo")));

		String promoinfo = driver.findElement(By.className("promoInfo")).getText();

		System.out.println(promoinfo);

		//WebDriverWait wait = new WebDriverWait(driver,10);


		String disamount = driver.findElement(By.className("discountAmt")).getText();

		Double d = Double.parseDouble(disamount);

		System.out.println(d);

		if (sum > d) {
			System.out.println("Sum of total price is greather than discount");
		} else {
			System.out.println("Sum of total price is less than or equal to discount");
		}

		driver.findElement(By.xpath("//button[contains(.,'Place Order')]")).click();

		new Select(driver.findElement(By.tagName("select"))).selectByVisibleText("India");

		driver.findElement(By.className("chkAgree")).click();

		driver.findElement(By.xpath("//button[text()='Proceed']")).click();

		Thread.sleep(5000);

	}

	@AfterClass
	public void tearDown() {

		CloseBrowser();
	}

}
