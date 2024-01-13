package generic;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage
{
//webDriver Interface
	public void validateTitle(WebDriver driver,String expectedTitle)
	{
		Assert.assertEquals(driver.getTitle(),expectedTitle,"both titles are not matching");
	}
	public void validateCurrentURL(WebDriver driver,String expectedURL)
	{
		Assert.assertEquals(driver.getCurrentUrl(),expectedURL,"both url are not matching");
	}
	public void navigateTo(WebDriver driver,String url)
	{
		driver.navigate().to(url);
	}
	public void navigateBack(WebDriver driver)
	{
		driver.navigate().back();
	}
	public void navigateForword(WebDriver driver)
	{
		driver.navigate().forward();
	}
	public void navigateRefresh(WebDriver driver)
	{
		driver.navigate().refresh();;
	}
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void minimize(WebDriver driver)
	{
		driver.manage().window().minimize();;
	}
	public void fullscreen(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	public void getPageSource(WebDriver driver)
	{
		driver.getPageSource();
	}
	public Set<Cookie> getCookies(WebDriver driver ,Set<Cookie> cookies)
	{
		driver.manage().getCookies();
		return cookies;
	}
	public void getSize(WebDriver driver)
	{
		driver.manage().window().getSize();
	}
	public void setSize(WebDriver driver,int dimensionX,int dimensionY)
	{
		Dimension dimension=new Dimension(dimensionX,dimensionY);
		driver.manage().window().setSize(dimension);
	}
	public void getPosition(WebDriver driver)
	{
		driver.manage().window().getPosition();
	}
	public void setPosition(WebDriver driver,int pointX,int pointY)
	{
		Point point=new Point(pointX,pointY);
		driver.manage().window().setPosition(point);
	}
	
//WebElement Interface
	public void sendKeys(WebElement element,String value)
	{
		element.sendKeys(value);
	}
	public void click(WebElement element)
	{
		element.click();
	}
	public void validateText(WebElement element,String expectedText)
	{
		Assert.assertEquals(element.getText(),expectedText,"both text are not matching");
	}
	public void validateGetTagName(WebElement element,String expectedTagName)
	{
		Assert.assertEquals(element.getTagName(),expectedTagName,"both tag are not matching");
	}
	public void clear(WebElement element)
	{
		element.clear();
	}
	public void validateGetAttribute(WebElement element,String AttributeName,String AttributeValue)
	{
		Assert.assertEquals(element.getAttribute(AttributeName),AttributeValue,"attribute value not validated");
	}
	public void lengthOfValue(WebElement element,String AttributeName)
	{
		element.getAttribute(AttributeName).length();
	}
	public void getLocation(WebElement element)
	{
		element.getLocation();
	}
	public void getSize(WebElement element)
	{
		element.getSize();
	}
	public void getRect(WebElement element)
	{
		element.getRect();
	}
	public void getHeight(WebElement element)
	{
		Rectangle rectangle=element.getRect();
		rectangle.getHeight();
	}
	public void getWidth(WebElement element)
	{
		Rectangle rectangle=element.getRect();
		rectangle.getWidth();
	}
	public void getXaxis(WebElement element)
	{
		Rectangle rectangle=element.getRect();
		rectangle.getX();
	}
	public void getYaxis(WebElement element)
	{
		Rectangle rectangle=element.getRect();
		rectangle.getY();
	}
	public void IsDisplayedIsEnabled(WebElement element,String NameofElement)
	{
		if(element.isDisplayed()&& element.isEnabled())
		{
			element.sendKeys(NameofElement);
		}
	}
	public void IsSelected(WebElement element)
	{
		if(element.isSelected())
		{
			element.click();
		}
	}
	public void GetCssValue(WebElement element,String attributeName)
	{
		System.out.println(element.getAttribute(attributeName));
		
	}
	public void IsEmpty(WebElement element,String attributeName)
	{
		if(element.getAttribute(attributeName).isEmpty())
		{
			System.out.println("element is empty");
		}
	}
	public void IsBlank(WebElement element,String attributeName)
	{
		if(element.getAttribute(attributeName).isEmpty())
		{
			System.out.println("element is blank");
		}
	}
//Select Class
	public void selectByText(WebElement element,String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);	
	}
	public void selectByValue(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);	
	}
	public void selectByIndex(WebElement element,int indextNumber)
	{
		Select select=new Select(element);
		select.selectByIndex(indextNumber);	
	}
	public void deselectAll(WebElement element)
	{
		Select select=new Select(element);
				select.deselectAll();
	}
	public void deselectByText(WebElement element,String text)
	{
		Select select=new Select(element);
		select.deselectByVisibleText(text);
	}
	public void deselectByValue(WebElement element,String value)
	{
		Select select=new Select(element);
		select.deselectByValue(value);	
	}
	public void deselectByIndex(WebElement element,int indextNumber)
	{
		Select select=new Select(element);
		select.deselectByIndex(indextNumber);	
	}
	public void selectIsMultiple(WebElement element)
	{
		Select select=new Select(element);
		Assert.assertEquals(select.isMultiple(),true,"dropdown is not multiple");
	}
	public void selectGetOptions(List<WebElement> elements,String Text,int options)
	{
		Select select=new Select((WebElement) elements);
        System.out.println(select.getOptions().get(options).getText());
	}
	public void getAllSelectedOptions()
	{
		
	}
	public void getFirstSelectedOptions()
	{
		
	}
//Actions Class
	public void click(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.click(element).perform();
	}
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.doubleClick(element).perform();
	}
	public void moveToElement(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	public void contextClick(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.contextClick(element).perform();
	}
	public void scrollToElement(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.scrollToElement(element).perform();
	}
	public void dragAndDrop(WebDriver driver,WebElement source,WebElement target)
	{
		Actions actions=new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}
	public void keysUp_KeysDown(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(element).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).perform();
	}
	public void clickAndHold(WebDriver driver,WebElement source,WebElement target)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(source).clickAndHold().moveToElement(target).release().perform();
	}
	public void slider()
	{
		
	}
//Robot class
	public void robotEnter() throws AWTException
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
//WebDriverWait Class
	public void waitVisiblityofElement(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitVisiblityofAllElement(WebDriver driver,List<WebElement> elements)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	public void waitTitle(WebDriver driver,String value)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleIs(value));
	}
	public void waitTitleContains(WebDriver driver,String value)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains(value));
	}
	public void waitURLMatches(WebDriver driver,String url)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.urlMatches(url));
	}
	public void waitURLContains(WebDriver driver,String url)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.urlContains(url));
	}
	public void waitAttributeContains(WebDriver driver,By locator,String attribute,String value)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.attributeContains(locator,attribute, value));
	}
	public void waitElementToBeClickable(WebDriver driver,By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	public void waitElementToBeSelected(WebDriver driver,By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeSelected(locator));
	}
	public void waitTextToBe(WebDriver driver,By locator,String value)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.textToBe(locator,value));
	}
	public void waitAlerTsPresent(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
	}
//Alert Interface
	public void alertAccept(WebDriver driver)
	{
		Reporter.log("text of alert is:"+driver.switchTo().alert().getText(),true);
		driver.switchTo().alert().accept();
	}
	public void alertDismiss(WebDriver driver)
	{
		Reporter.log("text of alert is:"+driver.switchTo().alert().getText(),true);
		driver.switchTo().alert().dismiss();
	}
//JavascriptExecutor Interface
	public void javascriptClick(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",element);
	}
	public void javascriptEnter(WebDriver driver,WebElement element,String value)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(value,element);
	}
	public void javascriptRandomScroll(WebDriver driver,WebElement element,String value)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		javascriptRandomScroll(driver, element, value);
	}
	public void javascriptScrollLocation(WebDriver driver,WebElement element,String value)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
	}
	public void javascriptCreateAlertPopup(WebDriver driver ,String name)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(name)");	
	}
	public void javascriptCreatePromptPopup(WebDriver driver ,String name)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("prompt(name)");	
	}
	public void javascriptCreateconfirmPopup(WebDriver driver ,String name)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("confirm(name)");	
	}
	public void javascriptDisabledElement(WebDriver driver ,String value,WebElement disabledTextbox)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("value",disabledTextbox);	
	}
	public void javascriptGetTitle(WebDriver driver ,String name)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		System.out.println(js.executeScript("return document.title"));	
	}
	public void javascriptGetURL(WebDriver driver ,String name)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		System.out.println(js.executeScript("return document.URL"));	
	}
	public void javascriptRefreshPage(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("history.go(0)");	
	}
	public void javascriptCalenderPopup(WebDriver driver,WebElement element,String value)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(value,element);
	}
	public void javascriptHighlightElement(WebDriver driver,WebElement element) throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style','background:blue')",element);
		Thread.sleep(1000);
		js.executeScript("arguments[0].setAttribute('style','background:white')",element);
	
	}
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
