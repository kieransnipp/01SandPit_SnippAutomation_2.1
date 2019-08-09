package com.mytests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mypages.HomePage;
import com.mypages.LoginPage;

import junit.framework.Assert;

public class LoginTest extends BaseTest {

	//@Test(priority = 1, enabled= false)
	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println("Title is " + title);
		Assert.assertEquals("Home", title);
	}

	@Test(priority = 2)
	public void verifyLoginPageHeaderTextTest() {
		String title = page.getInstance(LoginPage.class).getPageHeaderTitle();
		System.out.println("Title is " + title);
		Assert.assertEquals("HOW IT WORKS", title);
	}

	@Test(priority = 3)
	public void doLoginTest() {
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");

		HomePage homePage = page.getInstance(LoginPage.class).doLogin(username, password);
		String header = homePage.getLoginPageTitle();
		System.out.println("Header is " + header);
		Assert.assertEquals(header, "Home");

	}

}
