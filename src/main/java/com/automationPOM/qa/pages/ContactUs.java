package com.automationPOM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automationPOM.qa.base.TestBase;
import com.automationPOM.qa.utils.TestUtil;

public class ContactUs extends TestBase{

	//creating page factories:
	
	@FindBy(xpath="//select[@id='id_contact']")
	@CacheLookup
	WebElement headingDdl;
 
	@FindBy(xpath="//input[@id='email']")
	WebElement emailAdd;
	
	@FindBy(xpath="//textarea[@id='message']")
	WebElement messageArea;
	
	@FindBy(xpath="//button[@id='submitMessage']")
	WebElement sendButton;
	
	
	public ContactUs() {
	 
	 PageFactory.initElements(driver,this);
 }
	
	public void headingDdlSelect() {
		headingDdl.click();
//driver.findElement(By.id("TestUtil.selectElement()")).click();
		
	}
	
	public void addMessage() {
		
		messageArea.sendKeys(prop.getProperty("TextMessage"));
	}
	
	public void emailAdd() {
		//emailAdd.sendKeys(TestUtil.emailAddress); //below code for config.prop
		//emailAdd.click();
		emailAdd.clear();
		emailAdd.sendKeys(prop.getProperty("Email"));
		
	}
	public void selectFromSubjectHeadingDdl() {
		Select sl= new Select(headingDdl);
		sl.selectByVisibleText("Webmaster");
		
	}
	
	public String titleVerify() {
		System.out.println("TestingQA");
		return driver.getTitle();
		
		}
	
	public void sendMessage(String title, String email,String message) {
		Select sl= new Select(headingDdl);
		sl.selectByVisibleText(title);
		emailAdd.sendKeys(email);
		messageArea.sendKeys(message);
		sendButton.click();
		
		
		
	}
}
