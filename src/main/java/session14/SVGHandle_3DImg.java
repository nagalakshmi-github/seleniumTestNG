package session14;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGHandle_3DImg {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://debeissat.nicolas.free.fr/svg3d.php");
		driver.switchTo().frame(driver.findElement(By.id("svg_result")));
		
		//using while loop to get the 3D rotating SVG image coordinates continuously 
		while(true) {
		List<WebElement> pathCoordinatesList=driver.findElements(By.xpath("//*[name()='svg' and @id='body']//*[local-name()='g']/*[local-name()='path' and contains(@id,'face')]"));
		System.out.println(pathCoordinatesList.size());
		pathCoordinatesList.stream().forEach(ele->System.out.println(ele.getAttribute("d")));
		}
	}
}
