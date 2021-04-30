package math;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.Rule;

public class ArithmeticOperationsTest {
	
	ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
	
	//============ tests for divide() ================
	
	@Test
	public void test_divide_positive_positive_integerResult() {
		Assert.assertEquals(2, arithmeticOperations.divide(6, 3), 0.000001);
	}
	
	@Test
	public void test_divide_positive_positive_doubleResult() {
		Assert.assertEquals(2.5, arithmeticOperations.divide(10, 4), 0.000001);
	}
	
	@Test
	public void test_divide_positive_negative_integerResult() {
		Assert.assertEquals(-3, arithmeticOperations.divide(9, -3), 0.000001);
	}
	
	@Test
	public void test_divide_positive_negative_doubleResult() {
		Assert.assertEquals(-2.2, arithmeticOperations.divide(11, -5), 0.000001);
	}
	
	@Test
	public void test_divide_negative_positive_integerResult() {
		Assert.assertEquals(-10, arithmeticOperations.divide(-20, 2), 0.000001);
	}
	
	@Test
	public void test_divide_negative_positive_doubleResult() {
		Assert.assertEquals((double) -10/3, arithmeticOperations.divide(-20, 6), 0.000001);
	}
	
	@Test
	public void test_zero_numerator() {
		Assert.assertEquals(0, arithmeticOperations.divide(0, 2), 0.000001);
	}
	
	@Test (expected = ArithmeticException.class)
	public void test_divide_zero_denominator() {
		arithmeticOperations.divide(1, 0);
	}
	
	//=============== tests for multiply() ================
	
	@Test
	public void test_multiply_positiveInt_positiveInt() {
		Assert.assertEquals(35, arithmeticOperations.multiply(5, 7), 0.000001);
	}
	
	@Test
	public void test_multiply_zero_positive() {
		Assert.assertEquals(0, arithmeticOperations.multiply(0, 100), 0.000001);
	}
	
	@Test
	public void test_multiply_positive_zero() {
		Assert.assertEquals(0, arithmeticOperations.multiply(1, 0), 0.000001);
	}
	
	@Test
	public void test_multiply_zero_zero() {
		Assert.assertEquals(0, arithmeticOperations.multiply(0, 0), 0.000001);
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test 
	public void test_multiply_negativeInt_positiveInt() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		arithmeticOperations.multiply(-1, 3);
	}
	
	@Test 
	public void test_multiply_positiveInt_negativeInt() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		arithmeticOperations.multiply(2, -1);
	}
	
	@Test 
	public void test_multiply_negativeInt_negativeInt() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		arithmeticOperations.multiply(-1, -1);
	}
	
	@Test
	public void test_multiple_bigNumbers() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The product does not fit in an Integer variable");
		final int BIG_NUMBER_1 = (int) Integer.MAX_VALUE / 2, BIG_NUMBER_2 = (int) Integer.MAX_VALUE / 3;
		arithmeticOperations.multiply(BIG_NUMBER_1, BIG_NUMBER_2);
	}
}
