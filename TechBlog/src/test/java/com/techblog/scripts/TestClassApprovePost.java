package com.techblog.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.techblog.TestBase.TestBase;
import com.techblog.pages.HomePage;
import com.techblog.pages.PendingApprovalPage;
import com.techblog.pages.PendingPostRejectPage;
import com.techblog.utilities.ExcelUtility;

public class TestClassApprovePost extends TestBase
{
	PendingApprovalPage objapprove;
	PendingPostRejectPage objreject;
	HomePage objhome;
	
@Test(priority=1)
	public void Approve_postAdmin() throws IOException,InterruptedException

	{
	objapprove =new PendingApprovalPage(driver);
	//admin approve the pending post
	objapprove.Approve_post();
	Thread.sleep(3000);
	String comment=ExcelUtility.getCellData(0, 3);
	//admin send message to user
	objapprove.approve(comment);
	Thread.sleep(4000);
	}

}
