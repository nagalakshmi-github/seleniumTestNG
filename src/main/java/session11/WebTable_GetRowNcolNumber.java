package session11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable_GetRowNcolNumber {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		int rowCount=driver.findElements(By.cssSelector("table#customers.ws-table-all tr")).size();
		int colCount=driver.findElements(By.cssSelector("table#customers.ws-table-all th")).size();
		System.out.println("rows count:"+rowCount);
		System.out.println("cols count:"+colCount);
		
		String txtCellValueFor="Canada";
		boolean flag=false;
		for(int i=2;i<=rowCount;i++) {
			for(int j=1;j<=colCount;j++) {
				String actualVal=driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+i+"]/td["+j+"]")).getText();
				if(actualVal.equals(txtCellValueFor)) {
					System.out.println("Canada is available at WebTable cell : "+i+"*"+j);
					flag=true;
					break;
				}
			}
		}
		
		if(flag)
			System.out.println(txtCellValueFor+" is present in the table data");
		else
			System.out.println(txtCellValueFor+" is not present in the table data");
	}
}
