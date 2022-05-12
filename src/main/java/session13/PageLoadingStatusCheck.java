package session13;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadingStatusCheck {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://mrbool.com/");
		waitForPageLoad();
	}

	public static void waitForPageLoad() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String pageLoadingStatus = jse.executeScript("return document.readyState;").toString();

		if (pageLoadingStatus.equals("complete")) {
			System.out.println("page is fully loaded");
		} else {
			for (int i = 1; i <= 20; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				pageLoadingStatus = jse.executeScript("return document.readyState;").toString();
				System.out.println("current page loading status: " +pageLoadingStatus);
				if(pageLoadingStatus.equals("complete")) {
					break;
				}
			}
		}
	}
}
