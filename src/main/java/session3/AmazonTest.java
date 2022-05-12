package session3;

import org.openqa.selenium.WebDriver;

public class AmazonTest {

	public static void main(String[] args) {
		String browserName = "test";//"Chrome";
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.initDriver(browserName);
		br.launchUrl("https://www.amazon.in");
		String title = br.doGetTitle();
		System.out.println("title is: " + title);
		br.closeBrowser();
	}
}
