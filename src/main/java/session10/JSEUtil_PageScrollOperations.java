package session10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSEUtil_PageScrollOperations   {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		JavaScriptExecutorUtil jsUtil = new JavaScriptExecutorUtil(driver);
		jsUtil.scrollPageDown();
		TimeUtil.mediumWait();
		jsUtil.scrollPageUp();
		TimeUtil.mediumWait();
		jsUtil.scrollPageDown("200");
		
		jsUtil.scrollIntoView(driver.findElement(By.xpath("//span[text()='Essentials for your safety']")));
	}
}
