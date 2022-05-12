package session1_testNG_Features;
import org.testng.annotations.Test;

public class InvocationCount {

	@Test(invocationCount=5, priority= 1, expectedExceptions = ArithmeticException.class)
	public void registerTest() {
		System.out.println("register test method");
	}
}
