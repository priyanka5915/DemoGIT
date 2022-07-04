package synnefa.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{  
	private static WebElement element;
	
    public static WebElement text_Email(WebDriver driver)
	{
		element=driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/form/div[1]/input"));
		return element;
	}
    
    public static WebElement text_PWD(WebDriver driver)
	{
		element=driver.findElement(By.name("password"));
		return element;
	}
    
    public static WebElement Login_Button(WebDriver driver)
   	{
   		element=driver.findElement(By.xpath("//*[@class=\"btn btn-block btn-success btn-flat btn-login\"]"));
   		return element;
   	}
    
}
