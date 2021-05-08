package math;

import io.FileIO;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.Rule;

import static org.mockito.Mockito.*;

public class ArrayOperationsTest {

	ArrayOperations arrayOperations = new ArrayOperations();
	FileIO fileIO = new FileIO();
	MyMath myMath = new MyMath();
	
	@Test
	public void testFindPrimesInFileValid() {
		
		FileIO fio = mock(FileIO.class);
		when(fio.readFile("numbers.txt")).thenReturn(new int[] {3, 55, 101, 24});
		
		MyMath mm = mock(MyMath.class);
		
		when(mm.isPrime(3)).thenReturn(true);
		when(mm.isPrime(24)).thenReturn(false);
		when(mm.isPrime(55)).thenReturn(false);
		when(mm.isPrime(101)).thenReturn(true);
		
		
		int[] expectedNumbers = new int[] {3, 101};
		Assert.assertArrayEquals(expectedNumbers, arrayOperations.findPrimesInFile(fio, "numbers.txt", mm));
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testFindPrimesInFileNonExistentFile() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input file does not exist");
		arrayOperations.findPrimesInFile(fileIO, "src/test/resources/non_existent.txt", myMath);
	}
	
	@Test
	public void testFindPrimesInFileEmptyFile() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Given file does not contain any valid values");
		arrayOperations.findPrimesInFile(fileIO, "src/test/resources/empty.txt", myMath);
	}
	
	@Test
	public void testFindPrimesInFileNumberLessThan2() {
		
		FileIO fio = mock(FileIO.class);
		when(fio.readFile("numbers.txt")).thenReturn(new int[] {-2, 5, 1, 0, 7});
		
		int[] expectedNumbers = new int[] {5, 7};
		Assert.assertArrayEquals(expectedNumbers, arrayOperations.findPrimesInFile(fio, "numbers.txt", myMath));
	}
	
	@Test
	public void testFindPrimesInFileNoPrimes() {
		
		FileIO fio = mock(FileIO.class);
		when(fio.readFile("numbers.txt")).thenReturn(new int[] {-2, 0, 4, 20});
		
		int[] expectedNumbers = new int[] {};
		Assert.assertArrayEquals(expectedNumbers, arrayOperations.findPrimesInFile(fio, "numbers.txt", myMath));
	}
	
	
	
	
}
