package com.techblog.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PendingPostRejectPage {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"navbarDropdown\"]")
	 private WebElement actions_link;
	@FindBy(xpath="//a[@href='/approval']")
	private WebElement pendingApproval_link;
	@FindBy(xpath="/html/body/app-root/app-pendingapproval/div[2]/li[52]/div/div/div/button[2]")
	private WebElement reject;
	@FindBy(xpath="/html/body/app-root/app-comment/form/div/textarea")
	private WebElement comment;
	@FindBy(xpath="/html/body/app-root/app-comment/form/button")
	private WebElement send;
	
	public PendingPostRejectPage (WebDriver driver)
    { 
		
		this.driver = driver;
       //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
	
	public void Reject_Post()throws IOException,InterruptedException 
	{
		actions_link.click();
		Thread.sleep(3000);
		pendingApproval_link.click();
		Thread.sleep(3000);
		reject.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
        driver.switchTo().alert().accept();
		
		
		// TODO Auto-generated method stub
		
	}
	
	public void Send_Comments(String text)throws IOException,InterruptedException 
	{
		comment.sendKeys(text);
		Thread.sleep(4000);
		send.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
	}

}
