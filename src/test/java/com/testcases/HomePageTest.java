/**
 * 
 */
package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseclass.Base;
import com.pageobjects.HomePage;
import com.pageobjects.IndexPage;
import com.pageobjects.LoginPage;

/**
 * @author nbusireddy
 *
 */
public class HomePageTest extends Base{
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	
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
	public void verifyOrderHistory() {
		indexpage = new IndexPage();		
		loginpage = indexpage.clickonsign();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		boolean result = homepage.validateOrderHistoryBtn();
		Assert.assertTrue(result);
	}
	
	@Test(groups = {"Smoke"})
	public void verifyWhishList() {    //Actually the driver in homepage as per the above method
		indexpage = new IndexPage();		
		loginpage = indexpage.clickonsign();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		boolean result = homepage.validateWhishlist();
		Assert.assertTrue(result);
	}

}
