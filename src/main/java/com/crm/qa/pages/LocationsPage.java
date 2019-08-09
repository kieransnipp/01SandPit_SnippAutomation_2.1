package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LocationsPage extends TestBase{

	@FindBy(xpath = "//a[contains(text(),'Yelp')]")
	WebElement socialMYelp;
	
	@FindBy(xpath = "//a[contains(text(),'Face')]")
	WebElement socialMFacebook;
	
//	@FindBy(xpath = "//a[contains(text(),'Face')]")
//	WebElement socialMFacebook;

	@FindBy(xpath = "//a[contains(text(),'Youtube')]")
	WebElement socialMYoutube;

	@FindBy(xpath = "//a[contains(text(),'Trip Advisor')]")
	WebElement socialMTripAdvisor;

	@FindBy(xpath = "//a[contains(text(),'Twitter')]")
	WebElement socialMTwitter;
	
	// Footer all pages
	@FindBy(linkText = "TERMS AND CONDITIONS")
	WebElement termsAndConditions;

	@FindBy(linkText = "PRIVACY POLICY")
	WebElement privacyPolicy;

	@FindBy(linkText = "FAQ")
	WebElement faq;

	@FindBy(linkText = "CONTACT US")
	WebElement contactUs;
	
	@FindBy(xpath = "//*[contains(text(), 'Bavarian Inn Lodge')]")
	WebElement textBavInnLodge;
	
	@FindBy(xpath = "//*[contains(text(), 'Main Street Shops')]")
	WebElement textMainStreetShops;
	
	@FindBy(xpath = "//*[@class='brand-image']")
	WebElement brandLogo;
	
	 //Initializing the Page Objects: Going between pages
	public LocationsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public Boolean brandImageDisplayed() {
		return brandLogo.isDisplayed();
	}
	
	public String verifyLocationsPageTitle() {
		return driver.getTitle();
	}
	
	
	//Return text displayed
	public boolean textBavInnLodge() { // All pages
		return textBavInnLodge.isDisplayed();
	}
	
	public boolean textMainStreetShops() { // All pages
		return textMainStreetShops.isDisplayed();
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
	
	// social media checking
	public FacebookPage checksocialMFacebook() {
		socialMFacebook.click();
		return new FacebookPage();
	}

	public void checksocialMYoutube() {
		socialMYoutube.click();
	}

	public void checksocialMTripAdvisor() {
		socialMTripAdvisor.click();
	}
	
	public void checksocialMYelp() {
		socialMYelp.click();
		//return new YelpPage();
	}
	public void checksocialMTwitter() {
		socialMTripAdvisor.click();
	}


	
}
