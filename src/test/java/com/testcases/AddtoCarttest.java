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
import com.pageobjects.AddtoCartPage;
import com.pageobjects.IndexPage;
import com.pageobjects.SearchResultsPage;

/**
 * @author nbusireddy
 *
 */
public class AddtoCarttest extends Base{
	IndexPage indexpage;
	SearchResultsPage searchresultspage;
	AddtoCartPage addtocartpage;
	
//	@Parameters("browserrname")
//	@BeforeMethod (groups = {"Regression","Sanity","Smoke"})
//	public void browsersetup(String browserrname) {
//		launchApp(browserrname);		
//	}
//	
//	@AfterMethod(groups = {"Regression","Sanity","Smoke"})
//	public void teardown() {
//		getDriver().quit();
//	}
	
	@Test (groups = {"Regression","Sanity"})
	public void verifyAddTocart() throws InterruptedException {
		indexpage = new IndexPage();
		searchresultspage =indexpage.searchBox("dress");
		boolean results = searchresultspage.isProductAvailable();
		Assert.assertTrue(results, "Product is available");
		addtocartpage = searchresultspage.clickonproduct();
		addtocartpage.addquantity(prop.getProperty("qnty"));
		addtocartpage.selectSize(prop.getProperty("size"));
		addtocartpage.clickAddtoCart();
		boolean message = addtocartpage.validateAddtoCart();
		Assert.assertTrue(message, "Product successfully added to your shopping cart");
	}
	
}
