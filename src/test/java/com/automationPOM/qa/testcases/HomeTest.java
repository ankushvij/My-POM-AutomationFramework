package com.automationPOM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationPOM.qa.base.TestBase;
import com.automationPOM.qa.pages.Home;
import com.automationPOM.qa.pages.LoginPage;
import com.automationPOM.qa.pages.MyAccountPage;


public class HomeTest extends TestBase {
	
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	Home homePage; //created object of Home page here
	public HomeTest() { //Super() class constructor is initiated always from Test classes
		super();
	}
	
	
	@BeforeMethod
	public void setUp() { //these are methods of HomeTest class
	initialization(); 
		//now simply creating object of loginpage class
	loginPage=new LoginPage();
	myAccountPage=loginPage.login(prop.getProperty("email"), prop.getProperty("pass")); //we have to login first so we are now writing all of these 
	// in @BeforeMethod	, also saved in homePage object
	}
	
	
	//1.within the class, always remmember that @Test cases should be independent to each other, ie there should be no dependency between them
	//2. @before each @Test case always launch the browser, login and after that close it(see @BeforeMethod and @AfterMethod for an insight)
	//
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String title=homePage.verifyHomeTitle();
		Assert.assertEquals(title, "My Store","Home Page Not Matched"); //3rd param will show when the test case fails
		
	}
		@Test(priority=2)
		public void verifyUserNameTest() {
			
			Assert.assertTrue(homePage.userLabelCorrect());
		}
	
	@Test
	public void womenTabNavigate() {
		homePage.womenTabClick();
		
		}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
