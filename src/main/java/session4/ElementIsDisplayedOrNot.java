package session4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementIsDisplayedOrNot {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/register");

		ElementUtil ele = new ElementUtil(driver);
		
		/*
		 * By firstName= By.id("input-firstname"); By LoginLink= By.linkText("Login");
		 * 
		 * boolean flagFname=ele.doIsDisplayed(firstName);
		 * System.out.println(flagFname);
		 * 
		 * boolean flagLogin=ele.doIsDisplayed(LoginLink);
		 * System.out.println(flagLogin);
		 */
		
		By customerGroupLabelDisplayNone= By.xpath("//*[text()='Customer Group']");
		System.out.println("Customer Group Label isDisplayed() = "+ele.doIsDisplayed(customerGroupLabelDisplayNone));
		
		//System.out.println(driver.findElement(By.id("input-firstname1")).isDisplayed());
	}
}
