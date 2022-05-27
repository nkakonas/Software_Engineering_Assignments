package gr.aueb.dmst.nkakonas.io;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.Rule;

/**
 * The FileIOTest provides simple test cases for
 * the class FileIO
 *
 * @author nkakoans
 * @version 1.0
 * @since 2022-05-23
 */
public class FileIOTest {
    /**
	 * This is an object from class FileIO, that we use in order to
     * call the methods from this class and check if they return the
     * expected results.
	 */
    FileIO file = new FileIO();

    /**
     * Tests if the numbers from file numbers.txt are
     * returned correctly from readFile method
     */
    @Test
    public void testNumbers() {
        Assert.assertArrayEquals(new int[] {0,1,2,3,4,5,6}, file.readFile("src/test/resources/numbers.txt"));
    }

    /**
	 * This is a Rule for ExpectedException, that allows us to verify
	 * that our code throws a specific exception.
	 */
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * Tests if the method readFile throws the IllegalArgumentException
     * and checks if it prints the correct message, when the input file
     * does not exists anything.
     */
    @Test
	public void testNumbersWrongPath() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input file does not exist");
        file.readFile("src/math/dmst/aueb/numbers.txt");
	}

    /**
     * Tests if the method readFile throws the IllegalArgumentException
     * and checks if it prints the correct message, when the input file
     * path is not correct.
     */
    @Test
	public void testNoNumbers() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Given file is empty");
        file.readFile("src/test/resources/noNumbers.txt");
	}

    /**
     * Tests if the method readFile can return only the integer
     * values of a file, while containing many type variables.
     */
    @Test
    public void testReadFileContainsInvalidEntries() {
        Assert.assertArrayEquals(new int[] {345, 76, 2345, 99}, file.readFile("src/test/resources/invalidEntries.txt"));
    }
}
