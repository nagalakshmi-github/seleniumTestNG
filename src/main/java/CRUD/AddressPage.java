package CRUD;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage {
	private WebDriver driver;
	
	By adressesLink=By.linkText("Addresses");
	By newAdressesLink=By.linkText("New Address");
	By firstName=By.id("address_first_name");
	By lastName=By.id("address_last_name");
	By address1=By.id("address_street_address");
	By city=By.id("address_city");
	By zipCode=By.id("address_zip_code");
	By createAddressBtn=By.xpath("//input[@value='Create Address']");
	By successMsg=By.cssSelector("div.alert.alert-notice");
	
	//unique field to perform get/update/delete operations 
	By firstNameValue=By.xpath("//span[@data-test='first_name']");
	
	public AddressPage(WebDriver driver) {
		this.driver = driver;
	}
	public void clickAddressLink() {
		driver.findElement(adressesLink).click();
	}
	
	private String fillAddressForm(Address address) {
		driver.findElement(firstName).clear();
		driver.findElement(firstName).sendKeys(address.getFname());
		
		driver.findElement(lastName).clear();
		driver.findElement(lastName).sendKeys(address.getLname());
		
		driver.findElement(address1).clear();
		driver.findElement(address1).sendKeys(address.getAddress1());
		
		driver.findElement(city).clear();
		driver.findElement(city).sendKeys(address.getCity());
		
		driver.findElement(zipCode).clear();
		driver.findElement(zipCode).sendKeys(address.getZipcode());
		
		driver.findElement(createAddressBtn).click();
		return driver.findElement(successMsg).getText();
	}
	
		public String createNewAddress(Address address) {
			clickAddressLink();
			driver.findElement(newAdressesLink).click();
			return fillAddressForm(address);
		}
		
		public String retrieveAddress(Address address,String fname) {
			clickAddressLink();
			driver.findElement(By.xpath("//td[text()='"+fname+"']//following-sibling::td/a[text()='Show']")).click();
			return driver.findElement(firstNameValue).getText();
		}
		
		public String updateAddress(Address address,String fname) {
			clickAddressLink();
			driver.findElement(By.xpath("//td[text()='"+fname+"']//following-sibling::td/a[text()='Edit']")).click();
			return fillAddressForm(address);
		}
		
		public String deleteAddress(Address address,String fname) {
			clickAddressLink();
			driver.findElement(By.xpath("//td[text()='"+fname+"']//following-sibling::td/a[text()='Destroy']")).click();
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			return driver.findElement(successMsg).getText();
		}
}
