package Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import Base.Setup;

public class propertiesfile {
	static Properties prop= new Properties();
	static String projectPath= System.getProperty("user.dir");

	public static void main(String[] args) throws FileNotFoundException
	{
		getProperties();
        setProperties();
        getProperties();
	}

	public static void getProperties() throws FileNotFoundException
	{
		try {
			Properties prop=new Properties();
			
			InputStream input=new FileInputStream(projectPath+"\\src\\test\\java\\Config\\config.properties");
			prop.load(input);
			String browser=prop.getProperty("browser");
			System.out.println(browser);
			Setup.Selectbrowser=browser;
		}

		catch(Exception exp)
		{
			System.out.println(exp.getMessage());
			exp.getCause();
			exp.printStackTrace();
		}
	}
	
	public static void setProperties() throws FileNotFoundException
	{
		try {
		OutputStream output= new FileOutputStream(projectPath+"\\src\\test\\java\\Config\\config.properties");
		prop.setProperty("browser", "chrome");
		prop.store(output, null);
		
		}
		catch(Exception exp)
		{
			System.out.println(exp.getMessage());
			exp.getCause();
			exp.printStackTrace();
		}
	}
}