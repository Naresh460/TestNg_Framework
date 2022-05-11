package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.ActionClass;
import com.baseclass.Base;

public class LoginPage extends Base {
	ActionClass action = new ActionClass();
	
	@FindBy(id="email") 
	WebElement username;
	
	@FindBy(id="passwd") 
	WebElement password;

	@FindBy(id="SubmitLogin") 
	WebElement submitBtn;
	
	@FindBy(id="email_create") 
	WebElement emailforNewaccount;
	
	@FindBy(id="SubmitCreate") 
	WebElement createAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
		
	}
	
	public HomePage login(String uname, String pword)  {
		action.type(username, uname);
		action.type(password, pword);
		action.click(getDriver(), submitBtn);
		return new HomePage();
		
	}
	
	public AddressPage login2(String uname, String pword) {
		action.type(username, uname);
		action.type(password, pword);
		action.click(getDriver(), submitBtn);
		return new AddressPage();
		
	}
	public AccountCreationPage createNewAccount(String emailaddress) {
		
		action.type(emailforNewaccount, emailaddress);
		action.click(getDriver(), createAccountBtn);
		return new AccountCreationPage();
	}
	
	

}
