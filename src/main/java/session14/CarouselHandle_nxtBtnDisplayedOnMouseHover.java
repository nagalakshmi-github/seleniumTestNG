package session14;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarouselHandle_nxtBtnDisplayedOnMouseHover {

	static WebDriver driver;

	public static void main(String[] args)  {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		//printCarouselList("repurchased in Supplies");
		//printCarouselList("Car & bike accessories");
		printCarouselList("Beauty and Personal Care");
	}

	public static void printCarouselList(String sectionName) {
		System.out.println("*************carousel section name:"+sectionName+"***************");
		
		By nxtBtnXpath = By.xpath("//span[contains(text(),'" + sectionName
				+ "')]/parent::h2/parent::div[@class='a-section as-title-block']/following-sibling::div//a[contains(@class,'feed-right')]");
		By products = By.xpath("//span[contains(text(),'" + sectionName
				+ "')]/parent::h2/parent::div[@class='a-section as-title-block']/following-sibling::div//img");

		By sectionNameLoc = By.xpath("//span[contains(text(),'" + sectionName + "')]/parent::h2/parent::div");
	
		WebElement sectionNameWE = driver.findElement(sectionNameLoc);
		WebElement nxtBtnWE = driver.findElement(nxtBtnXpath);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		Actions action = new Actions(driver);

		//List<String> productsList = new ArrayList<String>();
		//using linkedhashset instead of ArrayList to avoid duplicates
		Set<String> productsList=new LinkedHashSet<String>();
		
		//get products list for a particular carousal section
		List<WebElement> caraouselProducts = driver.findElements(products);
		System.out.println(" carousel products list size: " + caraouselProducts.size());

		//loop until next button for that section disabled after clicking on it
		while (!(nxtBtnWE.getAttribute("class")).contains("feed-control-disabled")) {
			for (WebElement e : caraouselProducts) {
				productsList.add(e.getAttribute("alt"));
			}
			
			//mouse hover on that particular section to get next button displayed
			action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'" + sectionName
							+ "')]/parent::h2/parent::div[@class='a-section as-title-block']/following-sibling::div"))).perform();
			
			//wait for nxt btn to be displayed and if displayed click on next
			wait.until(ExpectedConditions.elementToBeClickable(nxtBtnXpath)).click();
			
			// update the carousel list after nxt btn is clicked
			caraouselProducts = driver.findElements(products);
		}
		
		//display the products for that particular carousal section
		System.out.println("****products displayed under section - "+sectionName+" is:*****");
		productsList.stream().forEach(k -> System.out.println(k.toString()));
	}
}
