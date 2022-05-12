package session5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalImages {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in");

		By img = By.tagName("img");
		List<WebElement> imgList = driver.findElements(img);
		System.out.println("Total images : "+imgList.size());
		
		String imgTxt,imgSrcLink;
		
		for(WebElement e : imgList) {
			imgTxt=e.getAttribute("alt");
			imgSrcLink=e.getAttribute("src");
			
			if(!imgTxt.isEmpty())
				System.out.println("Image Text : "+imgTxt);
			
			if(!imgSrcLink.isEmpty())
				System.out.println("Img src link : "+imgSrcLink);
			
			System.out.println();
		}
	}
}
