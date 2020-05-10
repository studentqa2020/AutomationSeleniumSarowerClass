package com.login.automation.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBookLogin {
	
	public static void login() {
	
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();//upcasting polymorphism
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");//get() method

		//email input box
		 	
			//driver.findElement(By.xpath("//*[@type='email']")).sendKeys("sarower@gmail.com");
		
			WebElement email=driver.findElement(By.xpath("//*[@type='email']"));
			email.sendKeys("sarower@gmail.com");
			
			WebElement password=driver.findElement(By.xpath("//*[@type='password']"));
			password.sendKeys("1232343243");
			
			WebElement signinbtn=driver.findElement(By.xpath("//*[@value='Log In']"));
			signinbtn.click();
			
			//close browser
			
			driver.quit();
			
			
			
		}	
		
		
	}

