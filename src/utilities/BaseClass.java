package utilities;

import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public WebDriver driver;
	public static String URL;

	public WebDriver invokeBrowser(String Env, String browser) throws Exception {

		File file = new File(".\\");

		FileReader reader=new FileReader(file.getCanonicalPath()+"\\resources\\properties\\BaseProperties.properties");
		Properties p=new Properties();
		p.load(reader);

		switch (Env) {

		case "DEV":
			URL= p.getProperty("DEV");
			break;

		case "QA":
			URL = p.getProperty("QA");
			break;

		case "STAGE":
			URL = p.getProperty("STAGE");
			break;
		default:
			break;

		}

		if (browser.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver", file.getCanonicalPath()+"\\BrowserDrivers\\chromedriver.exe");

			driver = new ChromeDriver();
			driver.manage().window().maximize();

		} else if (browser.equals("Firefox")) {

			System.setProperty("webdriver.gecko.driver", file.getCanonicalPath()+"\\BrowserDrivers\\geckodriver.exe");

			driver = new FirefoxDriver();
		}

		return driver;

	}

	public void CloseBrowser() {

		driver.quit();
	}

	public void Open(String URL) throws Exception {
		try {
			driver.get(URL);
		} catch (Exception e) {
			throw e;
		}
	}

	public void waituntilelementvisible(WebDriver driver, String element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(element)));

	}

	public void selectbyvalue(WebElement element, String value) {

		new Select(element).selectByVisibleText(value);
	}


}
