package demo;

import java.util.Map;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeoLocator {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		Map<String, Object> locationMap = new HashMap<String, Object>();

		// LA
		// locationMap.put("latitude", 34.052235);
		// locationMap.put("longitude", -118.243683);
		// locationMap.put("accuracy", 1);

		// Dublin
		// locationMap.put("latitude", 53.349804);
		// locationMap.put("longitude", -6.260310);
		// locationMap.put("accuracy", 1);

		// Tokyo
		locationMap.put("latitude", 35.6804);
		locationMap.put("longitude", 139.7690);
		locationMap.put("accuracy", 1);

		((ChromeDriver) driver).executeCdpCommand("Emulation.setGeolocationOverride", locationMap);

		System.out.println("Launch site");

		// Sites
		driver.get("https://www.starbucks.ie/store-locator");
		// driver.get("https://oldnavy.gap.com/stores"); //US locations
		// driver.get("https://www.gap.com/stores"); //US locations
		// driver.get(" https://www.google.com/search?q=my+location");

		System.out.println("Output");

	}

}
