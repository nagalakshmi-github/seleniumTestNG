package session9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitForNonWE_url {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		driver.findElement(By.id("input-email")).sendKeys("naveenanimation20@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		if(waitForUrlContains("route=account/account", 5)) {
			System.out.println("home page url is correct");
		}
	}
	
	public static boolean waitForUrlContains(String urlFraction, int timeOut) {
		WebDriverWait wait=new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.urlContains(urlFraction));
	}
	
	public static boolean waitForUrlToBe(String url, int timeOut) {
		WebDriverWait wait=new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.urlToBe(url));
	}
}
