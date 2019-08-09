package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

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

public class SocialPageTest extends TestBase {

	LoginPage loginPage;
	DetailsPage detailsPage;
	UploadRecieptPage upLoadPage;
	OffersPage offersPage;
	LocationsPage locationsPage;
	SocialPage socialPage;
	MyProfilePage myProfile;
	TestUtil testUtil;

	public SocialPageTest() {
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
			loginPage = new LoginPage();
			upLoadPage = new UploadRecieptPage();
			offersPage = new OffersPage();
			locationsPage = new LocationsPage();
			socialPage = new SocialPage();
			myProfile = new MyProfilePage();
			testUtil = new TestUtil();

			detailsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

			TestUtil.runTimeInfo("error", "login successful");
			socialPage = detailsPage.clickOnSocialPage();
			Thread.sleep(20000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void verifyDetailsPageTitleTest() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String homePageTitle = socialPage.verifyLocationsPageTitle();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertEquals(homePageTitle, "Earn Points");

	}

	@Test(priority = 2)
	public void verifyBrandImageDisplayed() {
		// socialPage = detailsPage.clickOnSocialPage();
		Assert.assertTrue(socialPage.brandImageDisplayed());
	}

	@Test(priority = 3)
	public void verifyImageIsDisplayed() {
		// socialPage = detailsPage.clickOnSocialPage();
		Assert.assertTrue(socialPage.imageIsDisplayed());
	}

	@Test(priority = 4)
	public void verifyTextDisplayed() {
		// socialPage = detailsPage.clickOnSocialPage();
		Assert.assertTrue(socialPage.referTextDisplayed());
	}

	@Test(priority = 5) // For all screens
	public void verifytwitterIsDisplayed() {
		// socialPage = detailsPage.clickOnSocialPage();
		Assert.assertTrue(socialPage.twitterIsDisplayed());
	}

	@Test(priority = 6)
	public void enterFriendsEmail() {
		// socialPage = detailsPage.clickOnSocialPage();
		Assert.assertTrue(socialPage.enterFriendsEmail("dave@dave.com"));
	}

	// Footer
	@Test(priority = 7) // For all screens
	public void assertTermsAndCond() {
		// socialPage = detailsPage.clickOnSocialPage();
		Assert.assertTrue(socialPage.assertTermsAndCond());
	}

	@Test(priority = 8) // For all screens
	public void assertPrivacyPolicy() {
		// socialPage = detailsPage.clickOnSocialPage();
		Assert.assertTrue(socialPage.assertPrivacyPolicy());
	}

	@Test(priority = 9) // For all screens
	public void assertFAQ() {
		// socialPage = detailsPage.clickOnSocialPage();
		Assert.assertTrue(socialPage.assertFAQ());
	}

	@Test(priority = 10) // For all screens
	public void assertContactUs() {
		// socialPage = detailsPage.clickOnSocialPage();
		Assert.assertTrue(socialPage.assertContactUs());
	}

	 @AfterMethod
	//@AfterClass
	public void tearDown() {
		 driver.quit();
		
	}

}
