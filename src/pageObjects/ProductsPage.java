package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage {
	
	@FindBy(className="search-keyword")
	public WebElement searchKeyword;
	

	public void searchItem() {
		
		searchKeyword.sendKeys("ber");
	}
	
	
	

}
