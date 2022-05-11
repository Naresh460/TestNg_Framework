/**
 * 
 */
package com.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseclass.Base;
import com.dataProvider.DataProviders;
import com.pageobjects.AccountCreationPage;
import com.pageobjects.HomePage;
import com.pageobjects.IndexPage;
import com.pageobjects.LoginPage;

/**
 * @author nbusireddy
 *
 */
public class AccountCreationTest extends Base{

	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	AccountCreationPage accountcreationpage;


//
//	@Test (dataProvider = "email" , dataProviderClass = DataProviders.class)
//	public void navigatetoCreateAccount(String email) {
//		indexpage = new IndexPage();		
//		loginpage = indexpage.clickonsign();
//		accountcreationpage = loginpage.createNewAccount(email);
//		boolean result = accountcreationpage.createAccountHeader();
//		Assert.assertTrue(result);
//
//
//	}
	
	
	@Test(dataProvider = "newAcountDetailsData", dataProviderClass = DataProviders.class)
	public void createAccount(HashMap<String, String> hashMapValue) throws Throwable {
		indexpage = new IndexPage();		
		loginpage = indexpage.clickonsign();
		accountcreationpage = loginpage.createNewAccount(hashMapValue.get("Email"));
		Thread.sleep(3000);
		accountcreationpage.createAccount(hashMapValue.get("Gender"),
				hashMapValue.get("FirstName"),
				hashMapValue.get("LastName"),
				hashMapValue.get("SetPassword"),
				hashMapValue.get("Day"),
				hashMapValue.get("Month"),
				hashMapValue.get("Year"),
				hashMapValue.get("Company"),
				hashMapValue.get("Address"),
				hashMapValue.get("City"),
				hashMapValue.get("State"),
				hashMapValue.get("Zipcode"),
				hashMapValue.get("Country"),
				hashMapValue.get("MobilePhone"));
		homepage= accountcreationpage.validateRegistration();			

	}
}
