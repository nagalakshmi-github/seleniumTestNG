package session10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExecSelScriptUsingIncognitoOrHeadlessBrowser {
	static WebDriver driver;

	public static void main(String[] args) {
		
		/*  chrome --headless
		WebDriverManager.chromedriver().setup();
		//execute the selenium script in headless mode as below,
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(co);
		driver.get("http://www.google.com"); 

		String title=driver.getTitle();
		System.out.println("Page title is : "+title); 
		
		if(title.equals("Google")) {
			System.out.println("correct title");
		}else {
			System.out.println("incorrect title");
		}
		
		System.out.println(driver.getCurrentUrl());
		driver.quit();
		*/
		
		
		/*  chrome --incognito 
		WebDriverManager.chromedriver().setup();
		//execute the selenium script in headless mode as below,
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--incognito");
		
		WebDriver driver = new ChromeDriver(co);
		driver.get("http://www.google.com"); 

		String title=driver.getTitle();
		System.out.println("Page title is : "+title); 
		
		if(title.equals("Google")) {
			System.out.println("correct title");
		}else {
			System.out.println("incorrect title");
		}
		
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	*/
		
		
		/*  FF --incognito
		WebDriverManager.firefoxdriver().setup();

		FirefoxOptions fo=new FirefoxOptions();
		fo.addArguments("--incognito");
		
		WebDriver driver = new FirefoxDriver(fo);
		driver.get("http://www.google.com"); 

		String title=driver.getTitle();
		System.out.println("Page title is : "+title); 
		
		if(title.equals("Google")) {
			System.out.println("correct title");
		}else {
			System.out.println("incorrect title");
		}
		
		System.out.println(driver.getCurrentUrl());
		driver.quit();
		 */
		
		/*  FF --headless */
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions fo=new FirefoxOptions();
		fo.addArguments("--headless");
		
		WebDriver driver = new FirefoxDriver(fo);
		driver.get("http://www.google.com"); 

		String title=driver.getTitle();
		System.out.println("Page title is : "+title); 
		
		if(title.equals("Google")) {
			System.out.println("correct title");
		}else {
			System.out.println("incorrect title");
		}
		
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}
}
