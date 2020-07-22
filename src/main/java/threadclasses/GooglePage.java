package threadclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.crm.qa.base.BasePage;

public class GooglePage extends BasePage {

	// Page actions
	public void googleSearch() {
		System.out.println("Starting google search...");
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("King unique");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

		System.out.println("Output is...");
		driver.findElements(By.xpath("//h3")).stream()
		.forEach(ele -> System.out.println("Search results are = "+ele.getText()));
	}

	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
