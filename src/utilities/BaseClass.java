package utilities;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public WebDriver driver;

	public WebDriver invokeBrowser() throws Exception {

		File file = new File(".\\");

		System.out.println(file.getCanonicalPath());

		System.setProperty("webdriver.chrome.driver", file.getCanonicalPath()+"\\BrowserDrivers\\chromedriver.exe");

		driver = new ChromeDriver();
		
		return driver;

	}
	
	public void CloseBrowser() {
		
		driver.quit();
	}
	
	public void waituntilelementvisible(WebDriver driver, String element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(element)));
		
	}
	
	public void selectbyvalue(WebElement element, String value) {
		
		new Select(element).selectByVisibleText(value);
	}


}
