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

public class BrokenLinksAndImages {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.freecrm.com");

		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		driver.switchTo().frame("mainpanel");

		// 1.get the list of all the links and images
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		linksList.addAll(driver.findElements(By.tagName("img")));
		System.out.println("size of active links and images: "+linksList.size());
		
		List<String> activeLinksList = new ArrayList<String>();

		// 2.iterate linksList; exclude all links or images which doesnot have any href
		// attribute
		for (int i = 0; i < linksList.size(); i++) {
			String linkTxt = linksList.get(i).getAttribute("href");
			if (linkTxt != null && !(linkTxt.contains("javscript"))) {
				activeLinksList.add(linkTxt);
			}
		}
		
		//get the size of active links list:
		System.out.println("size of active links and images: "+activeLinksList.size());
		
		for(int j=0;j<activeLinksList.size();j++) {
			checkBrokenLinks(activeLinksList.get(j));
		}
	}

	/*http response codes
	  1.200 --- ok
	  2.404 --- page not found
	  3.500 --- internal error
	  4.404 --- bad request
	 */
	
	public static void checkBrokenLinks(String linkTxt) {
		try {
			URL url=new URL(linkTxt);
			HttpURLConnection httpUrlConnection=(HttpURLConnection) url.openConnection();
			httpUrlConnection.setConnectTimeout(2000);
			httpUrlConnection.connect();
			if(httpUrlConnection.getResponseCode()>=400) {
				System.out.println(linkTxt +" ----> "+(httpUrlConnection.getResponseMessage())+" is a broken link");
			}else {
				System.out.println(linkTxt +" ----> "+(httpUrlConnection.getResponseMessage()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
