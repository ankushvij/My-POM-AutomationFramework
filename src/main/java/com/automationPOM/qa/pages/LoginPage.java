package com.automationPOM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPOM.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Now a page factory/object repository we will define in every page class, its done in the following way:
	//defining login based page libraries
	@FindBy(name="email")  //Now we are using @annotation this in place of driver.findelement.by.Xpath.. or by.name or anything
	WebElement email;
	
	@FindBy(name="passwd")  //'name', 'linkText' etc. are real attributes seen by inspecting elements in html
	WebElement password;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement submit;
	
	
	@FindBy(linkText="Forgot your password?")
	WebElement forgotPasswordLink;
	
	@FindBy(linkText="Sign in")
	WebElement signIn;
	
	@FindBy(xpath="//input[contains(@id,'search_query_top')]")
	WebElement searchBox;
	
	@FindBy(xpath="//a[contains(@title,'My Store')]")
	WebElement logo;
	
	//Now initialising the objects elements of this page:
	//we create a constructor for this:
	
	public LoginPage() { //constructor of this class will be created
	PageFactory.initElements(driver, this)	;//initialises the webelements with this keyword points to the current class ie. LoginClass
		
	}
	
	
	//Now we will create the methods for actions on this page
	
	
	public void signInClick() {
		signIn.click(); //driver.firndElemen..by...click() is not used as signIn buttons's path is already defined above in page factory
		
	}
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
		//this will return the title only, title we will eventually verify in the LoginTestclass
	}
	
public Boolean validateLogoImage() {
		
		return logo.isDisplayed();
	}
	
public MyAccountPage login(String usernme,String pwd) {
	
	email.sendKeys(usernme); //email is the webelement we defined above
	password.sendKeys(pwd);
	submit.click();
	
	// Now login method should return Home page class object as after login we land on that page

	return new MyAccountPage(); //thus its return type is Home, now the login page test will be created in src test folder


}

}
