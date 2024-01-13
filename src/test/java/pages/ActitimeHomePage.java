package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActitimeHomePage {
	
	public WebDriver driver;
	public JavascriptExecutor js;
	public WebDriverWait wait;
	@FindBy(id="container_tasks")
	private WebElement tasksLink;
	
	@FindBy(xpath="(//div[@class='menu_icon'])[2]")
	private WebElement menuIcon;
	
	@FindBy(id="container_users")
	private WebElement users;
	
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	
	public
	ActitimeHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void taskMethod()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(logoutLink));
		
		 js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click()",tasksLink);
		 
	}
	
	public void usersMethod()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(users));
		
		 js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click()",users);
		 
	}
	public void settingMethod()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(menuIcon));
		
		 js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click()",menuIcon);
		 
	}
	public void logoutMethod()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(logoutLink));
		
		 js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click()",logoutLink);
	}
	
	
	

}
