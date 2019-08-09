package com.crm.qa.testcases;

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
import com.crm.qa.pages.MyTransactionsPage;
import com.crm.qa.pages.OffersPage;
import com.crm.qa.pages.SocialPage;
import com.crm.qa.pages.UploadRecieptPage;

public class DetailsPageTest extends TestBase {
	LoginPage loginPage;
	UploadRecieptPage upLoadPage;
	OffersPage offersPage;
	LocationsPage locationsPage;
	SocialPage socialPage;
	MyProfilePage myProfilePage;

	DetailsPage detailsPage;
	MyTransactionsPage myTransactions;

	public DetailsPageTest() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	 @BeforeMethod
	//@BeforeClass
	public void setUp() {
		initialization();
		// testUtil = new TestUtil();
		loginPage = new LoginPage();
		upLoadPage = new UploadRecieptPage();
		offersPage = new OffersPage();

		locationsPage = new LocationsPage();
		socialPage = new SocialPage();
		myProfilePage = new MyProfilePage();
		detailsPage = new DetailsPage();

		detailsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void verifyHomeLoginPageTitleTest() {
		String homePageTitle = detailsPage.verifyPageTitle();
		Assert.assertEquals(homePageTitle, "Home");
	}

	// Declare here - Step 3
	@Test(priority = 2)
	public void verifyWelcomeName() {
		// testUtil.switchToFrame();
		Assert.assertTrue(detailsPage.verifyCorrectUserName());
	}

	@Test(priority = 3)
	public void referFriend() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(detailsPage.enterFriendsEmail("dave@dave.com"));

	}

	//Footer checking
	@Test(priority = 4)
	public void assertTermsAndCond() {
		Assert.assertTrue(detailsPage.assertTermsAndCond());
	}

	@Test(priority = 5)
	public void footerPrivacyPolicy() {
		Assert.assertTrue(detailsPage.assertPrivacyPolicy());
	}

	@Test(priority = 6)
	public void footerFAQ() {
		Assert.assertTrue(detailsPage.assertFAQ());
	}

	@Test(priority = 7)
	public void footerContactUs() {
		Assert.assertTrue(detailsPage.assertContactUs());
	}

	 @AfterMethod
	//@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
