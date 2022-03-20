package com.ictaktechblog.pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class MyPosts 
{
	WebDriver driver;
	@FindBy(xpath = "//a[@href=\"/mypost\"]")
	private WebElement myposts;
	@FindBy(xpath="//button[contains(text(),\"Edit\")][1]")
	private WebElement editbtn;
	@FindBy(xpath="//button[contains(text(),\"Delete\")]")
	private WebElement deletebtn;
	@FindBy(xpath = "//small[text()=\"Read more\"]")
	private WebElement readmore;
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
	public  MyPosts(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
    }
	public void clickMyPosts() throws InterruptedException
	{   Thread.sleep(2000);
		myposts.sendKeys(Keys.RETURN);
	}
   public void ClickEditPost()
   {
	   editbtn.sendKeys(Keys.ENTER);
	   
	   
   } 
   
   public void DeletePost()
   {
	   deletebtn.click();
   }
   public void EditPost(String strTitle,String strImgUrl,String strPost)
   {   
	   title.clear();
	   title.sendKeys(strTitle);
	   imageurl.clear();
	   imageurl.sendKeys(strImgUrl);
	   post.clear();
	   post.sendKeys(strPost);
	   submitbtn.submit();
	   
	   
	}
   
   public void editAuthor(String strAuthor)
   {
	   author.clear();
	   author.sendKeys(strAuthor);
	   
   }
}




