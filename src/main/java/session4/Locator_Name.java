package session4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locator_Name {

	static WebDriver driver; 
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial-old/");
		
		ElementUtil ele= new ElementUtil(driver);
		
		By firstName= By.name("FirstName");
		ele.doSendKeys(firstName, "lakshmi");
		
		driver.close();
	}
}
