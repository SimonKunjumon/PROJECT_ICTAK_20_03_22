package com.techblog.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.techblog.TestBase.TestBase;
import com.techblog.pages.RemoveCategoryPage;

public class TestClassRemoveCategory extends TestBase
{

RemoveCategoryPage objremove;
@Test(priority=1)
public void Remove_CategoryAdmin() throws IOException, InterruptedException

{
	objremove =new RemoveCategoryPage(driver);
	//Remove the category
	objremove.Remove_category();
	Thread.sleep(4000);
}

}
