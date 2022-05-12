package session14;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframe_ShadowRootWE {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();
        
        driver.switchTo().frame("pact");
        
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        WebElement we=(WebElement)jse.executeScript("return document.querySelector('div#snacktime').shadowRoot.querySelector('div.uoj  > input#tea')");
        jse.executeScript("arguments[0].scrollIntoView(true);", we);
        jse.executeScript("arguments[0].setAttribute('value','Green Tea')", we);
	}
}
