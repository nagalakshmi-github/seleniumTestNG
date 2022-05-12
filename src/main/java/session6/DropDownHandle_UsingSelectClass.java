package session6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandle_UsingSelectClass {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial-old/");
		
		//html tag = select; then only we can use 'select' class for dropdown
		By industryDropdown=By.id("Form_submitForm_Industry");
		WebElement indus= driver.findElement(industryDropdown);
		WebElement country=driver.findElement(By.id("Form_submitForm_Country"));
		
		Select sel = new Select(indus);
		sel.selectByIndex(4);
		System.out.println("initally selected : "+sel.getFirstSelectedOption().getText());
		sel.selectByValue("Aerospace");
		System.out.println("changed to : "+sel.getFirstSelectedOption().getText());
		sel.selectByVisibleText("Healthcare");
		System.out.println("and finally changed to : "+sel.getFirstSelectedOption().getText());
		
		Select sel1=new Select(country);
		sel1.selectByVisibleText("India");
	}
}
