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

import synnefa.PageObject.LoginPage;
import com.demo.Synnefa.test.Setup;
import synnefa.PageObject.LogoutPage;

public class LoginPageTest
{
	private static WebDriver driver=null;

	public static void LoginTest_datadriven() throws IOException
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
			Setup.run();
			
			LoginPage.text_Email(driver).sendKeys(un);
			LoginPage.text_PWD(driver).sendKeys(pwd);
			LoginPage.Login_Button(driver).click();
			
			
			String Title=driver.getTitle();

			if(driver.getTitle().contains("Synnefa FarmCloud - Customers"))
			{   

				LogoutPage.profile_button(driver).click();
				LogoutPage.Logout_button(driver).click();

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


	
	
	
	
	public static void main(String[] args) throws IOException
	{
		LoginTest_datadriven();

	}

}
