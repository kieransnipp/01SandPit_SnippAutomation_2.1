package com.mytests;

import org.testng.annotations.Test;

import com.top.pages.HomePage;
import com.top.pages.LoginPage;

import junit.framework.Assert;

public class LoginTest extends BaseTest {

	// @Test(priority = 1, enabled= false)
	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println("Title is " + title);
		Assert.assertEquals("Log On", title);
	}

	@Test(priority = 2)
	public void verifyLoginPageHeaderTextTest() {
		String title = page.getInstance(LoginPage.class).getPageHeaderTitle();
		System.out.println("Title is " + title);
		Assert.assertEquals("Login to Catalyst System.", title);
	}

	@Test(priority = 3)
	public void doLoginTest() {
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");

		HomePage homePage = page.getInstance(LoginPage.class).doLogin(username, password);
		String header = homePage.getLoginPageTitle();
		System.out.println("Header is " + header);
		Assert.assertEquals(header, "MemberSearch");

	}

}
