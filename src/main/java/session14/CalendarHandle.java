package session14;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarHandle {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		driver.findElement(By.id("datepicker")).click();
		
		By monYearTitle=By.cssSelector("div.ui-datepicker-title");
		
		selectTodate(); //Current date
		//selectFutureDate(monYearTitle,"June 2025","8"); //future date
		//selectPastDate(monYearTitle, "July 1987", "30"); //past date
	
	}
	
	public static void selectTodate() {
		LocalDate currentDate = LocalDate.now();  
		int dom = currentDate.getDayOfMonth();

		driver.findElement(By.xpath("//a[text()='"+dom+"']")).click();
	}
	
	public static void selectFutureDate(By locator, String expMonthYear, String day) {
		String actualMonYear = driver.findElement(locator).getText();
		System.out.println(actualMonYear);
		while (!actualMonYear.equals(expMonthYear)) {
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				actualMonYear = driver.findElement(locator).getText();
				System.out.println(actualMonYear);
			}
		driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
	}
	
	public static void selectPastDate(By locator, String expMonthYear, String day) {
		String actualMonYear = driver.findElement(locator).getText();
		System.out.println(actualMonYear);
		while (!actualMonYear.equals(expMonthYear)) {
				driver.findElement(By.xpath("//span[text()='Prev']")).click();
				actualMonYear = driver.findElement(locator).getText();
				System.out.println(actualMonYear);
			}
		driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
	}
}
