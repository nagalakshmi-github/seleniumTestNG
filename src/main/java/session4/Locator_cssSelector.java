package session4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locator_cssSelector {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/register");

		By firstName = By.cssSelector("#input-firstname");

		ElementUtil ele = new ElementUtil(driver);
		ele.doSendKeys(firstName, "lakshmi");
	}
}
