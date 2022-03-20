package com.ictaktechblog.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Category 
{    WebDriver driver;
     @FindBy(xpath = "//p[@id=\"nav\" ][1]")
     private WebElement actions;
	 @FindBy(xpath = "//a[@href=\"/category\"]")
	 private WebElement arcategory;
	 @FindBy(xpath = "//input[@name=\"category\"]")
	 private WebElement categorytxt;
	 @FindBy(xpath = "//button[@id=\"bt\"]")
	 private WebElement add;
	 @FindBy(xpath = "//button[contains(text(),\"Remove\")]")
	 private WebElement remove;
	 public Category(WebDriver driver)
	    {
	    	this.driver=driver;
	    	PageFactory.initElements(driver,this);
	    }
	
	
	 public void adminAddCategory(String categoryname) throws InterruptedException
	 {
		 actions.click();
		 Thread.sleep(2000);
		 arcategory.click();
		 categorytxt.sendKeys(categoryname);
		 add.sendKeys(Keys.ENTER);
		 
		 
		 
	 }
	 public void validateAdminAddCategory(String categoryname) throws InterruptedException
	 {   
		 actions.click();
		 
		 arcategory.click();
		 categorytxt.sendKeys(categoryname);
		 
	}
	 
	 public void adminRemoveCategory() throws InterruptedException
	 {   actions.click();
	     arcategory.click();
	     Thread.sleep(2000);
		 List<WebElement> buttons = driver.findElements(By.xpath("//button[@id=\"bt\"]"));
		 int count=buttons.size()-1;
		 WebElement removelast = buttons.get(count);
		 Thread.sleep(2000);
		 removelast.sendKeys(Keys.RETURN);

	 }

}
