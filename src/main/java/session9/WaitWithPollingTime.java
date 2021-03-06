package session9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitWithPollingTime {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		//By emailId=By.id("input-email");
		By emailId=By.id("input-email111");
		By password=By.id("input-password");
		By loginBtn=By.xpath("//input[@value='Login']");
		
		WebDriverWait wait=new WebDriverWait(driver, 10, 2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(emailId)).sendKeys("naveenanimation20@gmail.com");
	}
}
