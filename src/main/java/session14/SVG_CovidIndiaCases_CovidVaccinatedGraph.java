package session14;

import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVG_CovidIndiaCases_CovidVaccinatedGraph {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, ParseException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://www.google.com");

		driver.findElement(By.xpath("//input[@name='q' and @type='text']")).sendKeys("covid cases in india");
		Thread.sleep(5000);
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
				driver.findElement(By.xpath("(//div[@jsmodel='Lfq59c'])[3]")));

		WebElement graphResult = driver.findElement(By.xpath("(//*[name()='svg' and @class='uch-psvg'])[3]"));
		int getTopLeftY = ((graphResult.getSize().getHeight()) / 2) - (graphResult.getSize().getHeight());
		int getTopLeftX = ((graphResult.getSize().getWidth()) / 2) - (graphResult.getSize().getWidth());

		Actions action = new Actions(driver);
		for (int i = 0; i <= -2*(getTopLeftX); i++) {
			action.moveToElement(graphResult, getTopLeftX + i, getTopLeftY).perform();
			System.out.println(driver.findElement(By.xpath("//table[@class='F9Gkq']/tbody")).getText());
		}
	}
}
