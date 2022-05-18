 /**
 * 
 */
package com.testcases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseclass.Base;
import com.dataProvider.DataProviders;
import com.pageobjects.HomePage;
import com.pageobjects.IndexPage;
import com.pageobjects.LoginPage;
import com.utility.Log;

/**
 * @author nbusireddy
 *
 */
public class LoginPageTest extends Base{
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
	
	@Test (dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = {"Smoke","Sanity"})
	public void login(String usname, String poswd) {
	Log.startTestCase("login");
	indexpage = new IndexPage();
	Log.info("navigated to index page");
	loginpage = indexpage.clickonsign();
	Log.info("clicked on signin btn");
	homepage=loginpage.login(usname,poswd);
	Log.info("entered username and password and clicked on signin btn");
	boolean result = homepage.verifyAccount();
	Assert.assertTrue(result);	
	Log.info("login is success");
	}

}
