package math;

/**
* The MyMath provide advanced math operations, 
* that serve as hands-on practice on Unit Testing.
*
* @author  giorgossideris
*/
public class MyMath {

	/**
	 * Performs the calculation of the factorial of a number.
	 * @param n the input
	 * @return the factorial of the number
	 * @exception IllegalArgumentException when <b>n</b> is negative
	 * @exception IllegalArgumentException when <b>n</b> is larger than 12 
	 */
	public int factorial (int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n should be >= 0");
		} else if (n <= 12) {
			int fact = 1;
			for (int i = 2; i <= n; i++) {
				fact *= i;
			}
			return fact;
		} else {
			throw new IllegalArgumentException("n should be <= 12");		
		}
	}
	
	/**
	 * Checks if the given number is prime.
	 * @param n the input
	 * @return true if <b>n</b> is prime, else false
	 * @exception IllegalArgumentException when <b>n</b> is less than 2
	 */
	public boolean isPrime(int n) {
		if (n < 2) {
			throw new IllegalArgumentException("n should be >= 2");
		}
		for (int divisor = 2; divisor < n; divisor++) {
			if (n % divisor == 0) {
				return false;
			}
		}
		return true;
	}
}
