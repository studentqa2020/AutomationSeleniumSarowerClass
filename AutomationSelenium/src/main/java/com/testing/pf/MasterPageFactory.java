package com.testing.pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MasterPageFactory {

	// Initializing the Page Objects:
	public MasterPageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "// *[@class='login']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//*[@id='email']")
	private WebElement username;

	@FindBy(xpath = "//*[@id='passwd']")
	private WebElement password;

	@FindBy(xpath = "//*[@id='SubmitLogin']")
	private WebElement submitBtn;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

}
