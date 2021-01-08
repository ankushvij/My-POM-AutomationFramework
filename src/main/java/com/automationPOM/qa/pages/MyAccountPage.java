package com.automationPOM.qa.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPOM.qa.base.TestBase;

public class MyAccountPage extends TestBase{
 public ContactUs contactUs=new ContactUs();
  
	//creating page factories:
	
@FindBy(xpath="//a[contains(text(),'Contact us') and @title='Contact Us']")
@CacheLookup//-->this puts the element in the cache memory in the program itself to speedup the tests and not fetching through the browser everytime, but problem is that if the page got refreshed,dom model got changed at runtime,
// then the cached memory elements will be staled and throw stale element exception, so use only if u r sure of the eleemnt will not change-->this is used for improving the performmance of our script though.
WebElement contactsLinkMyAccount; 

@FindBy(xpath="//input[@id='search_query_top']")
@CacheLookup
WebElement searchField;



	public void searchText() {
		searchField.sendKeys("Hi ankush, this is a HI from Selenium WebDriver to you!");
		
		
	}	
	 public MyAccountPage() {
			PageFactory.initElements(driver,this);
		} 
		 
	 // defining Actions methods 
		public ContactUs ContactsClickMyAccount() {
			
			contactsLinkMyAccount.click();//method to be created in home page or my accounts page as the link is there on these pages
			 //as this returns the object of ContactUS class/page
			return new ContactUs();
		}
		
		public String myAccountTitleVerify() {
			System.out.println("Testing");
			return driver.getTitle();
			
		}
		
		
}
