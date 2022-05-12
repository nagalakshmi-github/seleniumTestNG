package session13;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClass_DragNdrop {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");

		WebElement sourceEle = driver.findElement(By.id("draggable"));
		WebElement targetEle = driver.findElement(By.id("droppable"));

		Actions action = new Actions(driver);
		/* Approach1:
		action.clickAndHold(sourceEle)
				.moveToElement(targetEle)
					.release(sourceEle)
						.build()
							.perform();
		*/
		
		/* Approach2: */	
		action.dragAndDrop(sourceEle, targetEle).perform();
		
		
		/*code to get screenshot of a particular webelement : using selenium 4.0 feature
		File screenShotFile=targetEle.getScreenshotAs(OutputType.FILE);
		File copyScreenToFile=new File("SourceDroppedToTagetLoc.png");
		FileUtils.copyFile(screenShotFile,copyScreenToFile);
		*/
	}
}
