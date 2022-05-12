package session14;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowSwitch {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");// parent window
		String parentOrWindowId = driver.getWindowHandle();

		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();

		Set<String> handles = driver.getWindowHandles();
		List<String> handlesList = new ArrayList<String>(handles);

		// validate whether driver is on requested window or not
		if (switchToRightWindow("Facebook", handlesList)) {
			System.out.println(driver.getCurrentUrl() + " : " + driver.getTitle());
		}

		// switch to parent window
		switchToParentWindow(parentOrWindowId);
		System.out.println(driver.getCurrentUrl() + " : " + driver.getTitle());

		// Close child windows
		closeAllChildWindows(handlesList, parentOrWindowId);
	}

	// switch to particular window say orangehrm-facebook window out of the windows
	// list and validate we are on the right window
	public static boolean switchToRightWindow(String windowTitle, List<String> hList) {
		for (String s : hList) {
			String title = driver.switchTo().window(s).getTitle();
			if (title.contains(windowTitle)) {
				System.out.println("found the right window....");
				return true;
			}
		}
		return false;
	}

	public static void switchToParentWindow(String parentOrWindowId) {
		driver.switchTo().window(parentOrWindowId);
	}

	public static void closeAllChildWindows(List<String> handlesList, String parentOrWindowId) {
		for (String s : handlesList) {
			if (!s.equals(parentOrWindowId)) {
				driver.switchTo().window(s).close();
			}
		}
	}
}
