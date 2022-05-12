package session8;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSAlertPopupHandleWithWebDriverWait_ExOfNonWE {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		By uname = By.id("login1");
		By pwd = By.id("password");
		By signInBtn = By.xpath("//input[@value='Sign in']");
		
		driver.findElement(signInBtn).click();
		
		System.out.println("alert text: "+alertGetText(10));
		acceptAlert(10);
		
		driver.switchTo().defaultContent();
		driver.findElement(uname).sendKeys("test@rediff.com");
	}
	
	/*made this method private to be accessed by public methods to acheive encapsulation*/
	private static Alert waitForAlert(int timeOut) {
		WebDriverWait wait=new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}
	
	public static void dismissAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}
	
	public static String alertGetText(int timeOut) {
		return waitForAlert(timeOut).getText();
	}
	
	public static void alertSendKeys(int timeOut,String value) {
		waitForAlert(timeOut).sendKeys(value);
	}
}
