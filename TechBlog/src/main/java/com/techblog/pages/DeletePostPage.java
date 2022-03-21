package com.techblog.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePostPage {
	
	WebDriver driver;
	@FindBy(xpath="//a[contains(text(),'My posts')]")
	private WebElement mypostLink;
	@FindBy(xpath="/html/body/app-root/app-mypost/div[2]/li[4]/div/div/div/button[2]")
	private WebElement delete;
	
	public DeletePostPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
//delete the admin post
	public void delete_post()throws IOException,InterruptedException
	{
		mypostLink.click();
		Thread.sleep(5000);
	    delete.sendKeys(Keys.ENTER);
		Thread.sleep(6000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
	}
	
}
