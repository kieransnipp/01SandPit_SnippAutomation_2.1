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

public class UploadRecieptPageTest extends TestBase {

	LoginPage loginPage;
	DetailsPage detailsPage;
	UploadRecieptPage upLoadPage;
	OffersPage offersPage;
	LocationsPage locationsPage;
	SocialPage socialPage;
	MyProfilePage myProfile;
	TestUtil testUtil;

	public UploadRecieptPageTest() {
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
		upLoadPage = detailsPage.clickOnUploadReciept();

	}

	@Test(priority = 1)
	public void verifyDetailsPageTitleTest() {
		String homePageTitle = upLoadPage.verifyUploadRecieptPageTitle();
		Assert.assertEquals(homePageTitle, "Upload Receipt");

	}

	@Test(priority = 2)
	public void brandImageDisplayed() {
		Assert.assertTrue(upLoadPage.brandImageDisplayed());
	}

//
	@Test(priority = 3)
	public void assertContactUs() {
		Assert.assertTrue(upLoadPage.assertContactUs());
	}

	@Test(priority = 4)
	public void assertFAQ() {
		Assert.assertTrue(upLoadPage.assertFAQ());
	}
	
	@Test(priority = 5)
	public void assertPrivacyPolicy() {
		Assert.assertTrue(upLoadPage.assertPrivacyPolicy());
	}
	
	@Test(priority = 6)
	public void assertTermsAndCond() {
		Assert.assertTrue(upLoadPage.assertTermsAndCond());
	}
	
	
	@Test(priority = 7) // For all screens
	public void imageIsDisplayed() {
		Assert.assertTrue(upLoadPage.imageIsDisplayed());
	}
	
	@Test(priority = 8)
	public void uploadRecieptImageTest() throws InterruptedException {
		System.out.println("Upload a file");
		upLoadPage.uploadButtonSelection();
		upLoadPage.verifyUploadWorked();
		upLoadPage.verifyUploadQUEUEDStatusTest();
		upLoadPage.viewtheUploadedReciept();
		
	}

	 @AfterMethod
	//@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
