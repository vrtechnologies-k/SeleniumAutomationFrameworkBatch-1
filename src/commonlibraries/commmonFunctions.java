package commonlibraries;

import org.openqa.selenium.WebElement;

public class commmonFunctions {
	
	
	public void type(WebElement element, String value) {
		
		element.sendKeys(value);
		
	}

}
