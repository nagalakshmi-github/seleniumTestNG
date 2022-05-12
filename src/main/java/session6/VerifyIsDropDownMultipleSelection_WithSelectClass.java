package session6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyIsDropDownMultipleSelection_WithSelectClass {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial-old/");

		By industryDropdown = By.id("Form_submitForm_Industry");
		
		Select sel=new Select(driver.findElement(industryDropdown));
		System.out.println("Is Industry dropdown allows multiple selection of values or not : "+sel.isMultiple());
	}
}
