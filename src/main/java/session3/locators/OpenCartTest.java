package session3.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import session3.BrowserUtil;

public class OpenCartTest {

	public static void main(String[] args) {

		BrowserUtil br=new BrowserUtil();
		WebDriver driver=br.initDriver("chrome");
		br.launchUrl("https://demo.opencart.com/index.php?route=account/login");
		
		ElementUtil eleUtil= new ElementUtil(driver);
		By email = By.id("input-email");
		By password=By.id("input-password");
		
		eleUtil.doSendKeys(email,"naveen@gmail.com");
		eleUtil.doSendKeys(password,"test@123");
		
		br.closeBrowser();
	}
}
