package com.crm.qa.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codeborne.selenide.ex.TimeoutException;
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

public class CheckLinksAllPagesTest extends TestBase {
	LoginPage loginPage;
	UploadRecieptPage upLoadPage;
	OffersPage offersPage;
	LocationsPage locationsPage;
	SocialPage socialPage;
	MyProfilePage myProfilePage;
	TestUtil testUtil;
	DetailsPage detailsPage;
	MyTransactionsPage myTransactions;
	CheckBalancePage checkBalancePage;


	public CheckLinksAllPagesTest() {
		super();
	}

	@BeforeMethod
	// @BeforeClass
	public void setUp() throws InterruptedException {
		try {

			initialization();
			testUtil = new TestUtil();
			loginPage = new LoginPage();
			upLoadPage = new UploadRecieptPage();
			offersPage = new OffersPage();
			locationsPage = new LocationsPage();
			socialPage = new SocialPage();
			myProfilePage = new MyProfilePage();
			detailsPage = new DetailsPage();
			myTransactions = new MyTransactionsPage();

			detailsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			TestUtil.runTimeInfo("error", "login successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1) // Working
	public void checkLinksDetailsHome() throws InterruptedException {
		String homePageTitle = detailsPage.verifyPageTitle();
		System.out.println("Page is =" + homePageTitle);

		Assert.assertEquals(homePageTitle, "Details");
		Thread.sleep(3000);
		Assert.assertTrue(detailsPage.assertContactUs());
		Boolean checkedOk = checkLinks();
		assertTrue(checkedOk);

	}

	@Test(priority = 2) // working
	public void checkLinksuploadReciept() throws InterruptedException {
		upLoadPage = detailsPage.clickOnUploadReciept();

		String homePageTitle = upLoadPage.verifyUploadRecieptPageTitle();
		Assert.assertEquals(homePageTitle, "Upload Receipt");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("Page is =" + homePageTitle);

		Thread.sleep(3000);
		Assert.assertTrue(upLoadPage.assertPrivacyPolicy());
		Boolean checkedOk = checkLinks();
		assertTrue(checkedOk);

	}

	@Test(priority = 3) // working
	public void checkLinksOffers() throws InterruptedException {
		offersPage = detailsPage.clickOnOffersPage();

		String homePageTitle = offersPage.verifyDetailsPageTitle();
		Assert.assertEquals(homePageTitle, "Offers");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("Page is =" + homePageTitle);

		Thread.sleep(3000);
		Assert.assertTrue(offersPage.brandMembersLogoDisplayed());
		Boolean checkedOk = checkLinks();
		assertTrue(checkedOk);

	}

	@Test(priority = 4) // working
	public void checkLinksLocations() throws InterruptedException {
		locationsPage = detailsPage.clickOnLocationsPage();

		String homePageTitle = locationsPage.verifyLocationsPageTitle();
		Assert.assertEquals(homePageTitle, "Stores");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("Page is =" + homePageTitle);

		// Thread.sleep(3000);
		Assert.assertTrue(locationsPage.assertPrivacyPolicy());
		Boolean checkedOk = checkLinks();
		assertTrue(checkedOk);

	}

	@Test(priority = 5) // Working
	public void checkLinksSocialPage() throws InterruptedException {
		try {

			socialPage = detailsPage.clickOnSocialPage();
		} catch (TimeoutException e) {
			System.out.println("Error is " + e.getStackTrace());
		}
		String homePageTitle = socialPage.verifyLocationsPageTitle();
		System.out.println("Page is =" + homePageTitle);

		Assert.assertEquals(homePageTitle, "Earn Points");

		Boolean checkedOk = checkLinks();
		assertTrue(checkedOk);

	}

//	
	@Test(priority = 6) // working
	public void checkLinksmyProfile() throws InterruptedException {
		myProfilePage = detailsPage.clickOnMyProfilePage();

		String homePageTitle = myProfilePage.verifyLocationsPageTitle();
		// Assert.assertEquals(homePageTitle, "Profile");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("Page is =" + homePageTitle);

		Thread.sleep(3000);
		Assert.assertTrue(myProfilePage.assertPrivacyPolicy());
		Boolean checkedOk = checkLinks();
		assertTrue(checkedOk);

	}

	@Test(priority = 7) // working
	public void checkLinksCheckBalance() throws InterruptedException {
		checkBalancePage = detailsPage.clickOnCheckBalance();

		String homePageTitle = checkBalancePage.verifyLocationsPageTitle();
		// Assert.assertEquals(homePageTitle, "Profile");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("Page is =" + homePageTitle);

		Thread.sleep(3000);
		Assert.assertTrue(checkBalancePage.assertPrivacyPolicy());
		Boolean checkedOk = checkLinks();
		assertTrue(checkedOk);

	}
	
	@Test(priority = 8) // working
	public void checkLinksMyTransactions() throws InterruptedException {
		myTransactions = detailsPage.clickOnMyTransactions();

		String homePageTitle = myTransactions.verifyDetailsPageTitle();
		// Assert.assertEquals(homePageTitle, "Profile");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("Page is =" + homePageTitle);

		Thread.sleep(3000);
		Assert.assertTrue(myTransactions.assertPrivacyPolicy());
		Boolean checkedOk = checkLinks();
		assertTrue(checkedOk);

	}

	@AfterMethod
	// @AfterClass
	public void tearDown() {
		driver.quit();
	}

}
