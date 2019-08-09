package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CheckBalancePage;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.LocationsPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MyProfilePage;
import com.crm.qa.pages.MyTransactionsPage;
import com.crm.qa.pages.OffersPage;
import com.crm.qa.pages.SocialPage;
import com.crm.qa.pages.UploadRecieptPage;
import com.crm.qa.util.TestUtil;

public class MyProfilePageTest extends TestBase {
	LoginPage loginPage;
	LocationsPage locationsPage;
	DetailsPage detailsPage;

	UploadRecieptPage upLoadPage;
	OffersPage offersPage;
	SocialPage socialPage;

	MyProfilePage myProfilePage;
	CheckBalancePage checkBalancePage;
	MyTransactionsPage myTransactionsPage;

	public MyProfilePageTest() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	 @BeforeMethod
	//@BeforeClass
	public void setUp() throws Exception {
		try {
			initialization();
			// testUtil = new TestUtil();
			loginPage = new LoginPage();
			upLoadPage = new UploadRecieptPage();
			offersPage = new OffersPage();

			detailsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

			TestUtil.runTimeInfo("error", "login successful");
			myProfilePage = detailsPage.clickOnMyProfilePage();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 1)
	public void verifyDetailsPageTitleTest() {
		String homePageTitle = myProfilePage.verifyLocationsPageTitle();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertEquals(homePageTitle, "Profile");

	}

	// Footer bar
	@Test(priority = 5)
	public void assertTermsAndCond() {
		Assert.assertTrue(myProfilePage.assertTermsAndCond());
	}

	@Test(priority = 7)
	public void footerFAQ() {
		Assert.assertTrue(myProfilePage.assertFAQ());
	}

	@Test(priority = 8)
	public void footerContactUs() {
		Assert.assertTrue(myProfilePage.assertContactUs());
	}

	 @AfterMethod
	//@AfterClass
	public void tearDown() {
		 driver.quit();
	}

}
