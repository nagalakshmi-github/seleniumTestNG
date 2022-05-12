package session1_testNG_Features;
import org.testng.annotations.Test;

public class EnableOrDisableTest {
	@Test(priority=2)
	public void a_test() {
		System.out.println("a test");
	}

	@Test(enabled=false)
	public void e_test() {
		System.out.println("e test");
	}

	@Test
	public void f_test() {
		System.out.println("f test");
	}
}
