package com.crm.qa.pages;

import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.crm.qa.testdata.RegisterDataCanada;

import io.codearte.jfairy.producer.person.Address;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.person.PersonProperties;

public class RegisterPage extends TestBase {

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

	@FindBy(xpath = "//*[contains(text(), 'River Place Shops')]")
	WebElement textRiverPlaceShops;

	@FindBy(xpath = "//*[@class='brand-image']")
	WebElement brandLogo;

	// Input Elements
	@FindBy(xpath = "//*[@name='FirstName']")
	WebElement firstName;

	@FindBy(xpath = "//*[@placeholder='Last name *']")
	WebElement lastName;

	@FindBy(xpath = "//*[@placeholder='Email *']")
	WebElement eMail;

	@FindBy(xpath = "//*[@placeholder='Password *']")
	WebElement passWord;

	@FindBy(xpath = "//*[@placeholder='Confirm password *']")
	WebElement confirmPassword;

	@FindBy(xpath = "//*[@name='DateOfBirth']")
	WebElement dateOfBirth;

	@FindBy(xpath = "//*[@placeholder='Mobile phone *']")
	WebElement mobilePhone;

	@FindBy(xpath = "//*[@name='Phone']")
	WebElement phoneNumber;

	@FindBy(xpath = "//*[@name='ReferralInfo']")
	WebElement referralInfo;

	@FindBy(xpath = "//*[@name='AddressLine1']")
	WebElement addressLine1;

	@FindBy(xpath = "//*[@name='AddressLine2']")
	WebElement addressLine2;

	@FindBy(xpath = "//*[@name='City']")
	WebElement city;

	@FindBy(xpath = "//*[@class='control__indicator']")
	WebElement controlIndicator;

	@FindBy(xpath = "//*[@name='Zip']")
	WebElement zip;

	@FindBy(xpath = "//*[@type='submit']")
	public WebElement btnSubmit;

	@FindBy(xpath = "//*[@name='RequestPerksCard']")
	WebElement requestPerksCard;

	@FindBy(xpath = "//*[@name='Country']")
	WebElement country;

	@FindBy(xpath = "//*[@id='States']")
	WebElement state;

	// Initializing the Page Objects: Going between pages
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	public void selectState() {
		// Select state = new Select(driver.findElement(By.xpath("//*[@id='States']")));
		Select statex = new Select(state);
		//statex.deselectByIndex(3);
		statex.selectByVisibleText("Yukon");
	}

	public void selectCountryCanada() {
		Select select = new Select(country);
		select.selectByVisibleText("Canada");
	}

	public void selectCountryAmerica() {
		Select select = new Select(country);
		select.selectByVisibleText("United States");
	}

	public RegistrationPerksPaymentPage registerNewUserTest() throws Exception  {
		selectCountryAmerica();

		int phoneNumb = Integer.valueOf(RegisterDataCanada.mobilePhoneNum());
		firstName.sendKeys(RegisterDataCanada.firstName());

		phoneNumber.sendKeys("405" + phoneNumb);
		selectCountryCanada();
		
		lastName.sendKeys(RegisterDataCanada.lastName());
		eMail.sendKeys(RegisterDataCanada.getEmail());
		
		passWord.sendKeys("test1234");
		confirmPassword.sendKeys("test1234");
		dateOfBirth.sendKeys("01/01/2000");

		Thread.sleep(2000);
		selectState();
		mobilePhone.sendKeys("405" + phoneNumb);
		referralInfo.sendKeys("Cork");
		addressLine1.sendKeys(RegisterDataCanada.getAddressLine1());
		addressLine2.sendKeys(RegisterDataCanada.getAddressLine2());
		city.sendKeys(RegisterDataCanada.city());

		lastName.sendKeys(RegisterDataCanada.lastName());
		selectPerks();
		zip.sendKeys("V5Y1V4");
		Thread.sleep(1000);
		controlIndicator.click();
		btnSubmit.click();

		return new RegistrationPerksPaymentPage();

	}

//	private RegistrationPerksPaymentPage RegistrationPerksPaymentPage() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public void selectPerks() {
		Select cardOption = new Select(requestPerksCard);
		cardOption.selectByIndex(3);
	}

	public Boolean brandImageDisplayed() {
		return brandLogo.isDisplayed();
	}

	public String verifyPageTitle() {
		return driver.getTitle();
	}

	// Return text displayed
	public boolean textBavInnLodge() { // All pages
		return textBavInnLodge.isDisplayed();
	}

	public boolean textRiverPlaceShops() { // All pages
		return textRiverPlaceShops.isDisplayed();
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
