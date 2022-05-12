package session4;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import session3.BrowserUtil;

public class OpenCartRegFormFilling_assgn {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.initDriver("chrome");

		br.launchUrl("https://demo.opencart.com/index.php?route=account/login");

		By regLink = By.linkText("Register");

		ElementUtil ele = new ElementUtil(driver);
		ele.doClick(regLink);

		By fname = By.id("input-firstname");
		By lname = By.id("input-lastname");
		By email = By.id("input-email");
		By contactNum = By.id("input-telephone");
		By pwd = By.id("input-password");
		By confirmPwd = By.id("input-confirm");
		By chkbox = By.name("agree");
		By continueBtn=By.className("btn-primary");
		By userRegSuccMsg=By.cssSelector("#content > h1");
		//*[@id="content"]/h1

		Map<By, String> map = new HashMap<By, String>();
		map.put(fname, "testers");
		map.put(lname, "12345");
		map.put(email, "testers12345@gmail.com");
		map.put(contactNum, "9234567890");
		map.put(pwd, "tester123");
		map.put(confirmPwd, "tester123");
		
		//Approach1: Using Entry Set with map
		for(Entry<By, String> entry : map.entrySet()) {
			ele.doSendKeys(entry.getKey(), entry.getValue());
		}

		//Approach2: Using forEach with map
		//	map.forEach((k, v) -> ele.doSendKeys(k, v));
		
		ele.doClick(chkbox);
		ele.doClick(continueBtn);
		
		Thread.sleep(5000);
		
		String regSuccMsg=ele.doGetText(userRegSuccMsg);
		String ExpectedRegSuccMsg="Your Account Has Been Created!";
		
		if(regSuccMsg.equals(ExpectedRegSuccMsg)){
			System.out.println("User has successfully registered to OpenCart appln");
		}else
			System.out.println("User registeration is failed to OpenCart appln");
		
		br.closeBrowser();
	}
}
