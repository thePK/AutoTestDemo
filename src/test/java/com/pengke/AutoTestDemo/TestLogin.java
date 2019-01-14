package com.pengke.AutoTestDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogin {
	WebDriver driver;
  @Test
  public void testCMISLogin() {
	   driver.get("http://p101023.jspdi.com.cn:8080/x5/UI2/v_/portal/pc3/adminLogin.w#!main");
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   WebElement webElement1 = driver.findElement(By.xpath("//*[@placeholder='用户名']"));
	   webElement1.sendKeys("101023");
	   WebElement webElement2 = driver.findElement(By.xpath("//*[@placeholder='密码']"));
	   webElement2.sendKeys("cmiS");
	   driver.findElement(By.xpath("//*[@xid='login']")).click();
  }
  
  @Test
  public void testHHULogin() {
		driver.get("http://gs.hhu.edu.cn/");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//table[@id='quicklink']/tbody/tr/td[3]/a")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String handle = driver.getWindowHandle();
		for(String handles : driver.getWindowHandles()){
			if(handles.equals(handle))
				continue;
				//driver.close();
			driver.switchTo().window(handles);
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		
		driver.findElement(By.xpath("//div[@class='login']//input[@name='username']")).click();
		
		driver.findElement(By.xpath("//div[@class='login']//input[@name='username']")).sendKeys("171607010018");
		
		driver.findElement(By.xpath("//div[@class='login']//input[@name='password']")).click();
		
		driver.findElement(By.xpath("//div[@class='login']//input[@name='password']")).sendKeys("LPwAN9511243461");
		
		driver.findElement(By.id("login")).click();
		
	}
  
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	 
  }
}
