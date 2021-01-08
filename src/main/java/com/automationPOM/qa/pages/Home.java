package com.automationPOM.qa.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPOM.qa.base.TestBase;

public class Home extends TestBase {
	
	//creating page factories:
	
	@FindBy(xpath="//span[contains(text(),'Ankush Vij')]")
	WebElement userNameLabel;
	
	
	@FindBy(xpath="//a[contains(text(),'Contact us') and @title='Contact Us']")
	WebElement contactsLink; //on home page we create the contacts click link 
	
	@FindBy(xpath="//a[contains(text(),'Women')]")
	WebElement womenTab;
	
	@FindBy(xpath="//a[@title='Home' and @class='btn btn-default button button-small']")
	WebElement homeButton;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement searchField;
	
	//Initialising the webelements of this page thourgh constructor of home page
	
	public Home() {
		
		PageFactory.initElements(driver, this);
		}
	
	//now defining the actions to be performed
	
	public String verifyHomeTitle() {
		return driver.getTitle();  //eventually verified in our HomeTestClass
		
	}
	
	public ContactUs ContactsClick() {
		
		contactsLink.click();//to be created in home page as the link is here on this page
		return new ContactUs(); //as this returns the object of ContactUS class/page
		
	}

	public WomenTab womenTabClick() {
		
		womenTab.click();
		return new WomenTab(); //next landing page object helps focus on the next page
	}
	
	public Home homeClick() {
		
		homeButton.click();
		return new Home();
	}
	
	public void searchFocus() {
		
		searchField.click();
	}
	
	public boolean userLabelCorrect() {
		return userNameLabel.isDisplayed();
		
		}
	
	
}
