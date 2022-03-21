package com.techblog.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.techblog.TestBase.TestBase;
import com.techblog.pages.CreatePostAdminPage;
import com.techblog.pages.DeletePostPage;
import com.techblog.pages.EditPostPage;
import com.techblog.utilities.ExcelUtility;

public class TestClassCreatePost extends TestBase
{

CreatePostAdminPage objcreate;
EditPostPage objedit;
DeletePostPage objdelete;

@Test(priority=1)
public void create_newpost()throws IOException,InterruptedException
{
	objcreate=new CreatePostAdminPage(driver);
	//create new post function calls
	objcreate.create_post();
	String title = ExcelUtility.getCellData(10, 0);
	String imgurl = ExcelUtility.getCellData(10, 1);
	String post = ExcelUtility.getCellData(10, 2);
	objcreate.Post_contentsAdd(title,imgurl,post);
 	Thread.sleep(5000);
 } 

}
