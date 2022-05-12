package session7;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
	
	/******************* "Select class based Drop Downs with <Select> tag" Utils **************************/
	public void doSelectDropDownByIndex(By locator, int index) {
		Select sel=new Select(getElement(locator));
		sel.selectByIndex(index);
	}
	
	public void doSelectDropDownByValue(By locator, String value) {
		Select sel=new Select(getElement(locator));
		sel.selectByValue(value);
	}
	
	public void doSelectDropDownByVisibleText(By locator, String text) {
		Select sel=new Select(getElement(locator));
		sel.selectByVisibleText(text);
	}
	
	/*generic function using getOptions() to get text for all values in a dropdown*/
	public List<String> doGetAllDropDownOptions(By locator) {
		Select select = new Select(getElement(locator));

		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());

		List<String> optionsTextList = new ArrayList<String>();

		for (WebElement e : optionsList) {
			optionsTextList.add(e.getText());
		}
		return optionsTextList;
	}
	
	/*generic function using getOptions() for selecting dropdown value and without using selectByIndex()/value()/visibleText() methods*/
	public void doSelectDropDownValue(By locator, String value) {
		Select select = new Select(getElement(locator));

		List<WebElement> optionsList = select.getOptions();
		for (WebElement e : optionsList) {
			String text=e.getText();
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	/******************* "Without using Select class -  Drop Downs operations" Utils **************************/
	public void selectDropDownValue(By locator, String value) {
		List<WebElement> optionsList = doGetElements(locator);

		for (WebElement e : optionsList) {
			if (e.getText().contains(value)) {
				e.click();
				break;
			}
		}
	}
	
	
	/*
	 * TC 01: Single choice selection ; TC 02: Multiple choices selection ; TC 03: All choices selection with unique identifier 'automation_all'
	 */
	public void selectChoice(By locator, String... value) {
		List<WebElement> choiceList = driver.findElements(locator);

		if (!value[0].equalsIgnoreCase("automation_all")) {
			for (int i = 0; i < choiceList.size(); i++) {
				String text = choiceList.get(i).getText();
				System.out.println(text);

				for (int j = 0; j < value.length; j++) {
					if (text.equals(value[j])) {
						choiceList.get(i).click();
						break;
					}
				}
			}
		}else {
			//select all the choices
			//choiceList.stream().filter(t -> t.isDisplayed()).forEach(e-> e.click());
			try {
				for(WebElement e:choiceList) {
					e.click();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("All displayed choices in the jquery dropdown are selected....");
			}
		}
	}
}
