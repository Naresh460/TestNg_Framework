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
 * Here we will validate the unit price and total price and click on Proceedto checkout btn;
 *
 */
public class OrderPage extends Base {
	ActionClass action = new ActionClass();
	
	@FindBy(xpath="//td[@class=\"cart_unit\"]/span/span")
	WebElement unitprice;
	
	@FindBy(id="total_price")
	WebElement totalPrice;
	
	@FindBy(xpath="//p[@class=\"cart_navigation clearfix\"]/a[1]/span")
	WebElement proccedToCheckOut;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);

	}
	
	public double getUnitPrice() {
		String unitPrice1=unitprice.getText();
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice() {
		String totalPrice1=totalPrice.getText();
		String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalTotalPrice=Double.parseDouble(tot);
		return finalTotalPrice/100;
	}
	
	public LoginPage clickOnCheckOut() throws Throwable {
		action.click(getDriver(), proccedToCheckOut);
		return new LoginPage();
	}

}
