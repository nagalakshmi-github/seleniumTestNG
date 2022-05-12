package session2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DifferentDrivers {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\DKLM\\Learnings\\Laxmi learnings\\Laxmi_software_downloads\\selenium_req_installables\\browsers\\chromedriver_win32\\chromedriver.exe");

		//Possible ways of Top Casting or creating connections b/w parent and child components:
		//1 -- not recommended; we can access only 2 methods as findElement() and findElements()
		//SearchContext sc= new ChromeDriver();
		//sc.findElement(null);
		//sc.findElements(null);
		
		
		//Note: remote webdriver is used when we need to execute our scripts on remote machine like AWS Cloud/Dockerized Grid; but on local machine
		//2 -- not recommended 
		//WebDriver driver= new RemoteWebDriver(null, null);
		
		//3 -- not recommended
		//SearchContext sc = new RemoteWebDriver(null);
		
		//4 --recommended
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.com"); // enter the url
		String title = driver.getTitle();
		System.out.println(title);
		
		//5 --most recommended
		WebDriver dr= new ChromeDriver();
		
		//Out of 4 and 5 options , which option is the most recommended?
		//Ans: Option 5 ; because, 
		//advantage 1: in case of cross-browser testing we need to switch between different browsers ; which is not possible with option 4
		//advantage 2: in case of multi-threading concept ie parallel execution, suppose i create 3 threads as 
		//thread1(browser =chrome), thread2(browser=firefox), thread3(browser= safari) 
		//and as code remains same but the driver will be divided into 3 parts and the script we execute on browser differs based on threads
	}
}
