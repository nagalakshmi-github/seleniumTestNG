package session6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationPractice_searchbarhandleWithOutLoop {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php");
		
		driver.findElement(By.id("search_query_top")).sendKeys("dress");
		
		Thread.sleep(5000);
		
		/*Search text selection from list without using for loop*/
		driver.findElement(By.xpath("//div[@class='ac_results']//li[text()='T-shirts > Faded Short Sleeve T-shirts']")).click();
		
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//h1[@itemprop='name']")).getText().equals("Faded Short Sleeve T-shirts")) {
			System.out.println("User clicked on the correct search element from the suggestion list");
		}else
			System.out.println("user clicked on wrong suggestion from search bar");
	}
}
