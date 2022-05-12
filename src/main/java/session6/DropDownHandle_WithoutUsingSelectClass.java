package session6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandle_WithoutUsingSelectClass {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial-old/");

		By industryDropdownOptions = By.xpath("//select[@id=\"Form_submitForm_Industry\"]/option");
		
		selectDropDownValue(industryDropdownOptions, "Aerospace");
	}

	public static List<WebElement> doGetElements(By locator) {
		return driver.findElements(locator);
	}

	public static void selectDropDownValue(By locator, String value) {
		List<WebElement> optionsList = driver.findElements(locator);

		for (WebElement e : optionsList) {
			if (e.getText().contains(value)) {
				e.click();
				break;
			}
		}
	}
}
