package session1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxLaunch {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver",
				"C:\\DKLM\\Learnings\\Laxmi learnings\\Laxmi_software_downloads\\selenium_req_installables\\browsers\\geckodriver-v0.30.0-win32\\geckodriver.exe");

		WebDriver driver= new FirefoxDriver();
		driver.get("http://www.google.com"); // enter the url

		String title = driver.getTitle();
		System.out.println("Page title is : " + title); // prints the page title

		// verification point//check point// Act vs expected result
		if (title.equals("Google")) {
			System.out.println("correct title");
		} else {
			System.out.println("incorrect title");
		}

		// Automation testing = Automation steps + verification point

		System.out.println(driver.getCurrentUrl());
		// System.out.println(driver.getPageSource());

		// driver.quit();
		driver.close();
	}
}