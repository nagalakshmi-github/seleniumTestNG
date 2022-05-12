package session1_testNG_Features;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoCart_AccountsPageTest_BTAT {
	public WebDriver driver;

	public void doLogin() {
		driver.findElement(By.name("email")).sendKeys("naveenanimation20@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		doLogin();
	}

	@Test
	public void accountPageTitleTest() {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "My Account");
	}

	@Test
	public void logoutLinkTest() {
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
	}

	@Test
	public void searchBarTest() {
		Assert.assertTrue(driver.findElement(By.name("search")).isDisplayed());
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
