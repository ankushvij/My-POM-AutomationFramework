package com.automationPOM.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationPOM.qa.base.TestBase;
import com.automationPOM.qa.pages.ContactUs;
import com.automationPOM.qa.pages.Home;
import com.automationPOM.qa.pages.LoginPage;
import com.automationPOM.qa.pages.MyAccountPage;
import com.automationPOM.qa.utils.TestUtil;

public class ContactUsTest extends TestBase{

	public LoginPage loginPage;
	public Home homePage;
	public ContactUs contactUs;
	public MyAccountPage myAccountPage;
	public ContactUsTest() {
		super();
		
	}
	
	
	@BeforeMethod
	public void setUp() { //these are methods of ContactUsTest class
	initialization(); 
		//now simply creating object of loginpage class
	loginPage=new LoginPage();
	myAccountPage=loginPage.login(prop.getProperty("email"), prop.getProperty("pass")); //we have to login first so we are now writing all of these 
	// in @BeforeMethod	, also saved in homePage object
	myAccountPage.ContactsClickMyAccount();
	}
	
	
	@Test(priority=1)
	 public void headingClickTest() {
		
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		contactUs.selectFromSubjectHeadingDdl();
	}
	
@Test(priority=2)
public void addEmailTest() {
	
	contactUs.emailAdd();
	
}
@AfterMethod
public void tearDown() {
	driver.quit();
	
}
	
		
		}

