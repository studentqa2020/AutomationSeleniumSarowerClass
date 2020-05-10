package com.testing.pf;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'User: Naveen K')]")
	WebElement userNameLabel;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	
	
	
	

}
