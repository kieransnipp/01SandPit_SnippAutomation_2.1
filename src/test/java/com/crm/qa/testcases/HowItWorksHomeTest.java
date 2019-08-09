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
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.HowItWorksHomePage;
import com.crm.qa.pages.LocationsPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MyProfilePage;
import com.crm.qa.pages.OffersPage;
import com.crm.qa.pages.SocialPage;
import com.crm.qa.pages.UploadRecieptPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;

public class HowItWorksHomeTest extends TestBase {
	LoginPage loginPage;
	LocationsPage locationsPage;
	DetailsPage detailsPage;

//	UploadRecieptPage upLoadPage;
	HowItWorksHomePage howItWorksHomePage;

	public HowItWorksHomeTest() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	 @BeforeMethod
	//@BeforeClass
	public void setUp() throws InterruptedException {
		initialization();
		// testUtil = new TestUtil();
		loginPage = new LoginPage();
		detailsPage = new DetailsPage();

		howItWorksHomePage = new HowItWorksHomePage();

		// detailsPage = loginPage.login(prop.getProperty("username"),
		// prop.getProperty("password"));

		TestUtil.runTimeInfo("error", "login successful");
		howItWorksHomePage = loginPage.clickOnHowInWorks();
	}

	@Test(priority = 1)
	public void verifyDetailsPageTitleTest() {
		String homePageTitle = howItWorksHomePage.verifyPageTitle();

		Assert.assertEquals(homePageTitle, "Home");

	}

	@Test(priority = 2)
	public void textLoyaltyCard() {
		Assert.assertTrue(howItWorksHomePage.textLoyaltyCard());
	}

	@Test(priority = 3)
	public void isBrandImageDisplayed() {
		Assert.assertTrue(howItWorksHomePage.brandImageDisplayed());
	}

	@Test(priority = 5)
	public void assertTermsAndCond() {
		Assert.assertTrue(howItWorksHomePage.assertTermsAndCond());
	}

	@Test(priority = 6)
	public void footerPrivacyPolicy() {
		Assert.assertTrue(howItWorksHomePage.assertPrivacyPolicy());
	}

	@Test(priority = 7)
	public void footerFAQ() {
		Assert.assertTrue(howItWorksHomePage.assertFAQ());
	}

	@Test(priority = 8)
	public void footerContactUs() {
		Assert.assertTrue(howItWorksHomePage.assertContactUs());
	}

	@Test(priority = 9)
	public void textEarnAndRedeem() throws Exception {
		Thread.sleep(1000);
		Assert.assertTrue(howItWorksHomePage.textEarnAndRedeem());
	}

	 @AfterMethod
	//@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
