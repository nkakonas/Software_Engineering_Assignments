package gr.aueb.dmst.nkakonas.math;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

import gr.aueb.dmst.nkakonas.io.FileIO;

public class ArrayOperationsTest {
    
    ArrayOperations arrayOperations = new ArrayOperations();

    @Test
    public void test_primeArray_Mocking() {
        // Mock the MyMath dependence
        MyMath myMath = mock(MyMath.class);
        // Mock the FileIO dependence
        FileIO fileIo = mock(FileIO.class);

        ArrayOperations arrayOperations = new ArrayOperations();

        String filepath = "src/test/resources/primeNumbers.txt";
        int[] fileValues = new int[] {2,3,4,5,6,7,8,9,11,13};
        int[] expectedValues = new int[] {2,3,5,7,11,13};

        when(fileIo.readFile(filepath)).thenReturn(fileValues);

        when(myMath.isPrime(2)).thenReturn(true);
        when(myMath.isPrime(3)).thenReturn(true);
        when(myMath.isPrime(4)).thenReturn(false);
        when(myMath.isPrime(5)).thenReturn(true);
        when(myMath.isPrime(6)).thenReturn(false);
        when(myMath.isPrime(7)).thenReturn(true);
        when(myMath.isPrime(8)).thenReturn(false);
        when(myMath.isPrime(9)).thenReturn(false);
        when(myMath.isPrime(11)).thenReturn(true);
        when(myMath.isPrime(13)).thenReturn(true);

        Assert.assertArrayEquals(expectedValues, arrayOperations.findPrimesInFile(fileIo, filepath, myMath));
    }

}