package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import com.crm.qa.base.TestBase;
import com.mypages.HomePage;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;

public class DetailsPage extends TestBase {

	// Social Media links
	
//	@FindBy(xpath = "//a[contains(text(),'Yelp')]")
//	WebElement socialMYelp;
//	
//	//@FindBy(xpath = "//a[contains(text(),'Face')]")
//	@FindBy(how=How.XPATH, using="//a[contains(text(),'Face')]") 
//	WebElement socialMFacebook;
//	
////	@FindBy(xpath = "//a[contains(text(),'Face')]")
////	WebElement socialMFacebook;
//
//	@FindBy(xpath = "//a[contains(text(),'Youtube')]")
//	WebElement socialMYoutube;
//
//	@FindBy(xpath = "//a[contains(text(),'Trip Advisor')]")
//	WebElement socialMTripAdvisor;
//
//	@FindBy(xpath = "//a[contains(text(),'Twitter')]")
//	WebElement socialMTwitter;

	// Pages in the application
	@FindBy(xpath = "//a[contains(text(),'Upload Receipt')]")
	WebElement upLoadReciept;

	@FindBy(xpath = "//a[contains(text(),'Offers')]")
	WebElement offers;

	@FindBy(xpath = "//a[contains(text(),'Locations')]")
	WebElement locations;

	@FindBy(xpath = "//a[contains(text(),'Social')]")
	WebElement social;

	// Footer all pages
	@FindBy(linkText = "TERMS AND CONDITIONS")
	WebElement termsAndConditions;

	@FindBy(linkText = "PRIVACY POLICY")
	WebElement privacyPolicy;

	@FindBy(linkText = "FAQ")
	WebElement faq;

	@FindBy(linkText = "CONTACT US")
	WebElement contactUs;

	// Declare here - Step 1
	@FindBy(xpath = "//*[contains(text(), 'Michael')]")
	WebElement welcome;

	@FindBy(xpath = "//input[@id='emailReferralInput']")
	WebElement referFriend;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement submitEmail;

	@FindBy(xpath = "//*[@id='toast-container']/div/div/div/div")
	WebElement toastEmailExists;

	@FindBy(xpath = "//*[@class='list-unstyled list-inline footer-links']")
	WebElement socialMediaDisplayed;

	@FindBy(xpath = "//*[contains(text(), 'My Profile') and @class='dropdown-toggle']")
	WebElement clickProfile;

	@FindBy(xpath = "//*[@id='logged-in-dropdown']/li/ul/li[1]/a")
	WebElement clickMyProfile;

	@FindBy(xpath = "//*[@id='logged-in-dropdown']/li/ul/li[2]/a")
	WebElement clickProfileBalance;

	@FindBy(xpath = "//*[@id='logged-in-dropdown']/li/ul/li[3]/a")
	WebElement clickProfileTransactions;

	//@FindBy(xpath = "//*[@id='logged-in-dropdown']/li/ul/li[4]/a")
	//WebElement clicklogout;
	
	@FindBy(xpath ="//ul[contains(@class,'dropdown-menu')]//li//a")
	List <WebElement> myProfilelist;
	

	// Initializing the Page Objects:
	// Going between pages
	public DetailsPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyPageTitle() {
		return driver.getTitle();
	}

	// Page tabs at the top
	public UploadRecieptPage clickOnUploadReciept() {
		upLoadReciept.click();
		return new UploadRecieptPage();
	}

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
		//driver.get("https://bavarianinn.snipp.ie/home/member/details/profile#");
		
		for (int i = 0; i < myProfilelist.size(); i++) {
			System.out.println(myProfilelist.get(i).getText());
			if(myProfilelist.get(i).getText().contains("MY PROFILE")) {
				myProfilelist.get(i).click();
			}
		}
		return new MyProfilePage();
	}

	public CheckBalancePage clickOnCheckBalance() throws InterruptedException {
		
		clickProfile.click();
		//List <WebElement> myProfilelist = driver.findElements(By.xpath("//ul[contains(@class,'dropdown-menu')]//li//a"));
		System.out.println("List size is = "+myProfilelist.size());
		
		for (int i = 0; i < myProfilelist.size(); i++) {
			System.out.println(myProfilelist.get(i).getText());
			if(myProfilelist.get(i).getText().contains("CHECK BALANCE")) {
				myProfilelist.get(i).click();
			}
		}

		return new CheckBalancePage();
	}

	public MyTransactionsPage clickOnMyTransactions() throws InterruptedException {
		clickProfile.click();
		
System.out.println("List size is = "+myProfilelist.size());
		
		for (int i = 0; i < myProfilelist.size(); i++) {
			System.out.println(myProfilelist.get(i).getText());
			if(myProfilelist.get(i).getText().contains("MY TRANSACTIONS")) {
				myProfilelist.get(i).click();
			}
		}
		//clickProfileTransactions.click();

		return new MyTransactionsPage();
	}

	// Declare here - Step 2
	public boolean verifyCorrectUserName() {
		return welcome.isDisplayed();
	}

	public boolean enterFriendsEmail(String email) throws InterruptedException {
		referFriend.sendKeys(email);
		submitEmail.click();
		Thread.sleep(2000);
		return toastEmailExists.isDisplayed();
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

	public HowItWorksHomePage logOutOfApplication() {
		
		for (int i = 0; i < myProfilelist.size(); i++) {
			System.out.println(myProfilelist.get(i).getText());
			if(myProfilelist.get(i).getText().contains("LOG OUT")) {
				myProfilelist.get(i).click();
			}
			
		}
		return new HowItWorksHomePage();
	}

}
