package gr.aueb.dmst.nkakonas.math;

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
	public void test_factorial_greater_than_12() {
		myMath.factorial(13);
	}

    /**
	 * tests if the method factorial throws an IllegalArgumentException,
	 * while using a negative number.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_factorial_negative() {
		myMath.factorial(-1);
	}
}
