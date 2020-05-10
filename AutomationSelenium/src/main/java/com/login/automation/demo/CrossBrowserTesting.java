package com.login.automation.demo;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.util.Highlighter;
import com.util.Wait;

public class CrossBrowserTesting {
	static WebDriver driver;
	public static void main(String[] args) throws Throwable {

		//String [] browser = {"Chorme","FireFox","Edge","IE"};
		String [] browser = {"Edge"};
		
		for(String getBrowser:browser) {
			if(getBrowser.equals("Chorme")) {
				System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
				 driver = new ChromeDriver();//upcasting
			}else if(getBrowser.equals("FireFox")) {
				
				System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
				 driver = new FirefoxDriver();
			}else if(getBrowser.equals("Edge")) {
				    System.setProperty("webdriver.edge.driver", "./Driver/MicrosoftWebDriver.exe");
				   DesiredCapabilities capabilities = DesiredCapabilities.edge();
				    EdgeOptions options = new EdgeOptions();
				    options.merge(capabilities);    
				     driver = new EdgeDriver();
			}
			else if(getBrowser.equals("IE")) {	
				System.setProperty("webdriver.ie.driver","./Driver/IEDriverServer.exe");
				driver = new InternetExplorerDriver();	
			}else {	
				System.out.println("Its not my Browser");
			}
			//now browser selected and put URL
			driver.manage().window().maximize();//maximum or full size
			driver.manage().deleteAllCookies();
			driver.get("http://automationpractice.com/index.php");
			System.out.println(driver.getTitle());
			WebElement signBtn = driver.findElement(By.xpath("// *[@class='login']"));
			new Highlighter().getcolor(driver, signBtn);
			signBtn.click();// click
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
			Wait.getExplicitWaitForNumber(driver, By.xpath("//*[@id='email']"));
			WebElement email = driver.findElement(By.xpath("//*[@id='email']"));	
			new Highlighter().getcolor(driver, email, "yellow");
			email.sendKeys("sarowerny@gmail.com");
			WebElement password = driver.findElement(By.xpath("//*[@id='passwd']"));
			new Highlighter().getcolor(driver, password,"black");
			password.sendKeys("student");
			Thread.sleep(3000);
			WebElement loginBtn = driver.findElement(By.xpath("//*[@id='SubmitLogin']"));
			loginBtn.click();
			System.out.println(driver.getTitle());
			driver.quit();//= all browser tab + Chrome driver
			Thread.sleep(3000);
		}
	}

}
