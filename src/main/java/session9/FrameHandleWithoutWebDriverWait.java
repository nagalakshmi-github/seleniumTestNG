package session9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandleWithoutWebDriverWait {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();

		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		//driver.switchTo().frame(2);//working
		//driver.switchTo().frame("main");//working
		driver.switchTo().frame(driver.findElement(By.name("main")));
		System.out.println(driver.findElement(By.xpath("/html/body/h2")).getText());
	}
}
