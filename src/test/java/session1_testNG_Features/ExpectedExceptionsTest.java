package session1_testNG_Features;
import org.testng.annotations.Test;

public class ExpectedExceptionsTest {
	int age = 25;

	@Test(expectedExceptions = 
{ArithmeticException.class, NullPointerException.class})
	public void loginTest() {
		System.out.println("login page test");
		int i=9/0;
		
		ExpectedExceptionsTest obj=new ExpectedExceptionsTest();
		obj=null;
		System.out.println(obj.age);
	}
}
