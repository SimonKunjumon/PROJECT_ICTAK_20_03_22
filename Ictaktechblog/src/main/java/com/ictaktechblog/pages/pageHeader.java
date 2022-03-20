package com.ictaktechblog.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class pageHeader {

	WebDriver driver;
	@FindBy(xpath="//a[@href=\"/mypost\"]")
	private WebElement myposts;
	@FindBy(xpath="//a[@href=]")
	private WebElement createpost;
	@FindBy(xpath="//a[@href='/'] //ancestor::li")
	private WebElement home;
	@FindBy(xpath="//p[@id=\"nav\"]")
	private WebElement categories;
	Select category=new Select(categories);
	List<WebElement> categoryoptions = category.getOptions();
	@FindBy(xpath="//a[@href=\"/aboutus\"]//ancestor::li")
	private WebElement aboutus;
	@FindBy(xpath="//a[@href=\"/contactus\"]//ancestor::li")
	private WebElement contactus;
	@FindBy(xpath="//*[contains(text(),\"logout\")]")
	private WebElement logout;
	//additional admin headers
	@FindBy(xpath="//p[text()=\" Actions\"]")
	private WebElement actions;
	Select action=new Select(actions);
	List<WebElement> actionoptions=action.getOptions();
	//additional user headers
	@FindBy(xpath="//a[@routerlink=\"/adminmesag\"]")
	private WebElement adminmessage;
	
	
	  public pageHeader(WebDriver driver)
	    {
	    	this.driver=driver;
	    	PageFactory.initElements(driver,this);
	    }
	
	  public void clickHome()
	  {
		 home.click();
	  }
	  public void clickMyPosts()
	  {
		  myposts.click();
	  }
	  
	  public void clickNewPost()
	  {
		  createpost.click();
	  }
	  public void clickCategories()
	  {
		  categories.click();
	  }
	  public void clickAboutUs()
	  {
		  aboutus.click();
	  }
	  public void clickContactUs()
	  {
		  contactus.click();
	  }
	  public void clickLogout()
	  {
		  logout.click();
	  }
	  
	}
