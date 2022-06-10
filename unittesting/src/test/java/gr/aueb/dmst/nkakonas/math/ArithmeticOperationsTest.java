package gr.aueb.dmst.nkakonas.math;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.Rule;

/**
 * The ArithmeticOperationstest provides simple test
 * cases for the class ArithmeticOperations.
 *
 * @author nkakoans
 * @version 1.0
 * @since 2022-05-23
 */
public class ArithmeticOperationsTest {
	/**
	 * This is an object from class ArithmeticOperations, that we use
	 * in order to call the methods from this class and check if they
	 * return the expected results.
	 */
	ArithmeticOperations ath = new ArithmeticOperations();

	/**
	 * Every test case uses double numbers. The parameter delta
	 * for all the methods asserEqual below will be zero (0).
	 */

	// DIVIDE METHOD

	/**
	 * tests if the result from method divide is valid,
	 * while using (+, +) parameters.
	 */
	@Test
	public void test_divide_positive_numarator_positive_denominator() {
		Assert.assertEquals((double) 3 / 6, ath.divide(3, 6), 0);
	}

	/**
	 * tests if the result from method divide is valid,
	 * while using (+, -) parameters.
	 */
	@Test
	public void test_divide_positive_numarator_negative_denominator() {
		Assert.assertEquals((double) 29 / -9, ath.divide(29, -9), 0);
	}

	/**
	 * tests if the result from method divide is valid,
	 * while using (-, +) parameters.
	 */
	@Test
	public void test_divide_negative_numarator_positive_denominator() {
		Assert.assertEquals((double) -894 / 345, ath.divide(-894, 345), 0);
	}

	/**
	 * tests if the result from method divide is valid,
	 * while using (-, -) parameters.
	 */
	@Test
	public void test_divide_negative_numarator_negative_denominator() {
		Assert.assertEquals((double) -34546 / -4584, ath.divide(-34546, -4584), 0);
	}

	/**
	 * tests if the result from method divide is valid,
	 * while using (0, +) parameters.
	 */
	@Test
	public void test_divide_zero_numarator_positive_denominator() {
		Assert.assertEquals(0 / 678, ath.divide(0, 678), 0);
	}

	/**
	 * tests if the result from method divide is valid,
	 * while using (0, -) parameters.
	 */
	@Test
	public void test_divide_zero_numarator_negative_denominator() {
		Assert.assertEquals(0 / -678, ath.divide(0, -678), 0);
	}

	/**
	 * tests if the method divide throws an ArithmeticException,
	 * while using zero as a denominator (+, 0).
	 */
	@Test(expected = ArithmeticException.class)
	public void test_divide_positive_numarator_zero_denominator() {
		ath.divide(345, 0);
	}

	/**
	 * tests if the method divide throws an ArithmeticException,
	 * while using zero as a denominator (-, 0).
	 */
	@Test(expected = ArithmeticException.class)
	public void test_divide_negative_numarator_zero_denominator() {
		ath.divide(-345, 0);
	}

	/**
	 * tests if the method divide throws an ArithmeticException,
	 * while using zero as a denominator (0, 0).
	 */
	@Test(expected = ArithmeticException.class)
	public void test_divide_zero_numarator_zero_denominator() {
		ath.divide(0, 0);
	}

	// MULTIPLY METHOD

	/**
	 * Tests if the result from method multiply is valid, while using
	 * (+, +) parameters - VALID.
	 */
	@Test
	public void test_multiply_both_positive_valid() {
		Assert.assertEquals(2345 * 4567, ath.multiply(2345, 4567), 0);
	}

	/**
	 * Tests if the result from method multiply is valid, while using
	 * (0, +) parameters - VALID.
	 */
	@Test
	public void test_multiply_zero_positive_valid() {
		Assert.assertEquals(0 * 23, ath.multiply(0, 23), 0);
	}

	/**
	 * This is a Rule for ExpectedException, that allows us to verify
	 * that our code throws a specific exception.
	 */
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * Tests if the result from method multiply is valid, while using
	 * (+, -) parameters - VALID.
	 */
	@Test
	public void test_multiply_positive_negative_valid() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		ath.multiply(78, -23);
	}

	/**
	 * Tests if the result from method multiply is valid, while using
	 * (-, +) parameters - VALID.
	 */
	@Test
	public void test_multiply_negative_positive_valid() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		ath.multiply(-78, 23);
	}

	/**
	 * Tests if the result from method multiply is valid, while using
	 * (-, -) parameters - VALID.
	 */
	@Test
	public void test_multiply_both_negative_valid() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		ath.multiply(-78, -23);
	}

	/**
	 * Tests if the result from method multiply is valid, while using
	 * (0, -) parameters - VALID.
	 */
	@Test
	public void test_multiply_zero_negative_valid() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		ath.multiply(0, -23);
	}

	/**
	 * Tests if the result from method multiply is valid, while using
	 * (-, 0) parameters - VALID.
	 */
	@Test
	public void test_multiply_negative_zero_valid() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		ath.multiply(-2345, 0);
	}

	/**
	 * Tests if the method multiply throws a IllegalArithmeticException
	 * and if it throws the expected message, while using (+, +) parameters
	 * - NOT valid.
	 */
	@Test
	public void test_multiply_both_positive_not_valid() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The product does not fit in an Integer variable");
		ath.multiply(2147483646, 678);
	}


	/**
	 * Tests if the method multiply throws a ArithmeticException,
	 * while using (+, 0) parameters.
	 */
	@Test
	public void test_multiply_positive_zero_not_valid() {
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage("x & y should be >= 0");
		ath.multiply(6734, 0);
	}

	/**
	 * Tests if the result from method multiply is valid, while using
	 * (0, 0) parameters - not VALID.
	 */
	@Test
	public void test_multiply_both_zero_valid() {
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage("x & y should be >= 0");
		ath.multiply(0, 0);
	}

	/**
	 * Tests if the result from method multiply is valid, while using
	 * (+, 0) parameters - not VALID.
	 */
	@Test
	public void test_multiply_positive_zero_valid() {
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage("x & y should be >= 0");
		ath.multiply(234, 0);
	}

}
