package session13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchBarTextAreaWE_SubmitMethod {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.amazon.in");
		
		WebElement searchTextArea=driver.findElement(By.id("twotabsearchtextbox"));
		searchTextArea.sendKeys("Kids Toys");
		searchTextArea.submit();
	}
}
