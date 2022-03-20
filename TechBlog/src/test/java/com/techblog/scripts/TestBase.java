package com.techblog.scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
	WebDriver driver;
	public static Properties prop = null;
	   String driverPath = "D:\\ICT Academy\\chromedriver.exe";
	
	
	public static void TestBase() {
		try {
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources"
					+ "/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
   @BeforeTest
   public void onSetup() {
	   TestBase();
	
	   String browserName = prop.getProperty("browser");
	   
	   if (browserName.equals("chrome")) {
		   System.setProperty("webdriver.chrome.driver", driverPath);
		   driver = new ChromeDriver();
	   }
		   
	   else if (browserName.equals("firefox")) {
		   System.setProperty("webdriver.gecko.driver", driverPath);
		   driver = new FirefoxDriver();
	   }   
	   
	   
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   driver.get(prop.getProperty("url"));
	   driver.manage().window().maximize();
}

   @AfterMethod
   public void tearDown(ITestResult iTestResult) throws IOException {
	   if (iTestResult.FAILURE == iTestResult.getStatus()) {
		   takeScreenshot(iTestResult.getName());
	   }
   }
   
   public String takeScreenshot(String name) throws IOException {
	   String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	   File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	   String destination = System.getProperty("user.dir") + "\\target\\" + name + dateName + ".png";
	   File finalDestination = new File(destination);
	   FileHandler.copy(source, finalDestination);
	   return destination;
	   
  }
   
  /* @AfterTest
   public void quitBrowser() throws IOException{
	   driver.quit();
   }*/
   
}