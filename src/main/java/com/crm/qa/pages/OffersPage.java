package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class OffersPage extends TestBase {

	// Pages to cycle through
	@FindBy(xpath = "//a[contains(text(),'Upload Receipt')]")
	WebElement upLoadReciept;

	@FindBy(xpath = "//a[contains(text(),'Offers')]")
	WebElement offers;

	@FindBy(xpath = "//a[contains(text(),'Locations')]")
	WebElement locations;

	@FindBy(xpath = "//a[contains(text(),'Social')]")
	WebElement social;

	@FindBy(xpath = "//a[contains(text(),'My Profile ')]")
	WebElement myProfile;

	@FindBy(xpath = "//*[@class='brand-image']")
	WebElement brandLogo;

	@FindBy(xpath = "//*[@class='pge-logo']")
	WebElement pge_logo;

	@FindBy(xpath = "//*[contains(text(), 'Your continued patronage of our facilitie')]")
	WebElement textPatronageDisplayed;
	
	@FindBy(xpath = "//*[@class='list-unstyled list-inline footer-links']")
	WebElement socialMediaDisplayed;
	

	// Initializing the Page Objects:  Important!!!!
	public OffersPage() {
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

	public boolean textIsDisplayed() {
		return textPatronageDisplayed.isDisplayed();
	}

	// Pages
	public OffersPage clickOnOffersPage() {
		offers.click();
		return new OffersPage();
	}

	public LocationsPage clickOnLocationsPage() {
		locations.click();
		return new LocationsPage();
	}

	public SocialPage clickOnSocialPage() {
		social.click();
		return new SocialPage();
	}

	public MyProfilePage clickOnMyProfilePage() {
		myProfile.click();
		return new MyProfilePage();
	}

	public boolean socialMediaDisplayed() {
		return socialMediaDisplayed.isDisplayed();
		
	}

}
