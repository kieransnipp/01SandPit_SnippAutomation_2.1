//No Social test??????????????

package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class SocialPage extends TestBase{

	
	//Top of the page
	@FindBy(xpath = "//*[@class='pge-logo']")
	WebElement perksClubImage;
	
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
	
	//
	@FindBy(xpath ="//*[contains(text(), 'Follow us on Twitter')]")
	WebElement twitterIsDisplayed;
	
	@FindBy(xpath ="//*[contains(text(), 'Refer a Friend')]")
	WebElement referTextDisplayed;
	
	@FindBy(xpath = "//input[@id='emailReferralInput']")
	WebElement referFriend;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submitEmail;
	
	@FindBy(xpath ="//*[@id='toast-container']/div/div/div/div")
	WebElement toastEmailExists;
	
	public Boolean imageIsDisplayed() {
		return perksClubImage.isDisplayed();
	}
	
	
	// Initializing the Page Objects: Going between pages
	public SocialPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean enterFriendsEmail(String email) {
		referFriend.sendKeys(email);
		//driver.
		submitEmail.click();
		return toastEmailExists.isDisplayed();
	}
	
	
	public Boolean referTextDisplayed() {
		return referTextDisplayed.isDisplayed();
	}
	
	public Boolean twitterIsDisplayed() {
		return twitterIsDisplayed.isDisplayed();
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
