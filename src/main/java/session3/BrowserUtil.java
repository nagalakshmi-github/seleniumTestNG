package session3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	// SRP: Single Responsibility Pattern : Every class is reponsible for its own
	// functionality and
	// there should be only be one reason to change the code in this class
	public WebDriver driver;

	/**
	 * This method is used to initialize the driver based on browser name
	 * 
	 * @param browserName
	 * @return This will return the Driver
	 */
	public WebDriver initDriver(String browserName) {
		System.out.println("browser name : " + browserName);

		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("Please pass the right browser : " + browserName);
			break;
		}
		return driver;
	}

	/**
	 * this method is used to launch the url
	 * 
	 * @param url
	 */
	public void launchUrl(String url) {
		if (url.isEmpty()) {
			System.out.println("url is blank or empty");
			return;
		}

		if (url.contains("http") || url.contains("https"))
			driver.get(url);
	}

	public String doGetTitle() {
		return driver.getTitle();
	}

	public String getPageCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}
}
