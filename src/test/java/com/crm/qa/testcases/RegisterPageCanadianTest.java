package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;

import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.LocationsPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MyProfilePage;
import com.crm.qa.pages.OffersPage;
import com.crm.qa.pages.RegisterPage;
import com.crm.qa.pages.RegistrationPerksPaymentPage;
import com.crm.qa.pages.SocialPage;
import com.crm.qa.pages.UploadRecieptPage;
import com.crm.qa.testdata.RegisterDataCanada;
import com.crm.qa.util.TestUtil;
import com.crm.qa.testdata.RegisterDataCanada;

public class RegisterPageCanadianTest extends TestBase {

	LoginPage loginPage;
	RegisterPage registerPage;
	TestUtil testUtil;
	RegistrationPerksPaymentPage registrationPerksPaymentPage;
	

	public RegisterPageCanadianTest() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeMethod
	// @BeforeClass
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		registerPage = new RegisterPage();
		testUtil = new TestUtil();
		registrationPerksPaymentPage = new RegistrationPerksPaymentPage();
		
		
		// Landing page
		registerPage = loginPage.clickOnRegister();
		registrationPerksPaymentPage = registerPage.registerNewUserTest();
		TestUtil.runTimeInfo("error", "login successful");

	}


	@Test(priority = 1)
	public  void registerNewUserTest() throws InterruptedException {
		String homePageTitle = registrationPerksPaymentPage.verifyPageTitle();
		Assert.assertEquals(homePageTitle, "Registration Perks payment");
		registrationPerksPaymentPage.enterCardNumberDetailsTest();
	}
	
	
	
	@AfterMethod
	// @AfterClass
	public void tearDown() {
		driver.quit();
	}

}
