package session6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchHandle_WithOutLoop_Assgn {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.google.in");

		driver.findElement(By.name("q")).sendKeys("Naveen Automation Labs");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class='wM6W7d']//b[text()=' course']")).click();
	}
}
