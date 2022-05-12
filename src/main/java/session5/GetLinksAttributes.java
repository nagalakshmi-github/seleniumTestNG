package session5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetLinksAttributes {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in");

		By links = By.tagName("a");
		List<WebElement> linksList = driver.findElements(links);

		System.out.println("----- total links ------- : " + linksList.size());

		linksList.forEach(e -> System.out.println(e.getAttribute("href")));
		
		System.out.println("-----------------------------------------------------------------------------");
		
		for (WebElement e : linksList) {
			String hrefVal = e.getAttribute("href");
				//check point to exclude href value "null/blank/javascript: void(0)" 
				if (!(hrefVal==null || hrefVal.isEmpty() || hrefVal.equals("javascript: void(0)"))){
					System.out.println(hrefVal);
			}
		}
	}
}
