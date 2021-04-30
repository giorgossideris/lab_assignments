package math;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.FileIO;

public class ArrayOperations {
	
	/**
	 * Finds the prime numbers in a given file.
	 * @param fileIo an instance of the class FileIO
	 * @param filePath the path that the file will be found
	 * @param myMath an instance of the class MyMath
	 * @return an array of the prime numbers in the requested file
	 * @exception IllegalArgumentException when the given file does not exist
	 * @exception IllegalArgumentException when the given file is empty
	 */
	public int[] findPrimesInFile(FileIO fileIo, String filePath, MyMath myMath) {
		
		int[] numbersInFile = fileIo.readFile(filePath);
		List<Integer> primesList = new ArrayList<>();
		
		for (int number : numbersInFile) {
			try {
				if (myMath.isPrime(number)) {
					primesList.add(number);
				}
			} catch (IllegalArgumentException iae) { // in case number < 2
				continue;
			}	
		}
		
		// convert the List to array and return it
		return primesList.stream().mapToInt(i -> i).toArray();
		
	}
}
