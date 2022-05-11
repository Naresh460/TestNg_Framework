/**
 * 
 */
package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseclass.Base;
import com.pageobjects.IndexPage;
import com.pageobjects.SearchResultsPage;

/**
 * @author nbusireddy
 *
 */
public class SearchResultsTest extends Base {	
	IndexPage indexpage;
	SearchResultsPage searchresultspage;
	
//	@Parameters("browserrname")
//	@BeforeMethod (groups = {"Regression","Sanity","Smoke"})
//	public void browsersetup(String browserrname) {
//		launchApp(browserrname);		
//	}
//	
//	@AfterMethod (groups = {"Regression","Sanity","Smoke"})
//	public void teardown() {
//		getDriver().quit();
//	}
	
	@Test(groups = {"Smoke"})
	public void verifySearchProduct() {
		indexpage = new IndexPage();
		searchresultspage =indexpage.searchBox("dress");
		boolean result =searchresultspage.isProductAvailable();
		Assert.assertTrue(result);
			
	}
	

}
