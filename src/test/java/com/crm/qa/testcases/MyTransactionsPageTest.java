package com.crm.qa.testcases;

import static org.testng.Assert.assertTrue;

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

public class MyTransactionsPageTest extends TestBase {
	LoginPage loginPage;
	LocationsPage locationsPage;
	DetailsPage detailsPage;

	UploadRecieptPage upLoadPage;
	OffersPage offersPage;
	SocialPage socialPage;
	MyProfilePage myProfile;
	CheckBalancePage checkPageBalance;
	MyTransactionsPage myTransactions;

	public MyTransactionsPageTest() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeMethod
	// @BeforeClass
	public void setUp() throws Exception {
		try {

			initialization();
			// testUtil = new TestUtil();
			loginPage = new LoginPage();
			upLoadPage = new UploadRecieptPage();
			offersPage = new OffersPage();
			socialPage = new SocialPage();
			myProfile = new MyProfilePage();
			myTransactions = new MyTransactionsPage();

			detailsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

			TestUtil.runTimeInfo("error", "login successful");
			myTransactions = detailsPage.clickOnMyTransactions();
		} catch (Exception e) {
			System.out.println("Cause is " + e.getCause());
			System.out.println("Stack Trace is " + e.getStackTrace());
		}
	} // End setUp

	@Test(priority = 1)
	public void verifyDetailsPageTitleTest() {
		String homePageTitle = offersPage.verifyDetailsPageTitle();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertEquals(homePageTitle, "Transactions");

	}

	@Test(priority = 2)
	public void isBrandLogoDisplayed() {
		Assert.assertTrue(myTransactions.brandLogoDisplayed());
	}

	@Test(priority = 3)
	public void isBrandImageDisplayed() {
		Assert.assertTrue(myTransactions.brandMembersLogoDisplayed());
	}

	@Test(priority = 5)
	public void assertTermsAndCond() {
		Assert.assertTrue(myTransactions.assertTermsAndCond());
	}

	@Test(priority = 6)
	public void footerPrivacyPolicy() {
		Assert.assertTrue(myTransactions.assertPrivacyPolicy());
	}

	@Test(priority = 7)
	public void footerFAQ() {
		Assert.assertTrue(myTransactions.assertFAQ());
	}

	@Test(priority = 8)
	public void footerContactUs() {
		Assert.assertTrue(myTransactions.assertContactUs());
	}

	@AfterMethod
	// @AfterClass
	public void tearDown() {
		driver.quit();
	}

}
