package session5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTotalLinks_findElements {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in");

		By links = By.tagName("a");
		List<WebElement> linksList=driver.findElements(links);
		
		System.out.println("----- total links ------- : "+linksList.size());
		
		/*For an ordered list, we can iterate through the list in 4 ways:
			1.using for-loop
			2.using enhanced for loop
			3.using forEach()
			4.using streams (either sequential or parallel)
		*/
		//M1: for-loop:
		for(int i=0; i<linksList.size();i++) {
			String text=linksList.get(i).getText();
			if(!text.isEmpty()) {
				System.out.println(text);
			}
		}
		
		//M2: enhanced for-loop:
		for(WebElement e: linksList) {
			if(!e.getText().isEmpty()){
				System.out.println(e.getText());
			}
		}
		
		//M3: using forEach()
		linksList.forEach(e -> System.out.println(e.getText()));
		
		//M4: using streams 
		//M4.i) sequential
		long stTime=System.currentTimeMillis();
		linksList
				.stream()
						.filter(e -> !e.getText().isEmpty())
							.forEach(ele -> System.out.println(ele.getText()));
		long endTime=System.currentTimeMillis();
		System.out.println("Time taken by Sequential stream : "+(endTime-stTime));
		
		System.out.println("-------------------------");
		
		//M4.ii) parallel
		long stTime1=System.currentTimeMillis();
		linksList
				.parallelStream()
						.filter(e -> !e.getText().isEmpty())
							.forEach(ele -> System.out.println(ele.getText()));
		long endTime1=System.currentTimeMillis();
		System.out.println("Time taken by parallel stream : "+(endTime1-stTime1));
	}
}
