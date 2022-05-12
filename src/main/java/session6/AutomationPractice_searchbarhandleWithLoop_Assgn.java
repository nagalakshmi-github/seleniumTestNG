package session6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationPractice_searchbarhandleWithLoop_Assgn {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php");
		
		driver.findElement(By.id("search_query_top")).sendKeys("dress");
		
		Thread.sleep(5000);
		
		List<WebElement> searchSuggestionsList=driver.findElements(By.xpath("//div[@class='ac_results']//li"));
		
		/*Search text selection from list using List<WebElement> and for loop*/
		for(WebElement e: searchSuggestionsList) {
			if(e.getText().equals("Evening Dresses > Printed Dress")) {
				e.click();
				break;
			}
		}
		
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//h1[@itemprop='name']")).getText().equals("Faded Short Sleeve T-shirts")) {
			System.out.println("User clicked on the correct search element from the suggestion list");
		}else
			System.out.println("user clicked on wrong suggestion from search bar");
	}
}
