package session2;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

	public void doLogin() {
		driver.findElement(By.name("email")).sendKeys("naveenanimation20@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
	@Test
	public void homePageTitleTest() {
		doLogin();
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "My Account");
	}
}
