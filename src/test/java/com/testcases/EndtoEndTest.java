/**
 * 
 */
package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseclass.Base;
import com.pageobjects.AddressPage;
import com.pageobjects.AddtoCartPage;
import com.pageobjects.IndexPage;
import com.pageobjects.LoginPage;
import com.pageobjects.OrderPage;
import com.pageobjects.OrderSummaryPage;
import com.pageobjects.Orderconfirmation;
import com.pageobjects.PaymentPage;
import com.pageobjects.SearchResultsPage;
import com.pageobjects.ShippingPage;

/**
 * @author nbusireddy
 *
 */
public class EndtoEndTest extends Base{
	IndexPage indexpage;
	SearchResultsPage searchresultspage;
	AddtoCartPage addtocartpage;
	OrderPage orderpage;
	LoginPage loginPage;
	AddressPage addresspage;
	ShippingPage shippingpage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	Orderconfirmation orderConfirmation;
	
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
	
	@Test(groups = {"Regression"})
	public void endToendTest() throws Throwable {
		indexpage = new IndexPage();
		searchresultspage =indexpage.searchBox("dress");
		addtocartpage = searchresultspage.clickonproduct();
		addtocartpage.addquantity(prop.getProperty("qnty"));
		addtocartpage.selectSize(prop.getProperty("size"));
		addtocartpage.clickAddtoCart();
		Thread.sleep(2000);
		orderpage=addtocartpage.clicktoCheckout();
		loginPage = orderpage.clickOnCheckOut();
		addresspage = loginPage.login2(prop.getProperty("username"), prop.getProperty("password"));
		shippingpage = addresspage.proceedTocheckout();
		shippingpage.clickcheckBox();
		paymentPage = shippingpage.proceedtoCheckOut();
		orderSummaryPage = paymentPage.clickonPayment();
		orderConfirmation = orderSummaryPage.clickonConfirm();
		String result = orderConfirmation.confirmationMsg();
		System.out.println(result);
		
		
		
		
	}
	
	

}
