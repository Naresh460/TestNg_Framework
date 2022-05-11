/**
 * 
 */
package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseclass.Base;
import com.pageobjects.IndexPage;

/**
 * @author nbusireddy
 *
 */
public class Indexpagetest extends Base{
	IndexPage indexpage;
	
//	@Parameters("browserrname")
//	@BeforeMethod (groups = {"Regression","Sanity","Smoke"})
//	public void browsersetup(String browserrname) {
//		launchApp(browserrname);		
//	}
//	
//	@AfterMethod(groups = {"Regression","Sanity","Smoke"})
//	public void tearDown() {
//		getDriver().quit();		
//	}
	
	@Test (groups = "Smoke")
	public void verifylogo() {
		indexpage = new IndexPage();
		boolean result = indexpage.getlogo();		
		Assert.assertTrue(result);
		
	}
	
	@Test(groups = "Smoke")
	public void verifyTitle() {
		indexpage = new IndexPage();
		String actualresult = indexpage.verifyTitle();	
		String expectedresult = "My Store";
		Assert.assertEquals(actualresult, expectedresult);
		
	}
	

}
