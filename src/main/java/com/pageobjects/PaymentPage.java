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
public class PaymentPage extends Base{
	ActionClass action = new ActionClass();
	
	@FindBy(xpath="//a[@class=\"bankwire\"]")
	WebElement selectPayment;
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);

	}
	
	public OrderSummaryPage clickonPayment() {
		action.click(getDriver(), selectPayment);
		return new OrderSummaryPage();
		
	}
	
	
	}
