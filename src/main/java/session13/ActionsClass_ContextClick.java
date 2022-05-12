package session13;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClass_ContextClick {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

		Actions action = new Actions(driver);
		
		action.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//print all options from right click me button
		System.out.println("options from right click me button:");
		for(WebElement e: driver.findElements(By.cssSelector("ul.context-menu-list span"))) {
			String txt=e.getText();
			System.out.println(txt);
			e.click();
			
			Alert alert=wait.until(ExpectedConditions.alertIsPresent());
			System.out.println("clicked on "+txt+" option from right context menu button");
			alert.accept();
			
			if(!txt.equals("Quit")) 
				action.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
		}
	}
}
