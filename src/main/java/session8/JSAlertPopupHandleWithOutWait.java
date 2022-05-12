package session8;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSAlertPopupHandleWithOutWait  {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		By uname = By.id("login1");
		By pwd = By.id("password");
		By signInBtn = By.xpath("//input[@value='Sign in']");

		driver.findElement(signInBtn).click();

		Alert alert = driver.switchTo().alert();
		
		System.out.println("alert msg : " + alert.getText());
		alert.accept();
		
		driver.switchTo().defaultContent();
		
		driver.findElement(uname).sendKeys("test@rediff.com");
	}
}
