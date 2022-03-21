package com.techblog.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemoveCategoryPage {
	
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"navbarDropdown\"]")
	 private WebElement actions_link;
	@FindBy(xpath="//a[@href='/category']")
	private WebElement RemovecategoryLink;
	@FindBy(xpath="//li[contains(text(),'ZZZZ')] /button[contains(.,'Remove')]")
	private WebElement RemoveCat_Item;
	
	public RemoveCategoryPage(WebDriver driver)
    { 
		
		this.driver = driver;
		//This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
	
	public void Remove_category()throws IOException,InterruptedException
	{
		actions_link.click();
		Thread.sleep(3500);
	    RemovecategoryLink.click();
	    Thread.sleep(5000);
	    RemoveCat_Item.sendKeys(Keys.ENTER);
	    Thread.sleep(3000);
		driver.switchTo().alert().accept();
	}
}
