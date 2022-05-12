package session10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSEUtil_DrawBorderForWE {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");

		JavaScriptExecutorUtil jsUtil = new JavaScriptExecutorUtil(driver);
		jsUtil.drawBorder(driver.findElement(By.id("loginForm")));
	}
}
