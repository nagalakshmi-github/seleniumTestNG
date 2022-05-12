package session2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		// We can also use older driver versions
		// WebDriverManager.chromedriver().driverVersion("81.0.4044.138").setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");

		String title = driver.getTitle();
		System.out.println("Page title is : " + title);

		if (title.equals("Google")) {
			System.out.println("correct title");
		} else {
			System.out.println("incorrect title");
		}
		driver.quit();
	}
}
