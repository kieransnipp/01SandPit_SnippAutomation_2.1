package demo;

import java.util.Map;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GeoLocator {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		Map<String, Object> locationMap = new HashMap<String, Object>();
		
		//LA
		locationMap.put("latitude", 34.052235);
		locationMap.put("longitude", -118.243683);
		locationMap.put("accuracy", 1);
		
		
		System.out.println("Output");

	}

}
