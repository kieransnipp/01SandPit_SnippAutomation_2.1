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
import com.crm.qa.pages.FacebookPage;
import com.crm.qa.pages.LocationsPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MyProfilePage;
import com.crm.qa.pages.OffersPage;
import com.crm.qa.pages.SocialPage;
import com.crm.qa.pages.UploadRecieptPage;

import com.crm.qa.util.TestUtil;

public class LocationsPageTest extends TestBase {
	LoginPage loginPage;
	LocationsPage locationsPage;
	DetailsPage detailsPage;

	UploadRecieptPage upLoadPage;
	OffersPage offersPage;
	SocialPage socialPage;
	MyProfilePage myProfile;


	public LocationsPageTest() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeMethod
	// @BeforeClass
	public void setUp() throws InterruptedException {
		initialization();
		// testUtil = new TestUtil();
		loginPage = new LoginPage();
		upLoadPage = new UploadRecieptPage();
		offersPage = new OffersPage();
		socialPage = new SocialPage();
		myProfile = new MyProfilePage();
		locationsPage = new LocationsPage();
//		facebookPage = new FacebookPage();
//		yelpPage = new YelpPage();
		
		detailsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

		TestUtil.runTimeInfo("error", "login successful");
		locationsPage = detailsPage.clickOnLocationsPage();
	}

	@Test(priority = 1)
	public void verifyDetailsPageTitleTest() {
		String homePageTitle = locationsPage.verifyLocationsPageTitle();
		Assert.assertEquals(homePageTitle, "Stores");

	}

	@Test(priority = 2)
	public void textBavInnLodgeDisplayed() {
		Assert.assertTrue(locationsPage.textBavInnLodge());
	}

	@Test(priority = 3)
	public void isBrandImageDisplayed() {
		Assert.assertTrue(locationsPage.brandImageDisplayed());
	}

	@Test(priority = 4)
	public void textMainStreetShopsDisplayed() {
		Assert.assertTrue(locationsPage.textMainStreetShops());
	}

	@Test(priority = 5)
	public void assertTermsAndCond() {
		Assert.assertTrue(locationsPage.assertTermsAndCond());
	}

	@Test(priority = 6)
	public void footerPrivacyPolicy() {
		Assert.assertTrue(locationsPage.assertPrivacyPolicy());
	}

	@Test(priority = 7)
	public void footerFAQ() {
		Assert.assertTrue(locationsPage.assertFAQ());
	}

	@Test(priority = 8)
	public void footerContactUs() {
		Assert.assertTrue(locationsPage.assertContactUs());
	}

	@AfterMethod
	// @AfterClass
	public void tearDown() {
		driver.quit();
	}

}
