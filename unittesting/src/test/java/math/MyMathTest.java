package math;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.Rule;

public class MyMathTest {
	
	MyMath myMath = new MyMath();
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test 
	public void test_factorial_negative() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("n should be >= 0");
		myMath.factorial(-1);
	}
	
	@Test 
	public void test_factorial_large() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("n should be <= 12");
		myMath.factorial(13);
	}

}