package session5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {
	// SRP: Single Responsibility Pattern : Every class is reponsible for its own
	// functionality and
	// there should be only be one reason to change the code in this class
	public WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> doGetElements(By locator) {
		return driver.findElements(locator);
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public List<String> getAttributeList(By locator, String attributeName) {
		List<WebElement> eleList = doGetElements(locator);
		List<String> attrList = new ArrayList<String>();

		for (WebElement e : eleList) {
			String attrVal = e.getAttribute(attributeName);
			attrList.add(attrVal);
		}
		return attrList;
	}

	public List<String> getLinksTextList(By locator) {
		List<WebElement> list = doGetElements(locator);
		List<String> textList = new ArrayList<String>();

		for (WebElement e : list) {
			String text = e.getText();
			if (!text.isEmpty()) {
				textList.add(text);
			}
		}
		return textList;
	}

	public int getLinksCount(By locator) {
		return getLinksTextList(locator).size();
	}

	public List<WebElement> getLinksList(By locator) {
		return doGetElements(locator).stream().filter(e -> !e.getText().isEmpty()).collect(Collectors.toList());
	}
	
	/*if we pass wrong locator value to findElements();
	 * No exception will be thrown;
	 * instead list returned by findElements() = 0; 
	 */
	public void verifyElementsPresent(By locator) {
		List<WebElement> emailList = doGetElements(locator);
		System.out.println(emailList.size());

		try {
			if (emailList.size() == 0) {
				System.out.println("element not present");
				throw new Exception("ElementNotPresentException");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
