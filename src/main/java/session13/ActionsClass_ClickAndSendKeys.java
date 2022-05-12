package session13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClass_ClickAndSendKeys {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial-old/");
		
		do_ActionsClass_SendKeys(By.id("Form_submitForm_FirstName"), "testautomation");
		do_ActionsClass_Click(By.linkText("CONTACT SALES"));
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void do_ActionsClass_SendKeys(By locator,String value) {
		Actions action=new Actions(driver);
		action.sendKeys(getElement(locator), value).perform();
	}
	
	public static void do_ActionsClass_Click(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
}
