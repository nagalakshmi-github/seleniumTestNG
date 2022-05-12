package session14;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LazyLoading_pininterest {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://www.pinterest.com");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		String emailId = "nagalakshmi.sada@gmail.com";
		String password = "pinterestpwd@123";

		driver.findElement(By.xpath("//div[text()='Log in']")).click();
		driver.findElement(By.id("email")).sendKeys(emailId);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("(//div[text()='Log in'])[2]")).click();

		if (!driver.findElement(By.xpath("//span[text()='Home']")).isDisplayed()) {
			System.out.println("Home Page is not displayed");
		}

		By elementLocator = By.xpath("//img[@loading='auto']");

		// Calling the locateElement method, to fetch all element
		locateElement(elementLocator);
	}

	public static void locateElement(By elementLocator) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Initial element count
		int elementCount = driver.findElements(elementLocator).size();

		while (true) {
			// javascriptexecutor to scroll the page
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		//	wait.ignoring(NoSuchElementException.class)
		//			.until(ExpectedConditions.invisibilityOfElementLocated(elementLocator));

			// Wait to load the new elements
			Thread.sleep(2000);

			// Check if the last fetch element count is same as new count,
			// It is's same then we already have fetch all the elements on the page.
			if (driver.findElements(elementLocator).size() == elementCount)
				break;

			// fetch the lattest elements count
			elementCount = driver.findElements(elementLocator).size();
		}
	}
}
