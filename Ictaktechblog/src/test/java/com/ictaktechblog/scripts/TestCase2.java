package com.ictaktechblog.scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ictaktechblog.TestBase.TestBase;
import com.ictaktechblog.constants.AutomationConstants;
import com.ictaktechblog.pages.Homepage;
import com.ictaktechblog.pages.LoginPage;
import com.ictaktechblog.utilities.ExcelUtility;

public class TestCase2 extends TestBase 

{ LoginPage objlogin4;
LoginPage objlogin5;
  Homepage objHomepage;
  Homepage objHomepage1;
  @Test(priority = 9)
  public void VerifyApprove() throws InterruptedException, IOException
  {
	  objlogin4 = new LoginPage(driver);
      
      objlogin4.ChooseLogin();
   
    
    String username = ExcelUtility.getCellData(1, 0);
    String password = ExcelUtility.getCellData(1, 1);
    objlogin4.loginAs(username, password);
    
    objHomepage = new Homepage(driver);
    objHomepage.AdminApprove();
    Thread.sleep(2000);
    String actualresult=driver.switchTo().alert().getText();
    driver.switchTo().alert().accept();
    String expectedresult=AutomationConstants.APPROVALMESSAGE;
    Assert.assertEquals(actualresult, expectedresult);
    String adminmessage=ExcelUtility.getCellData(3, 3);
    objHomepage.Adminmessage(adminmessage);
    Thread.sleep(2000);
    String actual=driver.switchTo().alert().getText();
    driver.switchTo().alert().accept();
    
    String expected=AutomationConstants.ADM_MESSAGE;
    Assert.assertEquals(actual, expected);
    
    
    
  }
  @Test(priority = 10)
  public void verifyReject() throws InterruptedException, IOException
  {
	 objHomepage1 = new Homepage(driver);
	 objHomepage1.adminReject();
	 Thread.sleep(2000);
	 String actualresult=driver.switchTo().alert().getText();
	    driver.switchTo().alert().accept();
	    String expectedresult=AutomationConstants.REJECTMESSAGE;
	    Assert.assertEquals(actualresult, expectedresult);
	    String adminmessage=ExcelUtility.getCellData(3, 3);
	    objHomepage.Adminmessage(adminmessage);
	    Thread.sleep(2000);
	    String actual=driver.switchTo().alert().getText();
	    driver.switchTo().alert().accept();
	    
	    String expected=AutomationConstants.ADM_MESSAGE;
	    Assert.assertEquals(actual, expected);
	    Thread.sleep(2000);
	    objlogin5 = new LoginPage(driver);
	    objlogin5.Logout();
	    
	 
  }
}
