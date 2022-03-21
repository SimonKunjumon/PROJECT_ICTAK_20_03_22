package com.techblog.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.techblog.TestBase.TestBase;
import com.techblog.pages.EditPostPage;
import com.techblog.utilities.ExcelUtility;

public class TestClassEditPost extends TestBase
{
EditPostPage obj2;
@Test(priority=1)
	public void EditPost()throws IOException,InterruptedException
	{
		 obj2 = new EditPostPage(driver);
		 obj2.allpost();
		 Thread.sleep(3000);
		 obj2.buttonclick();
		  //fetching data to update the post
		    String title = ExcelUtility.getCellData(3, 0);
		    String author = ExcelUtility.getCellData(3, 1);
		    String imgurl = ExcelUtility.getCellData(3, 2);
		    String post = ExcelUtility.getCellData(3, 3);
		    //field contents updated
		    obj2.editpost(title,author,imgurl,post);
		    obj2.editpost_submit();
		    Thread.sleep(3000);
	}
}
