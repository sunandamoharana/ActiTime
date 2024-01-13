package pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AutoConstant;
import generic.BasePage;
import generic.ExcelLibrary;

public class ActitimeLoginPage extends BasePage implements AutoConstant
{
	public WebDriver driver;

	@FindBy(id="username")
	private WebElement usernameTextfield;

	@FindBy(name="pwd")
	private WebElement passwordTextfield;

	@FindBy(id="keepLoggedInCheckBox")
	private WebElement keepmeloggedinCheckbox;

	@FindBy(id="loginButton")
	private WebElement loginButton;

	@FindBy(id="toPasswordRecoveryPageLink")
	private WebElement forgotyourpasswordLink;

	@FindBy(xpath="//a[text()='actiTIME Inc.']")
	private WebElement actitimeincLink;

	public ActitimeLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void loginMethod() throws InterruptedException, IOException
	{
		waitVisiblityofElement(driver,usernameTextfield);
		//javascriptHighlightElement(driver,usernameTextfield);
		usernameTextfield.sendKeys(ExcelLibrary.getStringTypeCellData(sheet_login,1,0));
		ExcelLibrary.getCellAddress(sheet_login,1,0);

		waitVisiblityofElement(driver,passwordTextfield);
		//javascriptHighlightElement(driver,passwordTextfield);
		passwordTextfield.sendKeys(ExcelLibrary.getStringTypeCellData(sheet_login,1,1));
		ExcelLibrary.getCellAddress(sheet_login,1,1);

		waitVisiblityofElement(driver,keepmeloggedinCheckbox);
		//javascriptHighlightElement(driver,keepmeloggedinCheckbox);
		javascriptClick(driver,keepmeloggedinCheckbox);

		waitVisiblityofElement(driver,loginButton);
		//javascriptHighlightElement(driver,loginButton);
		javascriptClick(driver,loginButton);

	}
}