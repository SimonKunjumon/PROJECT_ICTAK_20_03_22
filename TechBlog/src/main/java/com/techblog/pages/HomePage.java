package com.techblog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
WebDriver driver;
	
@FindBy(xpath="//a[contains(text(),'Home')]")
private WebElement homeLink;

@FindBy(xpath="//a[contains(text(),'All posts')]")
private WebElement allpostLink;

@FindBy(xpath="//a[contains(text(),'My posts')]")
private WebElement mypostLink;

@FindBy(xpath="//*[@class=\"dropdown-toggle\"][@id=\"nav\"]")
private WebElement myactions;
@FindBy(xpath="//a[@id=\"drop\"][@href=\"/approval\"]")
private WebElement pendingapproval;
@FindBy(xpath="//a[@id=\"drop\"][@href=\"/category\"]")
private WebElement add_removeCategory;
@FindBy(xpath="//a[@id=\"drop\"][@href=\"/newpost\"]")
private WebElement newpost;

@FindBy(xpath="//*[@id='navbarSupportedContent']/ul/li[8]")
private WebElement Categories;
@FindBy(xpath="//a[@href='/categorywise']")
private WebElement category;

@FindBy(xpath="//a[@href=\"/aboutus\"]")
private WebElement aboutus;
@FindBy(xpath="//a[@href=\"/contactus\"]")
private WebElement contactus;

@FindBy(xpath="//a[contains(text(),'logout')]")
private WebElement logout;

public HomePage(WebDriver driver)
{
    this.driver=driver;
    PageFactory.initElements(driver, this);
}



public void clickHomeLink() {
	homeLink.click();
}

public void allpost() {
	allpostLink.click();
}

public void mypost() {
	mypostLink.click();
}

public void myaction() {
	myactions.click();
}


public void add_remcategory() {
	add_removeCategory.click();
	
}

public void createpost()
{
newpost.click();


}

public void categorypost() throws InterruptedException
{
	Categories.click();
	Thread.sleep(3000);
	category.click();
}

public void aboutusLink()
{
	aboutus.click();
}

public void contactusLink()
{
	contactus.click();
}

public void logoutlink()
{
	logout.click();
}

}
