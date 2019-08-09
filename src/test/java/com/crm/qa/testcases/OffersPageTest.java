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
import com.crm.qa.pages.SocialPage;
import com.crm.qa.pages.UploadRecieptPage;
import com.crm.qa.util.TestUtil;

public class OffersPageTest extends TestBase {

	LoginPage loginPage;
	DetailsPage detailsPage;
	UploadRecieptPage upLoadPage;
	OffersPage offersPage;
	LocationsPage locationsPage;
	SocialPage socialPage;
	MyProfilePage myProfile;
	TestUtil testUtil;

	public OffersPageTest() {
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

		loginPage = new LoginPage();
		upLoadPage = new UploadRecieptPage();
		offersPage = new OffersPage();
		locationsPage = new LocationsPage();
		socialPage = new SocialPage();
		myProfile = new MyProfilePage();
		testUtil = new TestUtil();

		// Landing page
		detailsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		TestUtil.runTimeInfo("error", "login successful");
		// testUtil.switchToFrame();
		offersPage = detailsPage.clickOnOffersPage();

	}

	@Test(priority = 1)
	public void verifyDetailsPageTitleTest() {
		String homePageTitle = offersPage.verifyDetailsPageTitle();
		Assert.assertEquals(homePageTitle, "Offers");

	}

	// Declare here - Step 3
	@Test(priority = 2)
	public void verifyLogoDisplayed() {
		Assert.assertTrue(offersPage.brandLogoDisplayed());
	}

	@Test(priority = 3)
	public void verifyMembersOffersLogoDisplayed() {
		Assert.assertTrue(offersPage.brandMembersLogoDisplayed());
	}

	@Test(priority = 4)
	public void verifyTextDisplayed() {
		Assert.assertTrue(offersPage.textIsDisplayed());
	}

	@Test(priority = 5) // For all screens
	public void verifySocialMediaFooter() {
		Assert.assertTrue(offersPage.socialMediaDisplayed());
	}

	 @AfterMethod
	//@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
