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

public class RegistrationPerksPaymentPage extends TestBase {

	// Footer all pages
	@FindBy(linkText = "TERMS AND CONDITIONS")
	WebElement termsAndConditions;

	@FindBy(linkText = "PRIVACY POLICY")
	WebElement privacyPolicy;

	@FindBy(linkText = "FAQ")
	WebElement faq;

	@FindBy(linkText = "CONTACT US")
	WebElement contactUs;

	@FindBy(xpath = "//*[contains(text(), 'Submit Payment')]")
	WebElement submitPayment;

	// CARD details
	@FindBy(xpath = "//*[@placeholder='Card Number']")
	WebElement cardNumber;

	@FindBy(xpath = "//*[@data-stripe='exp_month']")
	WebElement expMonth;

	@FindBy(xpath = "//*[@placeholder='YY']")
	WebElement cardYear;

	@FindBy(xpath = "//*[@placeholder='CVC']")
	WebElement cardCVC;

	@FindBy(xpath = "//*[@class='brand-image']")
	WebElement brandLogo;

	@FindBy(xpath = "//*[contains(text(), 'Your Bavarian Inn Perks Club subscription')]")
	WebElement textBavInnSub;

	// Initializing the Page Objects: Going between pages
	public RegistrationPerksPaymentPage() {
		PageFactory.initElements(driver, this);
	}

	public DetailsPage enterCardNumberDetailsTest() {
		cardNumber.sendKeys("4242424242424242");
		expMonth.sendKeys("12");
		cardYear.sendKeys("20");
		cardCVC.sendKeys("123");
		submitPayment.click();
		return new DetailsPage();
	}

	public Boolean brandImageDisplayed() {
		return brandLogo.isDisplayed();
	}

	public String verifyPageTitle() {
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
