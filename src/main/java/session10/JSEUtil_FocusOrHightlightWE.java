package session10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSEUtil_FocusOrHightlightWE {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");

		JavaScriptExecutorUtil jsUtil = new JavaScriptExecutorUtil(driver);

		jsUtil.flash(driver.findElement(By.name("username")));
		driver.findElement(By.name("username")).sendKeys("groupautomation");

		jsUtil.flash(driver.findElement(By.name("password")));
		driver.findElement(By.name("password")).sendKeys("Test@12345"); 
		
		jsUtil.flash(driver.findElement(By.xpath("//input[@value='Login']"))); 
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
}
