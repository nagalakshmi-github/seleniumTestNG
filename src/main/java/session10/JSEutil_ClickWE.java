package session10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSEutil_ClickWE {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");

		JavaScriptExecutorUtil jsUtil = new JavaScriptExecutorUtil(driver);
		jsUtil.clickElementByJS(driver.findElement(By.xpath("//input[@value='Login']")));
	}
}
