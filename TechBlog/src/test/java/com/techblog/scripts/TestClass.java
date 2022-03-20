package com.techblog.scripts;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.techblog.pages.LoginPage;
import com.techblog.pages.SignUp;
import com.techblog.pages.ContactUs;
import com.techblog.pages.Feedback;
import com.techblog.constants.AutomationConstants;

import com.techblog.utilities.ExcelUtility;


public class TestClass extends TestBase {
	
	
	LoginPage objLogin;
	ContactUs objContactus;

	/*@Test(priority=0)
	public void verifyValidLogin() throws IOException {
		
		objLogin = new LoginPage(driver);
		objLogin.ChooseLogin();
		
		String username = ExcelUtility.getCellData(0, 0);
		String password = ExcelUtility.getCellData(0, 1);
		objLogin.setUserName(username);
		objLogin.setPassword(password);
		objLogin.clickLogin();
		String expectedTitle = AutomationConstants.HOMEPAGETITLE;
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	@Test(priority=1)
	
	public void verifyContactUs() throws IOException, InterruptedException {
		
		objContactus = new ContactUs(driver);
		objContactus.contact();
		
		String name = ExcelUtility.getCellData(1, 0);
		String email = ExcelUtility.getCellData(1, 1);
		String message = ExcelUtility.getCellData(1, 2);
		objContactus.setname(name);
		objContactus.setemail(email);
		objContactus.setmessage(message);
		Thread.sleep(2000);
		objContactus.sendbutton();
		Thread.sleep(5000);
	}*/
	
	@Test(priority=2)
	public void verifyValidUserSignup() throws IOException, InterruptedException {
		
	//Create ValidSignup Page object
	
	SignUp objSignUp = new SignUp(driver);
	driver.navigate().refresh();
	objSignUp.clickDropDown();
	objSignUp.SelectSignUp();
	//login to application
	String yourname = ExcelUtility.getCellData(3, 0);
	String youremail = ExcelUtility.getCellData(3, 1);
	String yourpassword = ExcelUtility.getCellData(3, 2);
	objSignUp.setYourName(yourname);
	objSignUp.SelectUser();
	objSignUp.setYourEmail(youremail);
	objSignUp.setYourPassword(yourpassword);
	Thread.sleep(2000);
	objSignUp.clickSubmitUser();

	Thread.sleep(2000);
	String alertmessg3=driver.switchTo().alert().getText();
	System.out.println(alertmessg3);
	driver.switchTo().alert().accept();
	Thread.sleep(2000);
	
	String expectedURL =AutomationConstants.HOMEPAGETITLE;
	String actualURL =driver.getCurrentUrl();
	Assert.assertEquals(expectedURL,actualURL);
	}

}
