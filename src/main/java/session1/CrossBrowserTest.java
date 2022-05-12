package session1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CrossBrowserTest {

	static WebDriver driver;

	public static void main(String[] args) {
		String browser = "Chrome";
		switch (browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\DKLM\\Learnings\\Laxmi learnings\\Laxmi_software_downloads\\selenium_req_installables\\browsers\\chromedriver_win32\\chromedriver.exe");

			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					"C:\\DKLM\\Learnings\\Laxmi learnings\\Laxmi_software_downloads\\selenium_req_installables\\browsers\\geckodriver-v0.30.0-win32\\geckodriver.exe");

			driver = new FirefoxDriver();
			break;
		case "safari":// safari is available only on MAC m/c but not on windows
			driver = new SafariDriver();
			break;
		default:
			System.out.println("Please pass the correct browser...");
			break;
		}

		driver.get("http://www.google.com");// enter url

		String title = driver.getTitle();// getting the page title
		System.out.println("page title is: " + title);

		if (title.equals("Google")) {
			System.out.println("correct title");
		} else {
			System.out.println("in corect title");
		}

		System.out.println(driver.getCurrentUrl());

		driver.quit();// close the browser
	}
}
