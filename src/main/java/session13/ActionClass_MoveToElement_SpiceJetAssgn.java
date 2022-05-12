package session13;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClass_MoveToElement_SpiceJetAssgn {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://corporate.spicejet.com");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("a#ctl00_HyperLinkLogin.link")))
				.moveToElement(driver.findElement(By.xpath("//a[text()='SpiceClub Members']")))
					.build()
						.perform();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[@class='hide-mobile']//a[text()='Member Login' and contains(@href,'/Login.aspx')]")))).click();
		
		if(wait.until(ExpectedConditions.urlContains("Login.aspx"))) {
			System.out.println("user has navigated to 'Member Login' page from 'SpiceClub Members' link");
		}else
			System.out.println("user failed to navigate to 'Member Login' page");
	}
}
