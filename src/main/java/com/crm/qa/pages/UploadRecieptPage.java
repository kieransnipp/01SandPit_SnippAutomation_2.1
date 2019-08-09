package com.crm.qa.pages;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class UploadRecieptPage extends TestBase {

	// Top of the page
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

	@FindBy(xpath = "//*[contains(text(), 'Upload Receipt')]")
	WebElement uploadRecieptPage;

	@FindBy(xpath = "//input[@type='file']")
	WebElement uploadElement;

	@FindBy(xpath = "//*[contains(text(), 'Submit')]")
	WebElement btnSubmit;

	@FindBy(xpath = "//*[@id=\"receiptPage\"]/div/div/div[4]/div/div/div/div/div/div/table/tbody/tr[1]/td[1]/span")
	WebElement timeUploaded;

	@FindBy(xpath = "//*[@id=\"receiptPage\"]/div/div/div[4]/div/div/div/div/div/div/table/tbody/tr[1]/td[2]/span[1]")
	WebElement queuedIsDisplayed;

	// Initializing the Page Objects: Going between pages
	public UploadRecieptPage() {
		PageFactory.initElements(driver, this);
	}

	public Boolean imageIsDisplayed() {
		return perksClubImage.isDisplayed();
	}

	public Boolean brandImageDisplayed() {
		return brandLogo.isDisplayed();
	}

	public String verifyUploadRecieptPageTitle() {
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

	public void uploadButtonSelection() throws InterruptedException {
		String userDir = System.getProperty("user.dir");
		System.out.println("Select the Choose files button");

		uploadElement.sendKeys(userDir + "/src/testfiles/demo.jpg");

		String pageSource = driver.getPageSource();
		System.out.println("pageSource is" + pageSource);
		btnSubmit.click();
		// Assert.assertTrue(pageSource.contains("demo.jpg"));

		System.out.println("File is submitted");

	}

	public void verifyUploadWorked() throws InterruptedException {

		Thread.sleep(10000);
		String timeStamp = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
		System.out.println("The date is " + timeStamp);
		System.out.println("Refresh page here ");
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String timeUpload = timeUploaded.getText();

		Assert.assertTrue(timeUpload.contains(timeStamp));
		System.out.println("Upload is working today " + timeUploaded);

	}

	public void verifyUploadQUEUEDStatusTest() throws InterruptedException {

		String queuedIsDisp = queuedIsDisplayed.getText().toString();
		System.out.println("String to check is " + queuedIsDisp);
		Assert.assertTrue(queuedIsDisp.contentEquals("QUEUED"));

		System.out.println("Upload for today is status = " + queuedIsDisp);

	}
	
	public void viewtheUploadedReciept() throws InterruptedException {
		System.out.println("Switch to the alert");
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		String pageSourcePopUp = driver.getPageSource();
		System.out.println("Pop up source is = " + pageSourcePopUp);

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		assertTrue(pageSourcePopUp
				.contains("Your receipt is queued for processing, this area will be updated once it gets processed"));
		Thread.sleep(1000);
		System.out.println("Reciept upload confirmed");
	

	} // End viewReciept

}
