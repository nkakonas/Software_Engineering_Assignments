package gr.aueb.dmst.nkakonas.math;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * The MyMathParameterizedTest provides simple test
 * cases for the class MyMath using parameters.
 *
 * @author nkakoans
 * @version 1.0
 * @since 2022-05-23
 */
@RunWith (Parameterized.class)
public class MyMathParameterizedTest {
    
    /**
     * Fields used together with @Parameter must be public. We can use the @Parameter
     * annotation on public fields to get the test values injected in the test.
     */

    // num is the input for the method factorial in MyMath.java class
    @Parameter (value = 0)
    public int num;
    // result is the output of the method factorial in MyMath.java class
    @Parameter (value = 1)
    public int result;

    /**
     * This method generates and returns a collection of arrays. Each item
     * in this collection is used as parameter for the test method.
     */
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { {0, 1}, {1, 1}, {2, 2}, {12, 479001600} };
        return Arrays.asList(data);
    }

    // test that runs all the test cases from data[][]
    @Test
    public void testFactorialResult() {
        // object used to call the factorial method from MyMath class
        MyMath myMath = new MyMath();
        Assert.assertEquals(result, myMath.factorial(num));
    }

}
