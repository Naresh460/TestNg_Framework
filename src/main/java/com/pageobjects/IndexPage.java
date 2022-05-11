package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.actiondriver.ActionClass;
import com.baseclass.Base;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IndexPage extends Base {
	ActionClass action = new ActionClass();

	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement logo;

	@FindBy(id="search_query_top")
	WebElement SearchBox;

	@FindBy(name="submit_search")
	WebElement searchBtn;

	@FindBy(xpath="//a[@class=\"login\"]")
	WebElement signinBtn;

	public IndexPage(){
		PageFactory.initElements(getDriver(), this);	
	}	

	public boolean getlogo() {
		return action.isDisplayed(getDriver(), logo);
	}


	public LoginPage clickonsign() {
		action.click(getDriver(), signinBtn);
		return new LoginPage();
	}  

	public SearchResultsPage searchBox(String productname) {
		action.type(SearchBox, productname);
		action.click(getDriver(), searchBtn);
		return new SearchResultsPage();		
	}

	public String verifyTitle() {		
		String title = getDriver().getTitle();
		return title;
	}


}




