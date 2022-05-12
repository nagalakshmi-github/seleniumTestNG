package session3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BackAndForwardButtonSimulation {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.google.com");
		System.out.println("Page title is : " + driver.getTitle());

		driver.navigate().to("https://www.amazon.in");
		System.out.println("Page title is : " + driver.getTitle());

		driver.navigate().back();
		System.out.println("Page title is : " + driver.getTitle());

		driver.navigate().forward();
		System.out.println("Page title is : " + driver.getTitle());

		driver.close();
	}
}
