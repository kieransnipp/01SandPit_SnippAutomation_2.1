package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.RegisterPage;
import com.crm.qa.pages.RegistrationPerksPaymentPage;
import com.crm.qa.util.TestUtil;

public class RegistrationPerksPaymentTest extends TestBase {
	LoginPage loginPage;
	RegisterPage registerPage;
	RegistrationPerksPaymentPage registrationPerksPaymentPage;

	public RegistrationPerksPaymentTest() {
		super();
	}

	// @BeforeClass
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		registerPage = new RegisterPage();
		registrationPerksPaymentPage = new RegistrationPerksPaymentPage();

		registerPage = loginPage.clickOnRegister();

	}

	@Test(priority = 1)
	public void registerNewUserTest() {
		String homePageTitle = registrationPerksPaymentPage.verifyPageTitle();
		Assert.assertEquals(homePageTitle, "Register");
	}

	@Test(priority = 2)
	public void RegistrationPerksPaymentPage() throws Exception {
		try {
			registrationPerksPaymentPage = registerPage.registerNewUserTest();
			
		} catch (Exception e) {
			System.out.println("getStackTrace = " + e.getStackTrace());
			System.out.println("getCause = " + e.getCause());
		}
		Thread.sleep(1000);
		registrationPerksPaymentPage.enterCardNumberDetailsTest();
		String title = registrationPerksPaymentPage.verifyPageTitle();
		Assert.assertEquals(title, "Registration Perks payment");
	}

	// @AfterClass
	@AfterMethod
	public void tearDown() {
		System.out.println("After class here");
		driver.quit();

	}

}
