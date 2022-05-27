package gr.aueb.dmst.nkakonas.math;

import java.util.ArrayList;

import gr.aueb.dmst.nkakonas.io.*;

public class ArrayOperations {
    
    public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
        int[] numbers = fileIo.readFile(filepath);
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (myMath.isPrime(numbers[i])) {
                primeNumbers.add(numbers[i]);
            }
        }
        int[] primeNumbersArray = new int[primeNumbers.size()];
        for (int i = 0; i < primeNumbers.size(); i++) {
            primeNumbersArray[i] = primeNumbers.get(i);
        }
        return primeNumbersArray;
    }

}
