package session3.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");

		// create the web element + perform the action(click, sendKeys,
		// getText,isdisplayed)

		// create the web element: using 8 locators:
		// driver.findElement(By.)
	}

}
