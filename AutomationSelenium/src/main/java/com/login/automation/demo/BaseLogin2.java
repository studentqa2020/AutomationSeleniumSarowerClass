package com.login.automation.demo;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testing.pf.MasterPageFactory;
import com.util.Highlighter;
import com.util.Wait;

public class BaseLogin2 {

	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		WebDriver driver = new ChromeDriver();//upcasting
		
		driver.manage().window().maximize();//maximum or full size
		driver.manage().deleteAllCookies();
		driver.get("http://automationpractice.com/index.php");
		MasterPageFactory pf =new MasterPageFactory(driver);
		
		System.out.println(driver.getTitle());
		new Highlighter().getcolor(driver, pf.getLoginBtn());
		pf.getLoginBtn().click();// click
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		Wait.getExplicitWaitClicable(driver,pf.getUsername());
		new Highlighter().getcolor(driver, pf.getUsername(), "yellow");
		pf.getUsername().sendKeys("sarowerny@gmail.com");
		new Highlighter().getcolor(driver, pf.getPassword(),"black");
		pf.getPassword().sendKeys("student");
		Thread.sleep(3000);
		pf.getSubmitBtn().click();

		System.out.println(driver.getTitle());
		driver.quit();//=================all browser tab + Chrome driver
		
	}

}
