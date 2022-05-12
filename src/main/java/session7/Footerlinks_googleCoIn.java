package session7;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Footerlinks_googleCoIn {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.google.co.in/");
		
		By langLinks = By.cssSelector("div#SIvCob a");
		
		//1. Capture footer links : About, Advertising, ... , Settings
		System.out.println("Footer links : ");
		driver.findElements(By.cssSelector("div.o3j99.c93Gbe")).forEach(e -> System.out.println(e.getText()));
		
		//2. Capture footer language links and click on "తెలుగు" lang link to see whether google available in telugu or not
		List<WebElement> langList = driver.findElements(langLinks);
		System.out.println("lang count in google footer : "+langList.size());
		
		langList.forEach(e -> System.out.println(e.getText()));
		
		for(WebElement e : langList) {
			if(e.getText().equals("తెలుగు")) {
				e.click();
				break;
			}
		}
	}
}
