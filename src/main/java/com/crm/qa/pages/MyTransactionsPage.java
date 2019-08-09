package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class MyTransactionsPage extends TestBase {


	@FindBy(xpath = "//*[@class='brand-image']")
	WebElement brandLogo;

	@FindBy(xpath = "//*[@class='pge-logo transaction-heading']")
	WebElement pge_logo;
	
	@FindBy(xpath = "//*[@class='list-unstyled list-inline footer-links']")
	WebElement socialMediaDisplayed;
	
	// Footer all pages
	@FindBy(linkText = "TERMS AND CONDITIONS")
	WebElement termsAndConditions;

	@FindBy(linkText = "PRIVACY POLICY")
	WebElement privacyPolicy;

	@FindBy(linkText = "FAQ")
	WebElement faq;

	@FindBy(linkText = "CONTACT US")
	WebElement contactUs;
	
	//@FindBy(text ='TRANSACTION HISTORY')
	@FindBy(xpath = "//*[contains(text(), '72 HOURS')]")
	WebElement text72HOURS ;
	
	
	// Initializing the Page Objects:  Important!!!!
	public MyTransactionsPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyDetailsPageTitle() {
		return driver.getTitle();
	}

	public boolean brandLogoDisplayed() {
		return brandLogo.isDisplayed();
	}

	public boolean brandMembersLogoDisplayed() {
		return pge_logo.isDisplayed();
	}

	public boolean isDisplayedtext72HOURS() {
		return text72HOURS.isDisplayed();
	}

	//Footer
	public boolean socialMediaDisplayed() {
		return socialMediaDisplayed.isDisplayed();
		
	}
	
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
