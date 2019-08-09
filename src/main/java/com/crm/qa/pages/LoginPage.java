//Working on
package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	
	@FindBy(xpath="//*[contains(text(),'How it Works')]")
	WebElement howItWorks;
	
	@FindBy(xpath="//*[contains(text(),'Register')]")
	WebElement register;
	
	@FindBy(xpath="//*[contains(text(),'FAQs')]")
	WebElement faq;
	
	@CacheLookup 
	@FindBy(name="Email")
	WebElement username;
	
	@CacheLookup 
	@FindBy(name="Password")
	WebElement password;
	
	@CacheLookup
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Forgot password?')]")
	WebElement forgotPassW;
	
	@CacheLookup
	@FindBy(xpath="//*[@class='brand-image']")
	WebElement bavLogo;
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public HowItWorksHomePage clickOnHowInWorks() {
		howItWorks.click();
		return new HowItWorksHomePage();
	}
	
	public RegisterPage clickOnRegister() {
		register.click();
		return new RegisterPage();
	}
	
	public FAQ_Page clickOnFAQ() {
		faq.click();
		return new FAQ_Page();
	}
	

	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateBAVImage(){
		return bavLogo.isDisplayed();
	}
	
	
	public DetailsPage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
		    	
		return new DetailsPage();
	}
	
}
