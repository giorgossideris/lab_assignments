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
}
