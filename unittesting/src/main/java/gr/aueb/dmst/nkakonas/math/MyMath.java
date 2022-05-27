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

    /**
	 * Calculates if a number is prime
	 * @param n the integer that we say if it is prime
	 * @return true if it is prime and fasle if not
	 * @exception IllegalArgumentException when n < 2
	 */
    public boolean isPrime(int n) {
        if (n < 2) throw new IllegalArgumentException();
        boolean prime = true;
        if(n <= 1) {
            prime = false;
            return prime;
        } else {
            for (int i = 2; i<= n/2; i++) {
                if ((n % i) == 0) {
                    prime = false;
                    break;
                }
            }
        return prime;
        }
    }
}
