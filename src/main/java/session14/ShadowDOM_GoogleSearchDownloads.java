package session14;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDOM_GoogleSearchDownloads {

	public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
	        driver.get("chrome://downloads/");
	        
	        JavascriptExecutor jse=(JavascriptExecutor)driver;
	        WebElement search=(WebElement)jse.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('downloads-toolbar#toolbar').shadowRoot.querySelector('cr-toolbar#toolbar').shadowRoot.querySelector('div#centeredContent cr-toolbar-search-field#search').shadowRoot.querySelector('div#searchTerm > input#searchInput')");
	        String js="arguments[0].setAttribute('value','lakshmi')";
	        ((JavascriptExecutor)driver).executeScript(js, search);
	}
}
