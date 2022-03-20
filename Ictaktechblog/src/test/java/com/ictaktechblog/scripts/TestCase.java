

package com.ictaktechblog.scripts;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Random;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ictaktechblog.TestBase.TestBase;
import com.ictaktechblog.constants.AutomationConstants;
import com.ictaktechblog.pages.Homepage;
import com.ictaktechblog.pages.LoginPage;
import com.ictaktechblog.pages.MyPosts;
import com.ictaktechblog.pages.NewPost;
import com.ictaktechblog.utilities.ExcelUtility;

public class TestCase extends TestBase
{
  LoginPage objLogin;
  LoginPage objLogin1;
  LoginPage objLogin2;
  Homepage objHome;
  Homepage objHome1;
 
  NewPost objNewPost;
  NewPost objNewPost1;
  NewPost objNewPost2;
  NewPost objNewPost3;
 
  MyPosts objMyPosts;
  MyPosts objMyposts1;
  MyPosts objMyposts2;
  @Test (priority=1)
     public void verifyValidLogin () throws IOException, InterruptedException
  	{
       
       objLogin = new LoginPage(driver);
      
        objLogin.ChooseLogin();
     
      
      String username = ExcelUtility.getCellData(0, 0);
      String password = ExcelUtility.getCellData(0, 1);
      objLogin.loginAs(username, password);
      String expectedTitle = AutomationConstants.HOMEPAGETITLE;
      String actualTitle = driver.getTitle();
      Assert.assertEquals(expectedTitle, actualTitle);
      
      
      
      }
  
  
  
  @Test (priority=2)
  public void verifyCreateTrainerPosts() throws IOException, InterruptedException
  {   
	  objNewPost = new NewPost(driver);
	  
	 
	 objNewPost.ClickNewPosts();
	 String title = ExcelUtility.getCellData(0, 3);
	 String imageurl=ExcelUtility.getCellData(2,3);
	 String post = ExcelUtility.getCellData(3,3);
	 objNewPost.CreateNewPost(title, imageurl, post);
	 Thread.sleep(2000);
	 try
	 {
	 driver.switchTo().alert().accept();
	 }
	 catch(NoAlertPresentException e)
	 {
		 System.out.println("exception handled");
	 }
	
	 
	 
  }
  
  
  
  
  @Test(priority = 3)
  public void verifyLogout() throws InterruptedException
  
  {   
	  objLogin = new LoginPage(driver);
	  Thread.sleep(2000);
	 objLogin.Logout();
  }
  
  
  
  @Test(priority = 4)
  public void verifyAdminValidLogin () throws IOException, InterruptedException
	{
     
     objLogin1 = new LoginPage(driver);
    
      objLogin1.ChooseLogin();
   
    
    String username = ExcelUtility.getCellData(1, 0);
    String password = ExcelUtility.getCellData(1, 1);
    objLogin.loginAs(username, password);
    String expectedTitle = AutomationConstants.HOMEPAGETITLE;
    String actualTitle = driver.getTitle();
    Assert.assertEquals(expectedTitle, actualTitle);
    
    
    
    }
  
  
  @Test(priority = 5)
  public void verifyCreateAdminPosts() throws IOException, InterruptedException
  {    
	  objHome = new Homepage(driver);
	  Thread.sleep(2000);
	  objHome.AdminNewPost();
	  
	  
	  objNewPost1 = new NewPost(driver);
	  
	  Thread.sleep(2000);
	  
	 
	 
	 String title = ExcelUtility.getCellData(0, 3);
	 String imageurl=ExcelUtility.getCellData(2,3);
	 String post = ExcelUtility.getCellData(3,3);
	 objNewPost1.CreateNewPost(title, imageurl, post);
	 Thread.sleep(2000);
	 try
	 {
	 driver.switchTo().alert().accept();
	 }
	 catch(NoAlertPresentException e)
	 {
		 System.out.println("exception handled");
	 }
	
	 
	 
  }
  
     
  @Test(priority = 6)
  public void verifyCreateUserPosts() throws InterruptedException, IOException
	  {
		  objLogin2 = new LoginPage(driver);
		  objLogin2.Logout();
		  objLogin2.ChooseLogin();
		 
		    String username = ExcelUtility.getCellData(2, 0);
		    String password = ExcelUtility.getCellData(2, 1);
		    objLogin2.loginAs(username, password);
		    
		  
		  
		     objNewPost2 = new NewPost(driver);
		     objNewPost.clickNewUserPosts();
		     String title = ExcelUtility.getCellData(0, 3);
			 String imageurl=ExcelUtility.getCellData(2,3);
			 String post = ExcelUtility.getCellData(3,3);
			 objNewPost2.CreateNewPost(title, imageurl, post);
			 Thread.sleep(2000);
			 try
			 {
			 driver.switchTo().alert().accept();
			 }
			 catch(NoAlertPresentException e)
			 {
				 System.out.println("exception handled");
			 }
			 
			 objLogin2 = new LoginPage(driver);
			 objLogin2.Logout();
			 
		  
	  }
}
  

