package testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.BaseTest;
import pages.ActitimeLoginPage;

public class TC1_ActitimeLogin extends BaseTest
{
	@Test
	public void login() throws InterruptedException, IOException
	{
		ActitimeLoginPage loginpage=new ActitimeLoginPage(driver);
		loginpage.loginMethod();	
	}
}