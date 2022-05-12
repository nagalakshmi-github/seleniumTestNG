package session14;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");

		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("no.of links are :" + links.size());//373

		List<String> urlsList = new ArrayList<String>();
		for (WebElement we : links) {
			String url = we.getAttribute("href");
			urlsList.add(url);
		}

		long startTime = System.currentTimeMillis();
		// urlsList.stream().forEach(e->checkForBrokenLinks(e));
		// total time taken to check for broken links is:405077msec = 405sec //373 links
		urlsList.parallelStream().forEach(e->checkForBrokenLinks(e));
		//total time taken to check for broken links is:127036 =127sec //366 links
		long endTime = System.currentTimeMillis();
		System.out.println("total time taken to check for broken links is:" + (endTime - startTime));

		driver.quit();

	}

	public static void checkForBrokenLinks(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.connect();
			//if code >=400 ...its a bad request
			if (httpURLConnection.getResponseCode() >= 400) {
				System.out.println(linkUrl + " -----> " + httpURLConnection.getResponseMessage() + " is a broken link");
			} else {
				System.out.println(linkUrl + " -----> " + httpURLConnection.getResponseMessage());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
