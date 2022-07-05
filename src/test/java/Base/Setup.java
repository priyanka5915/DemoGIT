package Base;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Config.propertiesfile;

public class Setup 
{
	
	WebDriver driver=null;
	
   public static String Selectbrowser=null;
   
   @BeforeTest
	public static void openBrowser(String Selectbrowser, WebDriver driver ) throws FileNotFoundException

	{
		propertiesfile.getProperties();
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
   
   @Test
   public void run()
   {
	   System.out.println("im inside page");
	   System.out.println("Git comment");
   }

   
	 
}
