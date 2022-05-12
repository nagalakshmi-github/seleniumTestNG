package session14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElement_FlipkartSearchIcon {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//div[@class='_2QfC02']/button")).click();
		
		driver.findElement(By.xpath("//form[@action='/search']//input[@type='text']")).sendKeys("books");
		
		Actions action=new Actions(driver);
		
		WebElement searchIcon=driver.findElement(By.xpath("//*[name()='svg']/*[local-name()='g']"));
		action.moveToElement(searchIcon).click(searchIcon).build().perform();
	}
}
