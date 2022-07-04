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

import Base.Setup;

public class DataDriven1 extends Setup
{
	public static WebDriver driver;
	public static void login() throws IOException, InterruptedException
	{
		FileInputStream I= new FileInputStream("C:\\Users\\Admin\\Desktop\\Synnefa.xls");
		HSSFWorkbook wb=new HSSFWorkbook(I);
		HSSFSheet s=wb.getSheet("Sheet1");

		for(int i=0;i<=s.getLastRowNum();i++)
		{
			String un=s.getRow(i).getCell(0).toString();

			String pwd=s.getRow(i).getCell(1).toString();


//			System.setProperty("webdriver.edge.driver", "D:\\drivers\\msedgedriver.exe");
//			driver = new EdgeDriver();
//			driver.get("http://35.176.253.183/login");
//			driver.manage().window().maximize();
			driver.findElement(By.name("username")).sendKeys(un);
			driver.findElement(By.name("password")).sendKeys(pwd);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@class='btn btn-block btn-success btn-flat btn-login']")).click();
			String Title=driver.getTitle();

			if(driver.getTitle().contains("Synnefa FarmCloud - Customers"))
			{   

				driver.findElement(By.xpath("//span[contains(text(),'Nimain')]")).click();
				driver.findElement(By.linkText("Logout"));

				s.getRow(i).createCell(3).setCellValue("Testcase pass");
				driver.close();
			}
			else
			{
				s.getRow(i).createCell(3).setCellValue("Testcase Failed");
				driver.close();
				/*
				 * driver.findElement(By.name("username")).clear();
				 * driver.findElement(By.name("password")).clear();
				 */
			}

			wb.write(new FileOutputStream("C:\\Users\\Admin\\Desktop\\Synnefa.xls"));

			driver.quit();
		}
	}




	public static void main(String[] args) throws IOException, InterruptedException 
	{
		Setup obj=new Setup();
		
		
		login();
	}

	
}	
	