package session2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\DKLM\\Learnings\\Laxmi learnings\\Laxmi_software_downloads\\selenium_req_installables\\browsers\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();//suppose session ID=123 here
		driver.get("http://www.google.com"); // enter the url
		String title = driver.getTitle();
		System.out.println(title);
		System.out.println(driver.getCurrentUrl());
		//driver.close();
		driver.quit();
		//Initialize driver with chrome driver again and launch the url
		//but the session id generated is not same as above
		driver=new ChromeDriver();//say session ID=456 here
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
	}
}
