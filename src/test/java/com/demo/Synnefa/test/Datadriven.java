package com.demo.Synnefa.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Datadriven  {
  WebDriver driver;
  @Test
  public void f() throws IOException, InterruptedException 
  {
	    FileInputStream I= new FileInputStream("C:\\Users\\Admin\\Desktop\\Synnefa.xls");
		HSSFWorkbook wb=new HSSFWorkbook(I);
		HSSFSheet s=wb.getSheet("Sheet1");
		
		for(int i=0;i<=s.getLastRowNum();i++)
		{
			String un=s.getRow(i).getCell(0).toString();
			System.out.println(un); 
			
			String pwd=s.getRow(i).getCell(1).toString();
			System.out.println(pwd);
			
			driver.findElement(By.name("username")).sendKeys(un);
			driver.findElement(By.name("password")).sendKeys(pwd);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@class='btn btn-block btn-success btn-flat btn-login']")).click();
			String Title=driver.getTitle();
			
			if(driver.getCurrentUrl().contains(driver.getCurrentUrl()))
			{   
				
		    	driver.findElement(By.xpath("//span[contains(text(),'Nimain')]")).click();
		    	driver.findElement(By.linkText("Logout"));
				
				s.getRow(i).createCell(2).setCellValue("Testcase pass");
			}
			else
			{
				s.getRow(i).createCell(2).setCellValue("Testcase Failed");
				Thread.sleep(2000);
				driver.navigate().refresh();
			}
			
			wb.write(new FileOutputStream("C:\\Users\\HP\\Desktop\\SEL_1.xls"));
			
			
		}
		}
  
  @BeforeClass
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
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}


  }

