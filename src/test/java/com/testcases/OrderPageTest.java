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
import com.pageobjects.OrderPage;
import com.pageobjects.SearchResultsPage;

public class OrderPageTest extends Base{
	
	IndexPage indexpage;
	SearchResultsPage searchresultspage;
	AddtoCartPage addtocartpage;
	OrderPage orderpage;
	
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
	
	@Test(groups = {"Regression"})
	public void verifyOrderPage() throws InterruptedException {
		indexpage = new IndexPage();
		searchresultspage =indexpage.searchBox("dress");
		addtocartpage = searchresultspage.clickonproduct();
		addtocartpage.addquantity(prop.getProperty("qnty"));
		addtocartpage.selectSize(prop.getProperty("size"));
		addtocartpage.clickAddtoCart();
		Thread.sleep(2000);
		orderpage=addtocartpage.clicktoCheckout();
		Double unitPrice = orderpage.getUnitPrice();
		Double totalprice_expected = orderpage.getTotalPrice();
		
		Double totalprice_actual=(unitPrice*(Double.parseDouble(prop.getProperty("qnty"))))+2;
		Assert.assertEquals(totalprice_actual, totalprice_expected);
		
	}

}
