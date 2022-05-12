package session3.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locator_ID {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");

		// create the web element + perform the action(click, sendKeys, getText,
		// isdisplayed)
		// approach -1:
		/*
		 * driver.findElement(By.id("input-email")).sendKeys("naveen@gmail.com");
		 * driver.findElement(By.id("input-password")).sendKeys("test@123");
		 */

		// approach -2: WebElement email = driver.findElement(By.id("input-email"));
		/*
		 * WebElement password = driver.findElement(By.id("input-password"));
		 * 
		 * email.sendKeys("naveen@gmail.com"); password.sendKeys("test@123");
		 */

		// approach -3: using BY locator strategy
		/*
		 * By email1 = By.id("input-email"); By password1 = By.id("input-password");
		 * 
		 * driver.findElement(email1).sendKeys("naveen@gmail.com");
		 * driver.findElement(password1).sendKeys("test@123");
		 */

		/*
		 * // approach -4: using BY locator strategy with a generic function By email1 =
		 * By.id("input-email"); By password1 = By.id("input-password");
		 * getElement(email1).sendKeys("naveen@gmail.com");
		 * getElement(password1).sendKeys("test@123");
		 */

		// approach -5: using BY locator strategy with a generic function for sendKeys()
				By email1 = By.id("input-email");
				By password1 = By.id("input-password");
				doSendKeys(email1,"naveen@gmail.com");
				doSendKeys(password1,"test@123");
				
		// approach -6: maintain a util class and move all the functions to that class
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}
}
