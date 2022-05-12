package session14;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_CarouselHandle_nxtBtnDisplayedByDefault {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		By carouselItems = By.xpath(
				"//h2[text()='Today’s Deals']/parent::div/following-sibling::div[contains(@class,'first-carousel')]//img");
		By nxtBtnXpath = By.xpath(
				"//h2[text()='Today’s Deals']/parent::div/following-sibling::div[contains(@class,'first-carousel')]/a[contains(@class,'feed-right')]");
		
		WebElement nxtBtnWE=driver.findElement(nxtBtnXpath);
		List<WebElement> carouselItemsList = driver.findElements(carouselItems);
		System.out.println("list size:"+carouselItemsList.size());
		
		Set<String> productsList = new LinkedHashSet<String>();

		while (!(nxtBtnWE.getAttribute("class").contains("feed-control-disabled"))) {
			for (WebElement e : carouselItemsList) {
				productsList.add("alternate text:"+e.getAttribute("alt")+"\t src link:" + e.getAttribute("src"));
			}
			nxtBtnWE.click();
			carouselItemsList = driver.findElements(carouselItems);

		}
		productsList.stream().forEach(e->System.out.println(e));
	}
}
