//This test implements RetryAnalyzer

package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	DetailsPage detailsPage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	// @BeforeClass
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	// Implementing retry
//	@Test(priority = 1, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		AssertJUnit.assertEquals(title, "Home");
	}

	@Test(priority = 2)
	public void crmLogoImageTest() {
		boolean flag = loginPage.validateBAVImage();
		AssertJUnit.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() {
		detailsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	// @AfterClass
	public void tearDown() {
		System.out.println("TearDown");
		driver.quit();

	}

}
