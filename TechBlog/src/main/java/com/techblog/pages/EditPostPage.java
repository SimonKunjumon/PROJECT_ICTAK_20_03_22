package com.techblog.pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPostPage{
	
	WebDriver driver;
	
	
	@FindBy(xpath="//*[@id=\"nav\"][@href=\"/mypost\"]")
	private WebElement my_post;
	
	
	@FindBy(xpath="/html/body/app-root/app-mypost/div[2]/li[2]/div/div/div/button[1]")
	private WebElement edit_button;
	
	
	@FindBy(xpath="//*[@id=\"exampleInputEmail1\"][@name=\"P_title\"]")
	private WebElement title_edit;
	
	@FindBy(xpath="//*[@id=\'exampleInputPassword1\']")
	private WebElement authorname_edit;
	
	@FindBy(xpath="//*[@name=\'P_image\'][@id=\'exampleInputPassword1\']")
	private WebElement imageurl_edit;
	 
	@FindBy(xpath="//*[@name=\'p_post\']")
	private WebElement postcontent_edit;
	
	@FindBy(xpath="//button[contains(.,'Submit')]")
	private WebElement Edit_submit;
	
	public EditPostPage(WebDriver driver)
    {
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
	
	

	public void allpost()
	{
	my_post.click();
	
	}
	public void buttonclick() throws InterruptedException
	{
		edit_button.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}
	
	public void editpost(String title,String author,String imgurl,String content) throws InterruptedException
	{
		//passing the new values to the fields to be updated
		title_edit.clear();
		title_edit.sendKeys(title);
		Thread.sleep(4000);
		authorname_edit.clear();
		authorname_edit.sendKeys(author);
		Thread.sleep(4000);
		imageurl_edit.clear();
		imageurl_edit.sendKeys(imgurl);
		Thread.sleep(4000);
		postcontent_edit.clear();
		postcontent_edit.sendKeys(content);
		Thread.sleep(4000);
	}
	
	public void editpost_submit() throws InterruptedException 
	{
		Edit_submit.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		
	}

}
