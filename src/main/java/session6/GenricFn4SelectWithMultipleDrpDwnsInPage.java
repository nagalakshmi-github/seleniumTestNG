package session6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenricFn4SelectWithMultipleDrpDwnsInPage {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial-old/");
		
		By empRangeDropdown=By.id("Form_submitForm_NoOfEmployees");
		By industryDropdown=By.id("Form_submitForm_Industry");
		By countryDropDown=By.id("Form_submitForm_Country");
		By stateDropDown=By.id("Form_submitForm_State");
		
		doSelectDropDownByIndex(empRangeDropdown, 1);
		doSelectDropDownByValue(industryDropdown, "Education");
		doSelectDropDownByVisibleText(countryDropDown, "India");
		Thread.sleep(2000);
		doSelectDropDownByValue(stateDropDown,"Andhra Pradesh");
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectDropDownByIndex(By locator, int index) {
		Select sel=new Select(getElement(locator));
		sel.selectByIndex(index);
	}
	
	public static void doSelectDropDownByValue(By locator, String value) {
		Select sel=new Select(getElement(locator));
		sel.selectByValue(value);
	}
	
	public static void doSelectDropDownByVisibleText(By locator, String text) {
		Select sel=new Select(getElement(locator));
		sel.selectByVisibleText(text);
	}
}
