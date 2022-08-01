package utilities;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public WebDriver driver;

	public WebDriver invokeBrowser() throws Exception {

		File file = new File(".\\");

		System.out.println(file.getCanonicalPath());

		System.setProperty("webdriver.chrome.driver", file.getCanonicalPath()+"\\BrowserDrivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		driver.manage().window().maximize();
		
		return driver;

	}
	
	public void CloseBrowser() {
		
		driver.quit();
	}


}
