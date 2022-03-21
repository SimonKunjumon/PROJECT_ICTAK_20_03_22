package com.techblog.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	 @FindBy(xpath="//img[@src='../../assets/images/user.png']")
	 private WebElement dropdown;
	 @FindBy(xpath="//a[@href=\"/login\"]")
	 private WebElement login;
	 @FindBy(id="user")
	 private WebElement email;
	 @FindBy(id="pwd")
	 private WebElement password;
	 @FindBy(id="logbut")
	 private WebElement loginbutton;
	 @FindBy(xpath="//*[contains(text(),\"logout\")]")
	 private WebElement logout;
	 
	
	
	public LoginPage(WebDriver driver)
        { 
		this.driver = driver;
       //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
        }
	
	 public void ChooseLogin()throws IOException,InterruptedException
	    {
	    	dropdown.click();
	    	Thread.sleep(2000);
	    	login.click();
	    	
	    }

		
	public void clickLogin(String username, String password1)throws IOException,InterruptedException
	{
		
		 email.sendKeys(username);
		 password.sendKeys(password1);
		 Thread.sleep(1000);
		 loginbutton.click();
		
		 
       
	}
	
	public void clickInvalidLogin(String username, String password1)throws IOException,InterruptedException
	{
		
		 email.sendKeys(username);
		 password.sendKeys(password1);
		 Thread.sleep(1000);
		 loginbutton.click();
		 driver.switchTo().alert().accept();
		 
       
	}
	public void logout()throws IOException,InterruptedException
	{
	logout.click();
	}
	
	

	

}


