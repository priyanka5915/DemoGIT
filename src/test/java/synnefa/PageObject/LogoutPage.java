package synnefa.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage
{

private static WebElement element;
	
    public static WebElement profile_button (WebDriver driver)
	{
		element=driver.findElement(By.xpath("//span[contains(text(),'Nimain')]"));
		return element;
	}
    
    public static WebElement Logout_button(WebDriver driver)
	{
		element=driver.findElement(By.linkText("Logout"));
		return element;
	}

	
    
}
