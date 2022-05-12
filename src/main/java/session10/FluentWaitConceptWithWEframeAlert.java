package session10;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConceptWithWEframeAlert {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");

		By emailId = By.id("input-email111");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");

		//waitForElementTobePresentWithFluentWait(emailId, 10, 2).sendKeys("test@gmail.com");

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
			.withMessage(Error.TIME_OUT_WEB_ELEMENT_MSG)
			.pollingEvery(Duration.ofMillis(2))
			.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);

		wait.until(ExpectedConditions.presenceOfElementLocated(emailId));
	}

	public static WebElement waitForElementTobePresentWithFluentWait(By locator, int timeOut, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.withMessage(Error.TIME_OUT_WEB_ELEMENT_MSG).pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static WebDriver waitForFrameWithFluentWait(By frameLocator, int timeOut, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.withMessage(Error.TIME_OUT_FRAME_ELEMENT_MSG).pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);

		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	public static Alert waitForAlertWithFluentWait(int timeOut, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.withMessage(Error.TIME_OUT_ALERT_MSG).pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);

		return wait.until(ExpectedConditions.alertIsPresent());
	}
}
