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
public class ShippingPage extends Base{
	ActionClass action = new ActionClass();
	
	@FindBy(name="cgv")
	WebElement checkBox;
	
	@FindBy(name="processCarrier")
	WebElement proceedtoCheckout;
	
	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);

	}
	
	public void clickcheckBox() {
		action.click(getDriver(), checkBox);
	}
	
	public PaymentPage proceedtoCheckOut() {
		action.click(getDriver(), proceedtoCheckout);
		return new PaymentPage();
	}
}
