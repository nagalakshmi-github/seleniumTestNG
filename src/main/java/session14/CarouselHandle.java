package session14;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarouselHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.noon.com/uae-en/");
		Thread.sleep(3000);
		
		getCarouselItems("More clearence deals");
		
	}
	
	public static void getCarouselItems(String sectionName) {
		String xpath = "//h3[text()='"+sectionName+"']/parent::div/../following-sibling::div//div[@data-qa='product-name']";
		
		List<WebElement> recommList = driver.findElements(By.xpath(xpath));
		System.out.println(recommList.size());
		
		String next_xpath = "//h3[text()='"+sectionName+"']/parent::div/../following-sibling::div//div[contains(@class,'swiper-button-next')]";
		
		//List<String> dataList = new ArrayList<String>();
		Set<String> dataList = new TreeSet<String>();

		while(!driver.findElement(By.xpath(next_xpath)).getAttribute("class").contains("swiper-button-disabled")) {
			
			//logic for get the text and click on next button
			for(WebElement e : recommList) {
				String text = e.getText();
					if(!text.isEmpty()) {
						dataList.add(text);
					}
			}
			
			driver.findElement(By.xpath(next_xpath)).click();
			recommList = driver.findElements(By.xpath(xpath));
			
		}
		
		for(String e : dataList) {
			System.out.println(e);
		}
		
	}
	
	
	
	
	

}
