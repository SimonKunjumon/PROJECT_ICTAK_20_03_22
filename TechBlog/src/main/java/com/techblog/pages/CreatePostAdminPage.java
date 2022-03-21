package com.techblog.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePostAdminPage {
	WebDriver driver;
	 @FindBy(xpath="//*[@id=\"navbarDropdown\"]")
	 private WebElement actionLink;
	 @FindBy(xpath="//a[@href='/newpost']")
	 private WebElement newpost_link;
	 @FindBy(xpath="//*[@id=\"exampleInputEmail1\"]")
	 private WebElement title;
	 @FindBy(xpath="//*[@name=\"P_image\"]")
	 private WebElement img_url;
	 @FindBy(xpath="/html/body/app-root/app-newpost/form/div[4]/select")
	 private WebElement category;
	 @FindBy(xpath="//select[@name='p_cat']/option[10]")
	 private WebElement select_category;
	 @FindBy(xpath="//*[@name=\"p_post\"]")
	 private WebElement post_content;
	 @FindBy(xpath="/html/body/app-root/app-newpost/form/button")
	 private WebElement submit;
	 
	
	 
	 public CreatePostAdminPage(WebDriver driver) 
	 {
		    this.driver=driver;
			//This initElements method will create all WebElements
			 PageFactory.initElements(driver,this);
	}
	 public void create_post()throws IOException,InterruptedException
		{
			 actionLink.click();
			 Thread.sleep(3000);
			 newpost_link.click();
			 Thread.sleep(4000);
			
		}
	
	 public void Post_contentsAdd(String title1,String img,String post)throws IOException,InterruptedException
	 {
		 //Pass values to the filed of new post
		 title.sendKeys(title1);
		 Thread.sleep(3000);
		 img_url.sendKeys(img);
		 Thread.sleep(3000);
		 category.sendKeys(Keys.ENTER);
		 Thread.sleep(3000);
		 select_category.click();
		 Thread.sleep(3000);
		 post_content.sendKeys(post);
		 submit.sendKeys(Keys.ENTER);
		 Thread.sleep(5000);
		 driver.switchTo().alert().accept();
		 Thread.sleep(5000);
		 
	 }

	
	 
	 
	 

}
