package session14;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/");
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		Thread.sleep(3000);

		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click();
		Thread.sleep(3000);
		
		List<WebElement> pages = driver.findElements(By.xpath("(//div[@class='pagination'])[1]/a"));
		
		int i = 0;
		while(true) {
			if(driver.findElements(By.linkText("Ankur Sinha")).size() == 1) {
				selectContact("Ankur Sinha");
				break;
			}
			//pagintaion logic:
			else {
				try {
					pages.get(i).click();//3
				}
				catch(Exception e ) {
					System.out.println("pagination is over ....and dint find any contact");
					break;
				}
				pages = driver.findElements(By.xpath("(//div[@class='pagination'])[1]/a"));
			}
			i++;
		}
	}
	
	public static void selectContact(String name) {
		String checkBox = "//a[text()='"+name+"']/parent::td/preceding-sibling::td/input[@type='checkbox']";
		driver.findElement(By.xpath(checkBox)).click();
	}
}
