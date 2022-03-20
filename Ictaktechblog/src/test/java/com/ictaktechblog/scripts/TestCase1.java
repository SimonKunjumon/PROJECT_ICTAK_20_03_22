package com.ictaktechblog.scripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ictaktechblog.TestBase.TestBase;
import com.ictaktechblog.constants.AutomationConstants;
import com.ictaktechblog.pages.LoginPage;
import com.ictaktechblog.pages.NewPost;
import com.ictaktechblog.utilities.ExcelUtility;

public class TestCase1 extends TestBase
{  	LoginPage objLogin3;
	LoginPage objLogin4;
	LoginPage objLogin31;
    
    NewPost objNewPost4;
    NewPost objNewPost5;
	
	@Test(priority = 7)
	public void verifyNewPostsValidation() throws InterruptedException, IOException, NoAlertPresentException
	{
	
		
		
			objLogin3 = new LoginPage(driver);
		      
	        objLogin3.ChooseLogin();
	     
	      
	      String username = ExcelUtility.getCellData(0, 0);
	      String password = ExcelUtility.getCellData(0, 1);
	      objLogin3.loginAs(username, password);
	      
	      objNewPost4 = new NewPost(driver);
	      objNewPost4.ClickNewPosts();
	      String title="";
	 	 
	     String imageurl="";
	 	 String post ="";
	 	 objNewPost4.CreateNewPost(title, imageurl, post);
	 	 Thread.sleep(2000);
	 	 String actualresult=driver.switchTo().alert().getText();
	 	driver.switchTo().alert().accept();
		 
		 String expectedresult=AutomationConstants.NEW_POSTS_ERROR;
	 	 Assert.assertEquals(actualresult, expectedresult);
	 	 
	 	
	 
	 	 
	 	 
	   }
	@Test(priority = 8)
	public void verifyInvalidNewPost() throws InterruptedException, IOException
	{

		
     
      
      
      
      
      objNewPost5 = new NewPost(driver);
     Thread.sleep(2000);
      objNewPost5.ClickNewPosts();
      String title=ExcelUtility.getCellData(0, 3);
 	 
     String imageurl=ExcelUtility.getCellData(1, 3);
 	 String post =ExcelUtility.getCellData(3, 3);
 	 objNewPost5.CreateNewPost(title, imageurl, post);
 	 Thread.sleep(2000);
 	 String actualresult=driver.switchTo().alert().getText();
 	 driver.switchTo().alert().accept();
 	 objLogin31 = new LoginPage(driver);
 	 Thread.sleep(2000);
 	 objLogin31.Logout();

	 String expectedresult=AutomationConstants.INVALID_DATA_ERROR;
 	 Assert.assertEquals(actualresult, expectedresult);
 	 
 	/* objLogin31 = new LoginPage(driver);
 	 Thread.sleep(2000);
 	 objLogin31.Logout();*/

	}
 
	

}
