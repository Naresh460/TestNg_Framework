/**
 * 
 */
package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.ActionClass;
import com.baseclass.Base;

/**
 * @author nbusireddy
 * Here we have to verify the Whishlist and OrderHistory Details visible or not
 */
public class HomePage extends Base {
	ActionClass action = new ActionClass();
	
	@FindBy(xpath="//span[text()='My wishlists']")
			WebElement whishlistBtn;
	
	@FindBy(xpath="//span[text()='Order history and details']")
	WebElement orderHistoryDetailsBtn;
	
	@FindBy(xpath="//div[@id=\"columns\"]/div[1]/span[2]")
	WebElement myAccountHeader;
	
	
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
		
	}
	
	public boolean validateWhishlist() {
		return action.isDisplayed(getDriver(), whishlistBtn);
	}
	
	public boolean validateOrderHistoryBtn() {		
		return action.isDisplayed(getDriver(), orderHistoryDetailsBtn);
	}
	
	public boolean verifyAccount() {
		boolean message = action.isDisplayed(getDriver(), myAccountHeader);
		return message;
		
	}
}
