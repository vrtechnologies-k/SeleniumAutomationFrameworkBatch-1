package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ProductsPage {
	
	@FindBy(className="search-keyword")
	public WebElement searchKeyword;
	
	@FindBys(
	
			@FindBy(xpath="//div[@class='product']")
			
	)
	public List<WebElement> products;
	
	@FindBys(
	
			@FindBy(xpath="//div[@class='product']/div/button")
	)
	public List<WebElement> productbtns;
	
	@FindBy(className="cart-icon")
	public WebElement cartIcon;
	
	public String productName = "parent::div/parent::div/h4";
	
	@FindBy(xpath="//button[text()='PROCEED TO CHECKOUT']")
	public WebElement Checkout;
	
	@FindBys(
	
			@FindBy(xpath="//table/tbody/tr/td[2]")
	)
	public List<WebElement> productnames;
	
	@FindBys(
			
			@FindBy(xpath="//table/tbody/tr/td[5]/p")		
	)
	public List<WebElement> productprice;
	
	@FindBy(className = "totAmt")
	public WebElement totalAmount;
	
	@FindBy(className = "promoCode")
	public WebElement promoCode;
	
	@FindBy(className = "promoBtn")
	public WebElement PromoButton;
	
	@FindBy(className = "promoInfo")
	public WebElement promoInfo;
	
	@FindBy(className = "discountAmt")
	public WebElement discountAmount;
	
	public String promoInfo1 = "promoInfo";
	
	@FindBy(xpath="//button[contains(.,'Place Order')]")
	public WebElement placeOrder;
	
	@FindBy(className = "chkAgree")
	public WebElement agreehk;
	
	@FindBy(xpath = "//button[text()='Proceed']")
	public WebElement proceed;
	
	@FindBy(tagName = "select")
	public WebElement selectcountry;

	public void searchItem() {
		
		searchKeyword.sendKeys("ber");
	}
	
	public void getcart() {
		cartIcon.click();
	}
	
	public void getCheckout() {
		Checkout.click();
	}
	
	public void getPromocode() {
		promoCode.sendKeys("rahulshettyacademy");
	}
	
	public void getPromobutton() {
		PromoButton.click();
	}
	
	
	
	
	

}
