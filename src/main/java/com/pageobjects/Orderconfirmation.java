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
public class Orderconfirmation extends Base{
	ActionClass action = new ActionClass();
	
	@FindBy(xpath="//p[@class=\"cheque-indent\"]/strong")
	WebElement confirmationMsg;
	
	public Orderconfirmation() {
		PageFactory.initElements(getDriver(), this);

	}
	
	public String confirmationMsg() {
		String msg =confirmationMsg.getText();
		return msg;
		
	}

}
