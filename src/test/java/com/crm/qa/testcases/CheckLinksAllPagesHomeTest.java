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
import com.crm.qa.pages.FAQ_Page;
import com.crm.qa.pages.HowItWorksHomePage;
import com.crm.qa.pages.LocationsPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MyProfilePage;
import com.crm.qa.pages.MyTransactionsPage;
import com.crm.qa.pages.OffersPage;
import com.crm.qa.pages.RegisterPage;
import com.crm.qa.pages.SocialPage;
import com.crm.qa.pages.UploadRecieptPage;
import com.crm.qa.util.TestUtil;

public class CheckLinksAllPagesHomeTest extends TestBase {
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
	HowItWorksHomePage howItWorksPage;
	RegisterPage registerPage; 
	FAQ_Page faqPage;


	public CheckLinksAllPagesHomeTest() {
		super();
	}

	@BeforeMethod
	// @BeforeClass
	public void setUp() throws InterruptedException {
		try {
			initialization();
			testUtil = new TestUtil();
			loginPage = new LoginPage();
			faqPage = new FAQ_Page();
			
			TestUtil.runTimeInfo("error", "login successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1) // Working
	public void checkLinksHowItWorks() throws InterruptedException {
		howItWorksPage = loginPage.clickOnHowInWorks();
		String homePageTitle = howItWorksPage.verifyPageTitle();
		System.out.println("Page is =" + homePageTitle);

		Assert.assertEquals(homePageTitle, "Home");
		Thread.sleep(3000);
		Assert.assertTrue(howItWorksPage.assertContactUs());
		Boolean checkedOk = checkLinks();
		assertTrue(checkedOk);

	}

	@Test(priority = 2) // Working
	public void checkLinksRegister() throws InterruptedException {
		registerPage = loginPage.clickOnRegister();
		String homePageTitle = registerPage.verifyPageTitle();
		System.out.println("Page is =" + homePageTitle);

		Assert.assertEquals(homePageTitle, "Register");
		Thread.sleep(3000);
		Assert.assertTrue(registerPage.assertContactUs());
		Boolean checkedOk = checkLinks();
		assertTrue(checkedOk);

	}

	@Test(priority = 3) // Working
	public void checkLinksFAQ() throws InterruptedException {
		faqPage = loginPage.clickOnFAQ();
		String homePageTitle = faqPage.verifyLocationsPageTitle();
		System.out.println("Page is =" + homePageTitle);

		Assert.assertEquals(homePageTitle, "FAQ");
		Thread.sleep(3000);
		Assert.assertTrue(faqPage.assertContactUs());
		Boolean checkedOk = checkLinks();
		assertTrue(checkedOk);

	}
	@AfterMethod
	// @AfterClass
	public void tearDown() {
		driver.quit();
	}

}
