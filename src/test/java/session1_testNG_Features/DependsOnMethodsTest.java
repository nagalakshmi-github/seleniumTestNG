package session1_testNG_Features;
import org.testng.annotations.Test;

public class DependsOnMethodsTest {
	@Test
	public void loginTest() {
		System.out.println("login test");
	}

	@Test(dependsOnMethods="loginTest")
	public void homePageTest() {
		System.out.println("home page test");
	}

	@Test(dependsOnMethods="loginTest")
	public void cartPageTest() {
		System.out.println("cart page test");
	}
}
