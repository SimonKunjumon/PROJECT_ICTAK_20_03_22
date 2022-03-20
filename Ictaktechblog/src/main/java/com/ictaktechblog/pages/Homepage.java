package com.ictaktechblog.pages;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage 
{
	 WebDriver driver;
	 @FindBy(xpath = "//p[@id=\"nav\" ][1]")
	 private WebElement actions;
	 @FindBy(xpath = "//a[@href=\"/newpost\"]")
	 private WebElement newpost;
	 @FindBy(xpath = "//a[@href=\"/approval\"]")
	 private WebElement approval;
     @FindBy(xpath = "//button[contains(text(),\"Approve\")][1]")
	 private WebElement approve;
     @FindBy(xpath = "//textarea[@name=\"p_post\"]")
     private WebElement message;
     @FindBy(xpath = "//button[@type=\"submit\"]")
     private WebElement send;
	 @FindBy(xpath = "//button[contains(text(),\"Reject\")][1]")
	 private WebElement reject;
	 @FindBy(xpath = "//a[@href=\"/category\"]")
	 private WebElement arcategory;
	 @FindBy(xpath = "//input[@name=\"category\"]")
	 private WebElement categorytxt;
	 @FindBy(xpath = "//button[@id=\"bt\"]")
	 private WebElement add;
	 
	 public Homepage(WebDriver driver)
	    {
	    	this.driver=driver;
	    	PageFactory.initElements(driver,this);
	    }
	 
	 public void AdminNewPost()
	 {
		 actions.click();
		 newpost.click();
		 
	 }
	 
	 public void AdminApprove() throws InterruptedException
	 {   
		 Thread.sleep(2000);
		 actions.click();
		 Thread.sleep(2000);
		 approval.click();
		 approve.sendKeys(Keys.ENTER);
      }
	 
	 public void Adminmessage(String adminmessage)
	 {
		 message.sendKeys(adminmessage);
		 send.submit();
		
		 
	 }
	 public void adminReject() throws InterruptedException
	 {  
		 actions.click();
		 Thread.sleep(2000);
		 approval.click();
		 Thread.sleep(2000);
		 reject.sendKeys(Keys.ENTER);
		 
	 }
	 
	
	 
}

