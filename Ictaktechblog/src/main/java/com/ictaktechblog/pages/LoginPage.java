package com.ictaktechblog.pages;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
    WebDriver driver;
    @FindBy(xpath="//img[@src=\"../../assets/images/user.png\"]")
    private WebElement dropdown;
    
    @FindBy(xpath="//a[@href=\"/login\"]")
    private WebElement login;
    @FindBy(id="user")
    private WebElement email;
    @FindBy(id="pwd")
    private WebElement password;
    @FindBy(id="logbut")
    private WebElement loginbutton;
    @FindBy(xpath="//a[@href=\"#\" and @id=\"nav\"]")
    private WebElement logout;
   
    
    public LoginPage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
    }
    public void ChooseLogin() throws InterruptedException
    {   Thread.sleep(2000);
    	dropdown.click();
    	login.click();
;
    	
    }
   
    
    public void loginAs(String user, String pass)
    {
        

       email.sendKeys(user);
       password.sendKeys(pass);
       loginbutton.click();
    }
    
    public void Logout()
    {
    	logout.sendKeys(Keys.RETURN);
    } 
   
 }

