package session6;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownGetOptions {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial-old/");

		By industryDropdown = By.id("Form_submitForm_Industry");
		By countryDropDown = By.id("Form_submitForm_Country");

		List<String> indusList = doGetAllDropDownOptions(industryDropdown);
		indusList.forEach(e -> System.out.println(e));

		doGetAllDropDownOptions(countryDropDown).forEach(e -> System.out.println(e));

		// as a tester printing output on console is not our job..we need to do
		// validation
		if (indusList.size() == 21) {
			System.out.println("Industry dropdown count is correct");
		}

		if (indusList.contains("Electronics")) {
			System.out.println("indus list contains option: Electronics");
		}
		
		doSelectDropDownValue(industryDropdown, "Education");
		doSelectDropDownValue(countryDropDown, "India");
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	/*generic function using getOptions() to get text for all values in a dropdown*/
	public static List<String> doGetAllDropDownOptions(By locator) {
		Select select = new Select(getElement(locator));

		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());

		List<String> optionsTextList = new ArrayList<String>();

		for (WebElement e : optionsList) {
			optionsTextList.add(e.getText());
		}
		return optionsTextList;
	}
	
	/*generic function using getOptions() for selecting dropdown value and without using selectByIndex()/value()/visibleText() methods*/
	public static void doSelectDropDownValue(By locator, String value) {
		Select select = new Select(getElement(locator));

		List<WebElement> optionsList = select.getOptions();
		for (WebElement e : optionsList) {
			String text=e.getText();
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}
}
