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
public class SearchResultsPage extends Base {
ActionClass action = new ActionClass();

	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li[1]")
	WebElement firstproduct;
	
	public SearchResultsPage() {
		PageFactory.initElements(getDriver(), this);

	}
	
	public boolean isProductAvailable() {		
		return action.isDisplayed(getDriver(), firstproduct);
	}
	
	public AddtoCartPage clickonproduct() {		
		action.click(getDriver(), firstproduct);
		return new AddtoCartPage();
}
}
