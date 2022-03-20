package com.ictaktechblog.scripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ictaktechblog.TestBase.TestBase;
import com.ictaktechblog.constants.AutomationConstants;
import com.ictaktechblog.pages.Homepage;
import com.ictaktechblog.pages.LoginPage;
import com.ictaktechblog.pages.MyPosts;
import com.ictaktechblog.pages.NewPost;
import com.ictaktechblog.utilities.ExcelUtility;

public class TestCase3 extends TestBase
{
  LoginPage objLoginPage5;
  LoginPage objLoginPage6;
  Homepage objHomepage2;
  MyPosts objMyPosts3;
  MyPosts objMyPosts4;
  MyPosts objMyPosts5;
  NewPost objNewPost6;
  @Test(priority = 10)
  public void verifyEditPost() throws InterruptedException, IOException
  {
	 objLoginPage5 = new LoginPage(driver);
	 
	 objLoginPage5.ChooseLogin();
	 
	 String username = ExcelUtility.getCellData(0, 0);
     String password = ExcelUtility.getCellData(0, 1);
     objLoginPage5.loginAs(username, password);
     
     objMyPosts3 = new MyPosts(driver);
     Thread.sleep(2000);
     objMyPosts3.ClickEditPost();
     String ntitle = ExcelUtility.getCellData(5, 3);
     String nimgurl = ExcelUtility.getCellData(6, 3);
     String npost =ExcelUtility.getCellData(7, 3);
     objMyPosts3.EditPost(ntitle,nimgurl,npost);
     
     String actual = driver.switchTo().alert().getText();
     driver.switchTo().alert().accept();
     String expected = AutomationConstants.EDITSUCCESSMESSAGE;
     Assert.assertEquals(actual, expected);
     
     
    }
  @Test(priority = 11)
  public void verifyAuthorNameEdit() throws InterruptedException, IOException
  {
	  objMyPosts4 = new MyPosts(driver);
	  
	  objMyPosts4.clickMyPosts();
	  
	  objMyPosts4.ClickEditPost();
	  
	  String Authorname = ExcelUtility.getCellData(1, 0);
      objMyPosts4.editAuthor(Authorname);
      WebElement Author = driver.findElement(By.xpath("//input[@name=\"P_image\"]"));
      Assert.assertEquals(Author.isEnabled(),false); //checks if the textbox for author is enabled or disabled
	  
	     
	     
  }
  @Test(priority = 12)
  public void verifyRemovePosts() throws InterruptedException
  {
	  objMyPosts5 = new MyPosts(driver);
	  objMyPosts5.clickMyPosts();
	  objMyPosts5.DeletePost();
	  String expected = driver.switchTo().alert().getText();
	  driver.switchTo().alert().accept();
	  String actual = AutomationConstants.DELETE_MESSAGE;
	  Assert.assertEquals(actual, expected);
	  
	  objLoginPage6 = new LoginPage(driver);
	  objLoginPage6.Logout();
  }
}
