package com.techblog.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PendingApprovalPage {
	
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"navbarDropdown\"]")
	 private WebElement actions_link;
	@FindBy(xpath="//a[@href='/approval']")
	private WebElement pendingApproval_link;
	@FindBy(xpath="/html/body/app-root/app-pendingapproval/div[2]/li[4]/div/div/div/button[1]")
	private WebElement approvebutton;
	@FindBy(xpath="/html/body/app-root/app-comment/form/div/textarea")
	private WebElement comment;
	@FindBy(xpath="/html/body/app-root/app-comment/form/button")
	private WebElement submitcom;
	@FindBy(xpath="//li[10]//button[contains(.,'Reject')]")
	private WebElement reject;
	
	public PendingApprovalPage(WebDriver driver)
    { 
		
		this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
	
	public void Approve_post()throws IOException,InterruptedException
	{
		//pending approval link is clicked
		actions_link.click();
		Thread.sleep(5000);
		pendingApproval_link.click();
		approvebutton.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		
	}
	
	public void approve(String comment1)throws IOException,InterruptedException
	{
		//comments send to user
		comment.sendKeys(comment1);
		Thread.sleep(5000);
		submitcom.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		
	}
	
}
