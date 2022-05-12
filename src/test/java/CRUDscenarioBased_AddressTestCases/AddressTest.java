package CRUDscenarioBased_AddressTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CRUD.Address;
import CRUD.AddressPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddressTest {

	public WebDriver driver;
	public AddressPage page;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://a.testaddressbook.com/sign_in");
		driver.findElement(By.id("session_email")).sendKeys("naveenanimation20@gmail.com");
		driver.findElement(By.id("session_password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		page=new AddressPage(driver);
	}
	
	@Test
	public void createAddressTest() {
		Address address=new Address("naga", "lakshmi", "nrt address","nrt" , "522601");
		String actual_succMsg=page.createNewAddress(address);
		Assert.assertEquals(actual_succMsg,"Address was successfully created");
	}
	
	@Test
	public void retrieveAddressTest() {
		Address address=new Address("naga s", "lakshmi s", "nrt addresses","nrt 1" , "522611");
		page.createNewAddress(address);
		String actualFirstName=page.retrieveAddress(address,address.getFname());
		Assert.assertEquals(actualFirstName,"naga s");
	}
	
	@Test
	public void updateAddressTest() {
		Address address=new Address("naga sada", "lakshmi sada", "nrt address1","nrt1" , "522602");
		page.createNewAddress(address);
		address.setLname("laxmi sada");
		address.setCity("bangalore");
		String actual_succMsg=page.updateAddress(address,address.getFname());
		Assert.assertEquals(actual_succMsg,"Address was successfully updated");
	}
	
	@Test
	public void deleteAddressTest() {
		Address address=new Address("naga del", "lakshmi del", "nrt address del","nrt11" , "522621");
		page.createNewAddress(address);
		String actual_succMsg=page.deleteAddress(address, address.getFname());
		Assert.assertEquals(actual_succMsg,"Address was successfully destroyed");
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
