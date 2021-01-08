package com.automationPOM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationPOM.qa.base.TestBase;
import com.automationPOM.qa.pages.Home;
import com.automationPOM.qa.pages.LoginPage;
import com.automationPOM.qa.pages.MyAccountPage;

public class LoginPageTest extends TestBase { //also we will be calling LoginPage class's methods here
public LoginPage loginPage;//LoginPage's class variable to be able to be used globally throughout the program
public Home homePage; //home page reference variable
public MyAccountPage myAccountPage;
//The super() constructor concept should always be done in the Testclasses
public LoginPageTest() { //created login page constructor and and in it we are calling super keyword to call the super class's constructor and in that super class constructor we have written the properties 
		//its cumpulsory to call testbaseclass contructor as there we have written our 'pagefactory.initelements' to initialise the webelements, which 
		//is curently our super class here, thus null pointer exeption is not faced
		super(); 
	}


	@BeforeMethod
	public void setUp() { //these methods of LoginPageTest class
	initialization(); 
		//now simply creating object of loginpage class, like in below line always remm to initialise the class objects here in the @BeforeMethod as well->very important
		 loginPage=new LoginPage();
		}
	
	// Important Rules: 1.within the class, always remmember that @Test cases should be independent to each other, ie there should be no dependency between them
		//2. before each @Test case always launch the browser, login and after that close it(see @BeforeMethod and @AfterMethod for an insight)
		//3. Also, there is no link between one test class to the other test class
	@Test(priority=2)
	public void loginPageTitleTest() {
		
		String title=loginPage.validateLoginPageTitle(); //accessing all the methods of loginpage class throu its object
	Assert.assertEquals(title, "Login - My Store", "failed to match titles");
	System.out.println(title);
	}
	
	
	@Test(priority=1,enabled=false)
	
	public void signInClickTest() {
		
		loginPage.signInClick();
	}
	@Test(priority=3,enabled=false)
	public void logoImageTest() {
	boolean flag=loginPage.validateLogoImage(); //we gave a random name as flag to verify here
		Assert.assertTrue(flag);
	}
	
	@Test(priority=4,enabled=false)
	public void loginTest() {
		myAccountPage=loginPage.login(prop.getProperty("email"), prop.getProperty("pass")); //L.H.S is similar to HomePage hmpage=new HomePage(); //in other way it can also be written through Return keyword
		//saved in myAccountPage's reference variable as this returns a home page object
	}
//		@Test(priority=5)
//		public void titleTest() {
//			String loginTitle=loginPage.validateLoginPageTitle();
//			Assert.assertEquals(loginTitle, "Login - My Store");
//		}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
}
