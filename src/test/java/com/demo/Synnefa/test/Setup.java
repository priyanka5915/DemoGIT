package com.demo.Synnefa.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Setup {
	static WebDriver driver;
	public static void run()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://35.176.253.183/login");
		driver.manage().window().maximize();

	}

}
