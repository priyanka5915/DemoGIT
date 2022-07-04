package com.demo.Synnefa.test;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import synnefa.PageObject.LoginPage;
import synnefa.PageObject.LogoutPage;
import Base.Setup;


public class LogoutTest 
{
	private static WebDriver driver=null;
	public static void logoutTest() throws InterruptedException, FileNotFoundException
    {
//		System.setProperty("webdriver.edge.driver", "D:\\drivers\\msedgedriver.exe");
//		driver = new EdgeDriver();
//		driver.get("http://35.176.253.183/login");
//		driver.manage().window().maximize();
		
		
		LoginPage.text_Email(driver).sendKeys("nimain2412@gmail.com");
		LoginPage.text_PWD(driver).sendKeys("helloworld");
		Thread.sleep(2000);
		LoginPage.Login_Button(driver).click();
		LogoutPage.profile_button(driver).click();
		LogoutPage.Logout_button(driver).click();
		
    }
	
	
	
	public static void main(String[] args) throws InterruptedException, FileNotFoundException 
	{
		logoutTest();
		driver.close();

	}

}
