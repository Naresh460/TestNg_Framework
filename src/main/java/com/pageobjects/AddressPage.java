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
 *
 */
public class AddressPage extends Base {
	ActionClass action = new ActionClass();
	@FindBy(name="processAddress")
	WebElement proceedToCheck;
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);

	}
	
	public ShippingPage proceedTocheckout() {
		
		action.JSClick(getDriver(), proceedToCheck);
		return new ShippingPage();
	}

}
