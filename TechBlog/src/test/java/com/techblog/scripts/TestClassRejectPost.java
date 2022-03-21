package com.techblog.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.techblog.TestBase.TestBase;
import com.techblog.pages.HomePage;
import com.techblog.pages.PendingPostRejectPage;
import com.techblog.utilities.ExcelUtility;

public class TestClassRejectPost extends TestBase
{
PendingPostRejectPage objreject;
HomePage objHome;

@Test(priority=1)
	public void Rejectpost()throws IOException,InterruptedException
	{
	objreject=new PendingPostRejectPage(driver);
	//admin Reject the post
	objreject.Reject_Post();
	String comment=ExcelUtility.getCellData(13, 0);
	//admin send comments to the user
	objreject.Send_Comments(comment);
	Thread.sleep(3000);
	
	}
@Test(priority=2)
	public void Logoutadmin()throws IOException,InterruptedException
	{
	objHome = new HomePage(driver);
	//admin logout the session
	objHome.logoutlink();
	
	}
}
