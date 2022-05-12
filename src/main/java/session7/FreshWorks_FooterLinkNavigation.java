package session7;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FreshWorks_FooterLinkNavigation {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.freshworks.com/");

		List<WebElement> footerLeftTxtLinksList = driver
				.findElements(By.xpath("//ul[@class='footer-nav']//a"));

		System.out.println("Left section footer links count : " + footerLeftTxtLinksList.size());

		/*Go to every footer link and click on each footer link and return back to freshworks home page and again follow same procedure*/
		for (int i=0;i<footerLeftTxtLinksList.size();i++) {
			System.out.println(footerLeftTxtLinksList.get(i).getText());
			footerLeftTxtLinksList.get(i).click();
			System.out.println("title of the current page is : "+driver.getTitle());
			driver.navigate().back();
			footerLeftTxtLinksList = driver
					.findElements(By.xpath("//ul[@class='footer-nav']//a"));
		}
	}
}
