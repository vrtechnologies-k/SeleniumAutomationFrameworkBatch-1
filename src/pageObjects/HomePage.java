package pageObjects;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class HomePage {


	@FindBy(name = "name")
	public WebElement nameEditBox;

	@FindBy(name = "email")
	public WebElement emailEditBox;

	@FindBy(id = "exampleInputPassword1")
	public WebElement pwdEditBox;

	@FindBy(css = "#exampleCheck1")
	public WebElement checkbox;

	@FindBy(xpath = "//select[@id='exampleFormControlSelect1']")
	public WebElement select;

	@FindBys(
			@FindBy(xpath = "//select[@id='exampleFormControlSelect1']/option")
	)
	public List<WebElement> options;
	
	@FindBys(
			@FindBy(css = "input[name='inlineRadioOptions']")
	)
	public List<WebElement> radiobuttons;
	
	@FindBy(id="inlineRadio1")
	public WebElement radio1;
	
	@FindBy(name="bday")
	public WebElement DOB;
	
	@FindBy(css="input[class*='btn-success']")
	public WebElement submitBtn;
	
	@FindBy(css="div[class*='alert-success']")
	public WebElement alertmessage;


}
