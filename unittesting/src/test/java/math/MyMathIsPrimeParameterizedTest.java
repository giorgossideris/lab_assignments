package math;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import org.junit.Assert;

@RunWith (Parameterized.class)
public class MyMathIsPrimeParameterizedTest {

	@Parameter (value = 0)
	public int number; // the number that will be checked if it is prime
	
	@Parameter (value = 1)
	public boolean isPrime;
	
	MyMath myMath = new MyMath();
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {{2, true}, {12, false}, {71, true}, {993, false}};
		
		return Arrays.asList(data);
	}
	
	@Test
	public void testIsPrime() {
		Assert.assertEquals(isPrime, myMath.isPrime(number));
	}
}
