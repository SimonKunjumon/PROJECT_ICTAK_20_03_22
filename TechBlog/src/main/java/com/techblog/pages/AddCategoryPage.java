package com.techblog.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategoryPage {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"navbarDropdown\"]")
	 private WebElement actions_link;
	@FindBy(xpath="//a[@href='/category']")
	private WebElement addcategoryLink;
	@FindBy(xpath="//input[@type=\"text\"][@name=\"category\"]")
	private WebElement addcategoryName;
	@FindBy(xpath="//button[contains(.,'Add')]")
	private WebElement Add;
	
	
			
	
	public AddCategoryPage(WebDriver driver)
    { 
		
		this.driver = driver;
	    //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
	
	public void Add_category()throws IOException,InterruptedException
	{
		actions_link.click();
		Thread.sleep(6000);
	    addcategoryLink.click();
		Thread.sleep(6000);
	}
   public void Fun_addCategry(String cat_name)throws IOException,InterruptedException
   {
	   //admin add new category
	   addcategoryName.sendKeys(cat_name);
	   Thread.sleep(6000);
	   Add.click();
	   Thread.sleep(6000);
	   driver.switchTo().alert().accept();
   }
   	

}
