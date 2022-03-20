package com.techblog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    WebDriver driver;
    @FindBy(xpath="//img[@src='../../assets/images/user.png']")
    private WebElement dropdown;
    @FindBy(xpath="//a[@href=\"/login\"]")
    private WebElement login;
    @FindBy(id="user")
    private WebElement username;
    @FindBy(id="pwd")
    private WebElement password;
    @FindBy(id="logbut")
    private WebElement loginbutton;
    
    public LoginPage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
    }
    
    public void ChooseLogin(){
    	dropdown.click();
    	login.click();
    	}
    
    public void setUserName(String strUserName){
    	username.sendKeys(strUserName);
    	}
    
    
    public void setPassword(String strPassword) {
    	password.sendKeys(strPassword);
    	}
    
    public void clickLogin(){
    	loginbutton.click();
    }
 }

