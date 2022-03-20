package com.ictaktechblog.scripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ictaktechblog.TestBase.TestBase;
import com.ictaktechblog.constants.AutomationConstants;
import com.ictaktechblog.pages.Category;
import com.ictaktechblog.pages.Homepage;
import com.ictaktechblog.pages.LoginPage;
import com.ictaktechblog.utilities.ExcelUtility;

public class TestCase4 extends TestBase 
{   LoginPage objLoginPage6;
    LoginPage objLoginPage7;
    
	Category objCategory;
	Category objCategory1;
	Category objCategory2;
	@Test(priority = 13)
	public void verifyAddCategory() throws InterruptedException, IOException
	{   
		objLoginPage6 = new LoginPage(driver);
		
		objLoginPage6.ChooseLogin();
		
		String username = ExcelUtility.getCellData(1, 0);
	    String password = ExcelUtility.getCellData(1, 1);
	    objLoginPage6.loginAs(username, password);
	    
	    objCategory = new Category(driver);
	    String catname=ExcelUtility.getCellData(8, 3);
	    objCategory.adminAddCategory(catname);
	    Thread.sleep(2000);
	    String actual = driver.switchTo().alert().getText();
	    driver.switchTo().alert().accept();
	    String expected = AutomationConstants.ADD_CATEGORY_MESSAGE;
	    Assert.assertEquals(actual, expected);
	    
	    
	    
	    
	}
	@Test(priority = 13)
	public void verifyRemoveCategory() throws InterruptedException, IOException
	
	{
		
		
		objCategory1 = new Category(driver);
	
		objCategory1.adminRemoveCategory();
		String actual = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String expected = AutomationConstants.REMOVE_CATEGORY_MESSAGE;
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 14)
	public void verifyAddCategoryValidation() throws IOException, InterruptedException
	{   
		objCategory2 = new Category(driver);
		String newcategory = ExcelUtility.getCellData(9,3);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");
		Thread.sleep(2000);
		objCategory2.validateAdminAddCategory(newcategory);
		WebElement add = driver.findElement(By.xpath("//button[@id=\"bt\"]"));
		Assert.assertEquals(add.isEnabled(), false);
		objLoginPage7 = new LoginPage(driver);
		objLoginPage7.Logout();
		
	}

}
