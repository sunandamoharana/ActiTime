package generic;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenShot implements ITestListener
{

public void onTestFailure(ITestResult result)
{
	TakesScreenshot ts=(TakesScreenshot) BaseTest.driver;
	File srcfile=ts.getScreenshotAs(OutputType.FILE);
	if(result.getStatus()==1)
	{
		System.out.println("testcase is passed");
	}
	else if(result.getStatus()==2)
	{
		System.out.println("testcase is failed");
	}
	else if(result.getStatus()==3)
	{
		System.out.println("testcase is skipped");
	}
	String methodname=result.getName();
	Date date=Calendar.getInstance().getTime();
	String today=date.toString().replaceAll(":","-");
	File destFile=new File("./failedScreenshot/"+methodname+today+".png");
	try
	{
		FileHandler.copy(srcfile, destFile);
	}
	catch(IOException e)
	{
		
	};
}

}
