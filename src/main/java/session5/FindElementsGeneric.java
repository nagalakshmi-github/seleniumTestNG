package session5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsGeneric {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.amazon.in");

		By images = By.tagName("img");
		By links = By.tagName("a");

		/* for links*/
		System.out.println("actual list size : " + doGetElements(links).size());

		getLinksTextList(links).forEach(e -> System.out.println(e));
		if(getLinksTextList(links).contains("About Us")) {
			System.out.println("PASS");
		}

		System.out.println("non-empty text links count : " + getLinksCount(links));
		
		/* for attributes*/
		List<String> imgSrcAttrList=	getAttributeList(images, "alt");
		imgSrcAttrList.forEach(i -> System.out.println(i));
		
		List<String> linksHrefAttrList=	getAttributeList(links, "href");
		linksHrefAttrList.forEach(i -> System.out.println(i));
	}

	public static List<WebElement> doGetElements(By locator) {
		return driver.findElements(locator);
	}

	public static List<WebElement> getLinksList(By locator) {
		return doGetElements(locator)
				.stream()
					.filter(e -> !e.getText().isEmpty())
						.collect(Collectors.toList());
	}
	
	/* converting List<WebElement> to List<String> */
	public static List<String> getLinksTextList(By locator) {
		List<WebElement> txtList = getLinksList(locator);

		List<String> linksTxtList = new ArrayList<String>();

		txtList.forEach(ele -> linksTxtList.add(ele.getText()));
		return linksTxtList;
	}

	public static int getLinksCount(By locator) {
		return getLinksTextList(locator).size();
	}
	
	public static List<String> getAttributeList(By locator, String attr){
		List<WebElement> eleList = doGetElements(locator);
		
		List<String> attrTxtList = new ArrayList<String>();
		
		eleList
			.stream()
				.filter(e -> !(e.getAttribute(attr)==null || e.getAttribute(attr).isEmpty() ||e.getAttribute(attr).equals("javascript: void(0)") ))
						.collect(Collectors.toList())
							.forEach(ele -> attrTxtList.add(ele.getAttribute(attr)));
		
		return attrTxtList;
	}
}
