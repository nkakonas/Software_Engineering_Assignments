package gr.aueb.dmst.nkakonas.math;

/**
* The MyMath calculates the factorial of a number
* that serve as hands-on practice on Unit Testing.
*
* @author  nkakonas
* @version 1.0
* @since   2022-05-24 
*/
public class MyMath {
    
    /**
	 * Performs the calculation of factorial of an integer.
	 * @param n the integer that we calculate the factorial
	 * @return the result of the factorial of the given number (n)
	 * @exception IllegalArgumentException when n < 0 or n > 12
	 */
    public int factorial(int n) {
        if (n < 0 || n > 12)
            throw new IllegalArgumentException("The given number should be in [0, 12]");
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

}
