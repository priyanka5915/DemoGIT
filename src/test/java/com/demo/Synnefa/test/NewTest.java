package com.demo.Synnefa.test;

import org.testng.annotations.Test;

import Base.Setup;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class NewTest  
{
	WebDriver driver;
	@Test(dataProvider = "dp")
	public void f(String UN, String PWD) throws InterruptedException 
	{    
		
		
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/form/div[1]/input")).sendKeys(UN);
		driver.findElement(By.name("password")).sendKeys(PWD);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='btn btn-block btn-success btn-flat btn-login']")).click();
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/form/div[1]/input")).clear();
		driver.findElement(By.name("password")).clear();
		
		Assert.assertEquals(driver.getTitle(), "Synnefa FarmCloud - Customers");
		
		
	    
	}
	

	@DataProvider
	public Object[][] dp() {
		return new Object[][] {
			//new Object[] {"nimain2412@gmail.com","helloworld"},
			
			new Object[] { "nimain@live.com", "helloworld1" },
			new Object[] { "abc@gmail.com", "1234@qwer" },
			new Object[] {"abc@gmail.com","helloworld1"},
			new Object[] {" "," "},
			new Object[] {" ","helloworld1"},
			new Object[] {"nimain@live.com",""},
			new Object[] {"nimain@live.com","123456"},
			
			
			
		};
	}
	
//	@Test
//	public void Title()
//	{
//		driver.findElement(By.name("username")).sendKeys("nimain@gmail125879.com");
//		driver.findElement(By.name("password")).sendKeys("helloworld");
//		driver.findElement(By.xpath("//*[@class='btn btn-block btn-success btn-flat btn-login']")).click();
//		String Expected_title=driver.getTitle();
//		System.out.println(Expected_title);
//		
//	}
	@BeforeTest
	public void openBrowser()

	{
		String Selectbrowser= "chrome";

		switch (Selectbrowser)
		{
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "D:\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get("http://35.176.253.183/login");
			driver.manage().window().maximize();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://35.176.253.183/login");
			driver.manage().window().maximize();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "D:\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.get("http://35.176.253.183/login");
			driver.manage().window().maximize();
			break;
		default:
			System.out.println("browser : " + Selectbrowser + " is invalid, Launching Firefox as browser of choice..");
			System.setProperty("webdriver.gecko.driver", "D:\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get("http://35.176.253.183/login");
			driver.manage().window().maximize();
			break;


		}

	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}



}
