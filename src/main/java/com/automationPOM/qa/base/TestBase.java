package com.automationPOM.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.automationPOM.qa.utils.TestUtil;
import com.automationPOM.qa.utils.WebEventListener;

public class TestBase {

	//basic initialisation will be done here, like waits, browser properties etc.
	
public static WebDriver driver; //global variables
public static Properties prop;
public static EventFiringWebDriver e_driver; //reference variable to create proper Logs through WebEventListner class we have created
public TestBase() { //creating the constructor of our base class
	//here we need to create objects of Properties and FileInputStream classes
		
		try { 
			prop=new Properties();
			FileInputStream inp = new FileInputStream("C:/Users/Ankush/eclipse-workspace/AutomationTestDemo/src/main/java/com/automationPOM/qa/config/config.properties");
			//this Fileinputstream connects between the java code and config. file
			prop.load(inp);	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

public static void initialization() { 
String browserName=prop.getProperty("browser");
	
	if(browserName.equals("chrome")) {
	System.setProperty("webdriver.chrome.driver","C://Users/Ankush/Desktop/NaveenAutomationLab/Zips/chromedriver_win32/chromedriver.exe");// make this location generic with the generic code -System.getProperty("user.dir") + "\\test-output\\CSVfiles\\"
	// for windows we have to write .exe in the path and not for MAC
driver = new ChromeDriver();  //here we have made the driver as our global static variable ie class /instance/global variable
	} 
	else if(browserName.equals("ff")) {
		System.setProperty("webdriver.gecko.driver", "C://Users/Ankush/Desktop/NaveenAutomationLab/Zips/geckodriver-v0.28.0-win64//geckodriver.exe");
		driver=new FirefoxDriver(); //FirefoxDriver() class is implementing the WebDriver interface-- and here it launches the FF browser
		
	} 
	
	//writing this code within the initialization method for logs generation through WebdriverFireEvent (see WebEventListener class)
	e_driver=new EventFiringWebDriver(driver); //also termed as -->(Webdriver Firing Event)
	WebEventListener eventListener=new WebEventListener(); //we have to create the object the objes=ct of WebeventListner class as we have created the listners in this class.
	e_driver.register(eventListener); //registering with eventListener object of WebeventListner class
	driver=e_driver; //giving control to e_driver;
	
	
driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	//Dynamic Waits:
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS); //TestUtil class is directly calling its 'Static' variables
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);	
	driver.get(prop.getProperty("url"));
}
}

	

