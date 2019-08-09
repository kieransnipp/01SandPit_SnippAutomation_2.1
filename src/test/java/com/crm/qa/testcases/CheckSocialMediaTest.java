//This test mappes to the objects defined in the 'LocationsPage'

package com.crm.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.codeborne.selenide.commands.Matches;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.FacebookPage;
import com.crm.qa.pages.LocationsPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.RegisterPage;
import com.crm.qa.pages.RegistrationPerksPaymentPage;
import com.crm.qa.util.TestUtil;

public class CheckSocialMediaTest extends TestBase {
	LoginPage loginPage;
	DetailsPage detailsPage;
	LocationsPage locationsPage;
	FacebookPage facebookPage;

	public CheckSocialMediaTest() {
		super();
	}

	@BeforeMethod
	//@BeforeClass
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();

		// Landing page
		detailsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

		TestUtil.runTimeInfo("error", "login successful");
		// testUtil.switchToFrame();
		locationsPage = detailsPage.clickOnLocationsPage();
	}

	@Test(priority = 4)
	public void checkFacebook() throws InterruptedException {
		System.out.println("Checking Facebook");
		locationsPage.checksocialMFacebook();
		Thread.sleep(1000);
		String title = locationsPage.verifyLocationsPageTitle();
		Assert.assertTrue(title.contains("Bavarian Inn"));
		driver.navigate().back();
	}

	@Test(priority = 6)
	public void checkYoutube() throws InterruptedException {
		System.out.println("Checking Youtube");
		locationsPage.checksocialMYoutube();
		Thread.sleep(1000);
		String homeTitle = driver.getTitle();
		Assert.assertTrue(homeTitle.contains("Bavarian Inn"));

		driver.navigate().back();
	}

	@Test(priority = 7)
	public void checkTripAdvisor() throws InterruptedException {
		System.out.println("Checking Trip Advisor");
		locationsPage.checksocialMTripAdvisor();
		Thread.sleep(1000);
		String homeTitle = driver.getTitle();
		Assert.assertTrue(homeTitle.contains("Bavarian Inn"));

		driver.navigate().back();
	}

//
	@Test(priority = 8)
	public void checkTwitter() throws IOException, InterruptedException {
		System.out.println("Checking Twitter");
		locationsPage.checksocialMTwitter();
		Thread.sleep(1000);
		String homeTitle = driver.getTitle();
		Assert.assertTrue(homeTitle.contains("Bavarian Inn"));
		driver.navigate().back();

	}

	@Test(priority = 9)
	public void checkYelp() throws IOException, InterruptedException {
		System.out.println("Checking Yelp");
		locationsPage.checksocialMYelp();
		Thread.sleep(1000);

		String homeTitle = driver.getTitle();
		Assert.assertTrue(homeTitle.contains("Bavarian Inn"));
		driver.navigate().back();
	}

	//@AfterClass
	@AfterMethod
	public void tearDown() {
		System.out.println("TearDown");
		// driver.quit();

	}

}
