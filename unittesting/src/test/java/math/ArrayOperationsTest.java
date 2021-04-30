package math;

import io.FileIO;
import org.junit.Test;
import org.junit.Assert;

import static org.mockito.Mockito.*;

public class ArrayOperationsTest {

	ArrayOperations arrayOperations = new ArrayOperations();
	
	@Test
	public void testFindPrimesInFile() {
		
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
	
}
