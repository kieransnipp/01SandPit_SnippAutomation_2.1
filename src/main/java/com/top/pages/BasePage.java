package com.top.pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);

	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();

	}

	@Override
	public boolean isElementDisplayed(By locator) { // Wrapper function
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			return true;
		} catch (Exception e) {
			System.out.println("Some error occured for the element " + locator.toString());
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public WebElement getElement(By locator) { // Wrapper function

		WebElement element = null;
		try {
			waitForElementPresent(locator);
			element = driver.findElement(locator);
			return element;
		} catch (Exception e) {
			System.out.println("Some error occured for the element " + locator.toString());
			e.printStackTrace();
		}
		return element;

	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			System.out.println("Some excpeption/error occured waiting for the element " + locator.toString());
			e.printStackTrace();
		}

	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		} catch (Exception e) {
			System.out.println("Some excpeption/error occured waiting for the element " + title);
			e.printStackTrace();
		}

	}

	@Override
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		// TODO Auto-generated method stub
		return super.getInstance(pageClass);
	}

	@Override
	public String getPageURL() {
		String pageUrl = driver.getCurrentUrl();
		return pageUrl;
	}




}
