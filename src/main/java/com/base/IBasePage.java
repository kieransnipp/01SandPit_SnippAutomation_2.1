package com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface IBasePage {
	String getPageTitle();

	boolean isElementDisplayed(By locator);

	String getPageHeader(By locator);

	WebElement getElement(By locator);

	void waitForElementPresent(By locator);

	void waitForPageTitle(String title);
}
