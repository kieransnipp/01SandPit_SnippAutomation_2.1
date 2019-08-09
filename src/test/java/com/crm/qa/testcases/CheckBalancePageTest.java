package com.crm.qa.testcases;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CheckBalancePage;

import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.LocationsPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MyProfilePage;
import com.crm.qa.pages.OffersPage;
import com.crm.qa.pages.SocialPage;
import com.crm.qa.pages.UploadRecieptPage;
import com.crm.qa.util.TestUtil;

public class CheckBalancePageTest extends TestBase {
	LoginPage loginPage;
	LocationsPage locationsPage;
	DetailsPage detailsPage;

	UploadRecieptPage upLoadPage;
	OffersPage offersPage;
	SocialPage socialPage;
	MyProfilePage myProfile;
	CheckBalancePage checkPageBalance;

	public CheckBalancePageTest() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		checkPageBalance = new CheckBalancePage();
		detailsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

		TestUtil.runTimeInfo("error", "login successful");
		checkPageBalance = detailsPage.clickOnCheckBalance();
	}

	@Test(priority = 1)
	public void verifyDetailsPageTitleTest() {
		String homePageTitle = checkPageBalance.verifyLocationsPageTitle();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertEquals(homePageTitle, "Check Card Balance");

	}

	@Test(priority = 2)
	public void assertTermsAndCond() {
		Assert.assertTrue(checkPageBalance.assertTermsAndCond());
	}

	@Test(priority = 3)
	public void footerPrivacyPolicy() {
		Assert.assertTrue(checkPageBalance.assertPrivacyPolicy());
	}

	@Test(priority = 4)
	public void footerFAQ() {
		Assert.assertTrue(checkPageBalance.assertFAQ());
	}

	@Test(priority = 5)
	public void footerContactUs() {
		Assert.assertTrue(checkPageBalance.assertContactUs());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
