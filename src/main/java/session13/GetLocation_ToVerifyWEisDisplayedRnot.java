package session13;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetLocation_ToVerifyWEisDisplayedRnot {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://mrbool.com/");

		// Approach2: Using getLocation() : Point class
		Point p = driver.findElement(By.name("txtsearch")).getLocation();
		int xVal = p.x;
		int yVal = p.y;

		System.out.println(xVal + " " + yVal);
	}

	// Approach1: Using isDisplayed();
	public static List<WebElement> doGetElements(By locator) {
		return driver.findElements(locator);
	}

	public static boolean elementIsDisplayed(By locator) {
		if (doGetElements(locator).size() > 0) {
			return true;
		}
		return false;
	}
}
