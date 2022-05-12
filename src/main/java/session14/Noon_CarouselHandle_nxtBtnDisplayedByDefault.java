package session14;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Noon_CarouselHandle_nxtBtnDisplayedByDefault {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.noon.com/uae-en/");
		Thread.sleep(2000);

		String sectionName = "Further price drops on fragrances";

		By nxtBtn = By.xpath("//h3[text()='" + sectionName
				+ "']/../following-sibling::div/div[contains(@class,'swiper-button-next')]");
		By carouselProducts = By.xpath("//h3[text()='" + sectionName
				+ "']/../following-sibling::div//div[contains(@class,'swiper-wrapper')]/div");

		Set<String> productList = new LinkedHashSet<String>();

		// Calling pageLoad method inorder to get element visible to perform action on
		// it
		waitForPageToLoadCompletely();

		WebElement we = driver.findElement(By.xpath("//h3[text()='" + sectionName + "']"));

		List<WebElement> carouselItemsList = driver.findElements(carouselProducts);

		System.out.println("size:" + carouselItemsList.size());

		WebElement nxtBtnWE = driver.findElement(nxtBtn);

		while (!(nxtBtnWE.getAttribute("class")).contains("swiper-button-disabled")) {
			for (WebElement e : carouselItemsList) {
				productList.add(e.getText());
			}

			nxtBtnWE.click();
			carouselItemsList = driver.findElements(carouselProducts);
		}
		for (String s : productList) {
			System.out.println(s);
		}
	}

	public static void waitForPageToLoadCompletely() {
		long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
		int cont = 1000;
		try {
			while (true) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, " + cont + ");");
				Thread.sleep(2000);

				long newHeight = (long) ((JavascriptExecutor) driver)
						.executeScript("return document.body.scrollHeight");
				if (newHeight <= cont) {
					break;
				}
				cont += 500;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
