package com.techblog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs 
{
	WebDriver driver;
	
	@FindBy(xpath="//a[@href=\"/contactus\"]")
	private WebElement contactus;
	
	@FindBy(id="name")
	private WebElement name;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(xpath="//*[@placeholder=\"MESSAGE\"]")
	private WebElement message;
	
	@FindBy(xpath="//*[@class=\"alt-send-button\"]")
	private WebElement sendbutton;
	
	 public ContactUs(WebDriver driver)
	    {
	    	this.driver=driver;
	    	PageFactory.initElements(driver,this);
	    }
	
	public void contact() {
		contactus.click();
	    }
	
	 public void setname(String strname){
	    	name.sendKeys(strname);
	    	}
	 public void setemail(String stremail){
	    	email.sendKeys(stremail);
	    	}
	 public void setmessage(String strmessage){
		    message.sendKeys(strmessage);
	    	}
	
	public void sendbutton() {
		sendbutton.click();
	}

		
	}
	


