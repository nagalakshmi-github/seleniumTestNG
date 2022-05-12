package session2;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

	@Test
	public void accountPageTitleTest() {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "Account Login");
	}

	@Test
	public void registerLinkTest() {
		Assert.assertTrue(driver.findElement(By.linkText("Register")).isDisplayed());
	}
}
