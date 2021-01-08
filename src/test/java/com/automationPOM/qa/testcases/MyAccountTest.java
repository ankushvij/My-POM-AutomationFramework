//Author Ankush Vij
package com.automationPOM.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationPOM.qa.base.TestBase;
import com.automationPOM.qa.pages.ContactUs;
import com.automationPOM.qa.pages.LoginPage;
import com.automationPOM.qa.pages.MyAccountPage;
import com.automationPOM.qa.utils.TestUtil;

public class MyAccountTest extends TestBase {

	public LoginPage loginPage;
//MyAccountPage myAccount ; //by mistake i created two objects of the same class, due to tbis my code broke with an exception
	public ContactUs contactUs = new ContactUs();
	public MyAccountPage myAccountPage = new MyAccountPage();

	String sheetName = "contacts"; // name of the workbook inside the excel sheet

	public MyAccountTest() {
		super();

	}

	@BeforeMethod
	public void setUp() { // these are methods of MyAccountTest class
		initialization();
		// now simply creating object of loginpage class
		loginPage = new LoginPage();
		contactUs = new ContactUs(); // this is very important to write the object initiation in the @beforeMethods,
										// otherwise Null pointer exception is faced
		myAccountPage = loginPage.login(prop.getProperty("email"), prop.getProperty("pass")); // we have to login first
																								// so we are now writing
																								// all of these
		// in @BeforeMethod , also saved in MyAccount object

	}

	@Test(priority = 1, enabled = false)
	public void searchText() {
		myAccountPage.searchText();

	}

	@Test(priority = 2, enabled = false)
	public void messageAddition() {
		System.out.println("test");
		myAccountPage.ContactsClickMyAccount();
		contactUs.addMessage();
	}

	@Test(priority = 3, enabled = false)
	public void verifyContactUsTitleTest() throws InterruptedException {
		myAccountPage.ContactsClickMyAccount();
		System.out.println("test");
		Thread.sleep(5000);
		System.out.println(contactUs.titleVerify());
		// Assert.assertEquals(title, "Contact us - My Store","No matching of titles");

	}

	@Test(priority = 4, enabled = false)

	public void ddlSelectTest() throws InterruptedException {
		System.out.println("ddlSelect");
		Thread.sleep(5000);
		myAccountPage.ContactsClickMyAccount();
		contactUs.selectFromSubjectHeadingDdl();

	}

	@Test(priority = 5, enabled = false)

	public void titleMyAccountTest() {
		String title = myAccountPage.myAccountTitleVerify();
		System.out.println(title);

	}

	@Test(priority = 6, enabled = false)

	public void subjectHeadingClick() throws InterruptedException {
		// Thread.sleep(5000);
		myAccountPage.ContactsClickMyAccount();
		contactUs.headingDdlSelect();
	}

	@Test(priority = 7, enabled = false)
	public void addEmail() {
		myAccountPage.ContactsClickMyAccount();
		contactUs.emailAdd();
	}

	@DataProvider // see the getTestData() in TestUtil class
	public Object[][] getTestDataFromSheet() throws InvalidFormatException { // saving whole of the excel sheet's data
																				// inside this object array
		Object data[][] = TestUtil.getTestData(sheetName); // Imp: the sheetName is the name of the worksheet inside our
															// excel file and not the name of the excel file
		return data;
	}

	@Test(priority = 1, enabled = true, dataProvider = "getTestDataFromSheet") // here we write the name of the above
																				// method in quotes(which is providing
																				// the data)
	public void sendMessagesTest(String headingDdl, String emailAdd, String messageArea) {// we have to give the
																							// parameters equal to the
																							// names of columns in our
																							// worksheet, simmilarly we
																							// can use the
		// same sheet with many worksheets within it for various data drive tests.
		myAccountPage.ContactsClickMyAccount();
		contactUs.sendMessage(headingDdl, headingDdl, messageArea);// names of the columns as passed in test
																	// ie.sendMessagesTest method

	}

	@AfterMethod(enabled = false)
	public void tearDown() {
		driver.close();
	}

}
