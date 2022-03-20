package com.ictaktechblog.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewPost 
{
	WebDriver driver;
	@FindBy (xpath = "//select[@name=\"p_cat\"]")
	private WebElement category;
	@FindBy(xpath = "//input[@name=\"P_title\"]")
	private WebElement title;
	@FindBy(xpath = "//input[@name=\"P_author\"]")
	private WebElement author;
	@FindBy(xpath = "//input[@name=\"P_image\"]")
	private WebElement imageurl;
	@FindBy(xpath = "//textarea[@name=\"p_post\"]")
	private WebElement post;
	@FindBy(xpath = "//button[@type=\"submit\"]//ancestor::form")
	private WebElement submitbtn;
	@FindBy(xpath = "//a[@href=\"/trainerpost\"]")
	WebElement trainernewpost;
	@FindBy(xpath="//a[@href=\"/mypost\"]")
	private WebElement myposts;
	@FindBy(xpath = "//p[@id=\"nav\"]")
	private WebElement catnav;
	@FindBy(xpath = "//a[@href=\"/usernewpost\"]")
	private WebElement usernewpost;
	
	
	 public NewPost (WebDriver driver)
	    {
	    	this.driver=driver;
	    	PageFactory.initElements(driver,this);
	    }
	 public void ClickNewPosts()
	    {
	    	trainernewpost.sendKeys(Keys.RETURN);
	    }
    	
    
	 public void CreateNewPost(String strTitle, String strUrl,String strPost) throws InterruptedException
	 {
		 title.sendKeys(strTitle);
		 //author.sendKeys(strAuthor);
		 Select categories=new Select(category);
		 categories.selectByIndex(3);
		 imageurl.sendKeys(strUrl);
		 post.sendKeys(strPost);
		 submitbtn.submit();
		 Thread.sleep(2000);
		 //driver.switchTo().alert().accept();
		 
	 }
	
	 public void clickMyPosts() 
	 {
		myposts.click();
	  }
	 
	 public void clickNewUserPosts()
	 {
		usernewpost.click();
	 }
	 
	   
	    
	    
	    
	    
}
