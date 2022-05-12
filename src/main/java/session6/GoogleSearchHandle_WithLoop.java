package session6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchHandle_WithLoop {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		
		driver.get("https://www.google.in");
		
		driver.findElement(By.name("q")).sendKeys("Naveen Automation Labs");
		
		Thread.sleep(2000);
		
		List<WebElement> suggestionsList=driver.findElements(By.xpath("//ul[@role='listbox']//div[@class='wM6W7d']/span"));
		
		for(WebElement e: suggestionsList) {
			if(e.getText().equalsIgnoreCase("Naveen Automation Labs core java")) {
				e.click();
				break;
			}
		}
	}
}
