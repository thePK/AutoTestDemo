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
  public void testLogin() {
	   driver.get("http://p101023.jspdi.com.cn:8080/x5/UI2/v_/portal/pc3/adminLogin.w#!main");
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   WebElement webElement1 = driver.findElement(By.xpath("//*[@placeholder='用户名']"));
	   webElement1.sendKeys("101023");
	   WebElement webElement2 = driver.findElement(By.xpath("//*[@placeholder='密码']"));
	   webElement2.sendKeys("cmiS");
	   driver.findElement(By.xpath("//*[@xid='login']")).click();
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	 
  }
}
