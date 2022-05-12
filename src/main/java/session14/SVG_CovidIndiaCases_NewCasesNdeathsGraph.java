package session14;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVG_CovidIndiaCases_NewCasesNdeathsGraph {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//input[@name='q' and @type='text']")).sendKeys("covid cases in india");
		Thread.sleep(2000);
		List<WebElement> googleSuggestionsList = driver
				.findElements(By.xpath("//ul[@role='listbox']//div[@class='wM6W7d']/span"));
		for (WebElement e : googleSuggestionsList) {
			if (e.getText().equals("covid cases in india")) {
				e.click();
				break;
			}
		}
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("(//div[@jsmodel='Lfq59c'])[1]")));

		List<WebElement> graphResult = driver.findElements(
				By.xpath("(//*[name()='svg' and @class='uch-psvg'])[1]/*[local-name()='g']/*[local-name()='rect']"));
		System.out.println("graph result size: " + graphResult.size());

		Actions action = new Actions(driver);
		WebElement toolTip=driver.findElement(By.xpath("//div[@class='ExnoTd']"));
		
		for (WebElement we : graphResult) {
			action.moveToElement(we).perform();
			System.out.println(toolTip.getText());
		}
	}
}
