package session2.dataProvider;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.ExcelUtil;

import session2.BaseTest;

public class LoginPageCredentialsValidationsTest_DPwithExcel extends BaseTest {

	By errMsg = By.cssSelector("div.alert-danger");

	@DataProvider
	public Object[][] getRegisterData(){
		return ExcelUtil.getTestData("LoginPage_testData");
	}
	
	@Test(dataProvider ="getRegisterData" )
	public void doLogin(String uname,String pwd) {
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(uname);
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		if(driver.findElement(errMsg).isDisplayed()) 
			System.out.println("Invalid credentials... failed to Login");
		else
			System.out.println("User successfully Logged-in");
	}
}

