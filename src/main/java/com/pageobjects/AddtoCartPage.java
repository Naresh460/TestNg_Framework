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
public class AddtoCartPage extends Base {
	ActionClass action = new ActionClass();
	
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(id="group_1")
	WebElement sizeoftheproduct;
	
	@FindBy(name="Submit")
	WebElement addtoCartBtn;
	
	@FindBy(xpath="//div[@class=\"layer_cart_product col-xs-12 col-md-6\"]/h2")
	WebElement cartSuccessMessage;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
	WebElement clicktoCheckout;
	
	public AddtoCartPage() {
		PageFactory.initElements(getDriver(), this);

	}
	
	public void addquantity(String qnty) {
		action.type(quantity, qnty);
		
	}
	
	public void selectSize(String size) {
		action.selectByVisibleText(size, sizeoftheproduct);		
	}
	
	public void clickAddtoCart() throws InterruptedException {
		action.click(getDriver(), addtoCartBtn);
		Thread.sleep(3000);
	}
	
	public boolean validateAddtoCart() {
		action.implicitWait(getDriver(), 10);
		return action.isDisplayed(getDriver(), cartSuccessMessage);
		
	}
	
	public OrderPage clicktoCheckout() {		
		action.implicitWait(getDriver(), 10);
		action.click(getDriver(), clicktoCheckout);
		return new OrderPage();
	}
	
}
