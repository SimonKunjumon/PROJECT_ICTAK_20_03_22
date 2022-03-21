package com.techblog.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.techblog.TestBase.TestBase;
import com.techblog.pages.AddCategoryPage;
import com.techblog.utilities.ExcelUtility;

public class TestClassAddCategory extends TestBase
{
AddCategoryPage obj1;
@Test(priority=1)	
	public void Add_category() throws IOException, InterruptedException

	{
		 obj1 =new AddCategoryPage(driver);
		 //add new category
		 obj1.Add_category();
		 String category_name=ExcelUtility.getCellData(0, 2);	
		 obj1.Fun_addCategry(category_name);
		 Thread.sleep(4000);
	}
}
