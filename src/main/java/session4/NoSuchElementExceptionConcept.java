package session4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoSuchElementExceptionConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");

		// with findElement(),
		// if we pass wrong locator value to the script;
		// since selenium is unable to locate that particular web element;
		// throws NoSuchElementException
		//driver.findElement(By.id("input-email11")).sendKeys("lakshmi@123");

		// with findElements(),
		// if we pass wrong locator value to the script;
		// though selenium is unable to locate that particular web element;
		// since return type of findElements() is a list, thereby wont throw any Exception; 
		//instead returns list size as "0".
		List<WebElement> emailList=driver.findElements(By.id("input-email11"));
		System.out.println(emailList.size());
		
		/*checkpoint : creating our own exception if list size=0*/
		try {
			if(emailList.size()==0) {
				System.out.println("element not present");
				throw new Exception("ElementNotPresentException");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
