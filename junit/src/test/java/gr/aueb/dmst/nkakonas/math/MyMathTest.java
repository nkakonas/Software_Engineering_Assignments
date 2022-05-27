package gr.aueb.dmst.nkakonas.math;

import org.junit.Assert;
import org.junit.Test;

/**
 * The MyMathTest provides simple test cases for
 * the class MyMath for factorial exceptions.
 *
 * @author nkakoans
 * @version 1.0
 * @since 2022-05-23
 */
public class MyMathTest {
    /**
	 * This is an object from class MyMath, that we use in order to
     * call the methods from this class and check if they return the
     * expected results.
	 */
    MyMath myMath = new MyMath();

    /**
	 * tests if the method factorial throws an IllegalArgumentException,
	 * while using a number greater than 12 as an input.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFactorialGreaterThan12() {
		myMath.factorial(13);
	}

    /**
	 * tests if the method factorial throws an IllegalArgumentException,
	 * while using a negative number.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFactorialNegative() {
		myMath.factorial(-1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testIsPrimeNegativeNumber() {
		myMath.isPrime(-3);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testIsPrimeZero() {
		myMath.isPrime(0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testIsPrimePositiveNumberSmallerFrom2() {
		myMath.isPrime(1);
	}

	@Test
	public void testIsPrimeYes() {
		Assert.assertEquals(true, myMath.isPrime(3));
	}

	@Test
	public void testIsPrimeNo() {
		Assert.assertEquals(false, myMath.isPrime(4));
	}
}
