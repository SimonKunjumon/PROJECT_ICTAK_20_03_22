package com.techblog.scripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import com.techblog.TestBase.TestBase;
import com.techblog.constants.AutomationConstants;
import com.techblog.pages.HomePage;
import com.techblog.pages.LoginPage;
import com.techblog.utilities.ExcelUtility;



@Test
public class TestClass extends TestBase{
	
LoginPage objLogin;
HomePage objHomePage;




@Test (priority=1)
	public void verifyValidLogin() throws IOException,InterruptedException
	{
	objLogin = new LoginPage(driver);
    objLogin.ChooseLogin();
    String username = ExcelUtility.getCellData(0, 0);
    String password = ExcelUtility.getCellData(0, 1);
   //Admin Login
    objLogin.clickLogin(username,password);
    Thread.sleep(2000);
    
    String expectedTitle =AutomationConstants.HOMEPAGETITLE;
	String actualTitle =driver.getTitle();
    AssertJUnit.assertEquals(expectedTitle,actualTitle);
    }


@Test(priority=2)
  public void Verify_AdminHome()throws IOException,InterruptedException
  {
	objHomePage = new HomePage(driver);
	//Navigate to Home Page
	objHomePage.clickHomeLink();
	Thread.sleep(2000);
	
 }

@Test(priority=3)
public void mypost()throws IOException,InterruptedException
{
	objHomePage = new HomePage(driver);
	//navigate to Mypost Page
	objHomePage.mypost();
	Thread.sleep(4000);
}

@Test(priority=4)
public void aboutus()throws IOException, InterruptedException
{
	objHomePage=new HomePage(driver);
	objHomePage.aboutusLink();
	Thread.sleep(4000);
}


}

