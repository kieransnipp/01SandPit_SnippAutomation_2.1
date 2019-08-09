package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HowItWorksHomePage extends TestBase{

	// Footer all pages
	@FindBy(linkText = "TERMS AND CONDITIONS")
	WebElement termsAndConditions;

	@FindBy(linkText = "PRIVACY POLICY")
	WebElement privacyPolicy;

	@FindBy(linkText = "FAQ")
	WebElement faq;

	@FindBy(linkText = "CONTACT US")
	WebElement contactUs;
	
	@FindBy(xpath = "//*[contains(text(), 'have a Loyalty card?')]")
	WebElement textLoyaltyCard;
	
	@FindBy(xpath = "//*[contains(text(), 'Earn & Redeem Rewards')]")
	WebElement textEarnAndRedeem;
	
	@FindBy(xpath = "//*[@class='brand-image']")
	WebElement brandLogo;
	
	 //Initializing the Page Objects: Going between pages
	public HowItWorksHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public Boolean brandImageDisplayed() {
		return brandLogo.isDisplayed();
	}
	
	public String verifyPageTitle() {
		return driver.getTitle();
	}
	
	
	//Return text displayed
	public boolean textLoyaltyCard() { // All pages
		return textLoyaltyCard.isDisplayed();
	}
	
	public boolean textEarnAndRedeem() { // All pages
		return textEarnAndRedeem.isDisplayed();
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
