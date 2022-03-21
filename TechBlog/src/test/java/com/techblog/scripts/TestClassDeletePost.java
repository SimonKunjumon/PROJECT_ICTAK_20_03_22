package com.techblog.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.techblog.TestBase.TestBase;
import com.techblog.pages.DeletePostPage;

public class TestClassDeletePost extends TestBase
{
	
DeletePostPage objdelete;
@Test(priority=1)
	public void Delete_adminpost()throws IOException,InterruptedException
	{
		   objdelete=new DeletePostPage(driver);
		   //calls delete post function
		   objdelete.delete_post();
		   Thread.sleep(4000);
	}
	
}
