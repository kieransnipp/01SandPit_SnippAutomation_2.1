package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class MyProfilePage extends TestBase {

	// Top of the page
	@FindBy(xpath = "//*[@class='pge-logo']")
	WebElement perksClubImage;
//	


	// Footer all pages
	@FindBy(linkText = "TERMS AND CONDITIONS")
	WebElement termsAndConditions;

	@FindBy(linkText = "PRIVACY POLICY")
	WebElement privacyPolicy;

	@FindBy(linkText = "FAQ")
	WebElement faq;

	@FindBy(linkText = "CONTACT US")
	WebElement contactUs;

	@FindBy(xpath = "//*[@class='brand-image']")
	WebElement brandLogo;

	//@FindBy(xpath = "//*[@id='logged-in-dropdown']/li/a")
	@FindBy(xpath ="//*[contains(text(), 'My Profile')]")
	WebElement myProfile;

	@FindBy(xpath = "//*[@id=\"logged-in-dropdown\"]/li/ul/li[1]/a")
	WebElement myProfile_myProfile;

	public Boolean imageIsDisplayed() {
		return perksClubImage.isDisplayed();
	}

	// Initializing the Page Objects: Going between pages
	public MyProfilePage() {
		PageFactory.initElements(driver, this);
	}


	public Boolean brandImageDisplayed() {
		return brandLogo.isDisplayed();
	}

	public String verifyLocationsPageTitle() {
		return driver.getTitle();
	}

	// Footer
	public boolean assertTermsAndCond() { // All pages
		return termsAndConditions.isDisplayed();
	}

	public boolean assertPrivacyPolicy() {
		return privacyPolicy.isDisplayed(); // All pages

	}

	public boolean assertFAQ() { // All pages
		return faq.isDisplayed();
	}

	public boolean assertContactUs() { // All pages
		return contactUs.isDisplayed();
	}
}
