package session9;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WDWaitForListOfElementsTobeVisible {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.freshworks.com/");

		By footerList = By.xpath("//ul[@class='footer-nav']//a");

		printTextOfAllVisibleElementsWithWait(footerList,5);
		
		System.out.println("------------------------");
		getElementsTxtListWithWait(footerList, 5).forEach(e-> System.out.println(e));
	}

	public static List<WebElement> waitForElementsToBeVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public static void printTextOfAllVisibleElementsWithWait(By locator,int timeOut) {
		waitForElementsToBeVisible(locator, timeOut).stream().forEach(e -> System.out.println(e.getText()));
	}

	public static List<String> getElementsTxtListWithWait(By locator, int timeOut){
	List<String> footerLinksTxtList= new ArrayList<String>();
	for(WebElement e: waitForElementsToBeVisible(locator, timeOut)) {
		footerLinksTxtList.add(e.getText().trim());
	}
	return footerLinksTxtList;
	}
}
