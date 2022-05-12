package session1_testNG_Features;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoOpenCartTest {

	public WebDriver driver;
	
	@BeforeSuite
	public void setUpDB() {
		System.out.println("BS -- setup DB");
	}
	
	@BeforeTest
	public void createUser() {
		System.out.println("BT -- create user");
	}
	
	@BeforeClass
	public void launchBrowser() {
	System.out.println("BC -- launch browser");	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void loginToApp() {
		System.out.println("BM -- Login to App");
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.findElement(By.name("email")).sendKeys("naveenanimation20@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
	@Test
	public void accountPageTitleTest() {
		System.out.println("TC1 -- loginTest()");
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, "My Account");
	}
	
	@Test
	public void logoutLinkTest() {
		System.out.println("TC2 -- logoutLinkTest()");
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
	}
	
	@Test
	public void searchBarTest() {
		System.out.println("TC3 -- searchBarTest()");
		Assert.assertTrue(driver.findElement(By.name("search")).isDisplayed());
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("AM -- logout()");
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("AC -- closeBrowser()");
		driver.quit();
	}
	
	@AfterTest
	public void deleteUser() {
		System.out.println("AT -- deleteUser()");
	}
	
	@AfterSuite
	public void disconnectDB() {
		System.out.println("AS -- disconnectDB()");
	}
}
