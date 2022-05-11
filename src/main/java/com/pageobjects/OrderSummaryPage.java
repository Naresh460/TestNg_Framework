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
public class OrderSummaryPage  extends Base{
	ActionClass action = new ActionClass();
	
	@FindBy(xpath="//p[@id=\"cart_navigation\"]/button")
	WebElement clickonConfirm;
	
	public OrderSummaryPage() {
		PageFactory.initElements(getDriver(), this);

	}
	
	public Orderconfirmation clickonConfirm() {
		action.click(getDriver(), clickonConfirm);
		return new Orderconfirmation();
		
	}

}
