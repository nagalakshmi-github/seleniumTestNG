package session4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTextUsingAnyByLocator {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/register");
		
		ElementUtil ele = new ElementUtil(driver);
		
		//getText() using tagName Locator
		By header = By.tagName("h1");
		String h1Text = ele.doGetText(header);
		System.out.println(h1Text);
		
		//getText() using xpath Locator
		By agree=By.xpath("//*[@id='content']//div[@class='pull-right']");
		String policyAgrementTxt= ele.doGetText(agree);
		System.out.println(policyAgrementTxt);
		
		//getText() using linkText Locator
		By forgotPwd=By.linkText("Forgotten Password");
		String forgotPwdTxt= ele.doGetText(forgotPwd);
		System.out.println(forgotPwdTxt);
	}
}
