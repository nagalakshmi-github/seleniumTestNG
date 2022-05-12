package session7;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQueryDropdown {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		driver.findElement(By.id("justAnInputBox")).click();

		By dropdownVal = By.cssSelector("span.comboTreeItemTitle");

		String[] choicesTobeSelected = { "choice 1", "choice 2", "choice 2 3", "choice 6", "choice 6 2",
				"choice 6 2 1" };

		// TC 01: Single choice selection
		// selectChoice(dropdownVal,"choice 5");

		// TC 02: Multiple choices selection
		// selectChoice(dropdownVal, choicesTobeSelected);

		// TC 03: All choices selection with unique identifier all/All/ALL
		selectChoice(dropdownVal, "automation_all");
	}

	/*
	 * TC 01: Single choice selection ; TC 02: Multiple choices selection ; TC 03: All choices selection with unique identifier 'automation_all'
	 */
	public static void selectChoice(By locator, String... value) {
		List<WebElement> choiceList = driver.findElements(locator);

		if (!value[0].equalsIgnoreCase("automation_all")) {
			for (int i = 0; i < choiceList.size(); i++) {
				String text = choiceList.get(i).getText();
				System.out.println(text);

				for (int j = 0; j < value.length; j++) {
					if (text.equals(value[j])) {
						choiceList.get(i).click();
						break;
					}
				}
			}
		}else {
			//select all the choices
			//choiceList.stream().filter(t -> t.isDisplayed()).forEach(e-> e.click());
			try {
				for(WebElement e:choiceList) {
					e.click();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("All displayed choices in the jquery dropdown are selected....");
			}
		}
	}
}
