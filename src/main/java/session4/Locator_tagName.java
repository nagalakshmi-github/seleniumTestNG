package session4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locator_tagName {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/register");
		
		ElementUtil ele = new ElementUtil(driver);
		
		By header = By.tagName("h1");
		String h1Text = ele.doGetText(header);
		System.out.println(h1Text);
	}

}
