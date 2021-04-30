package io;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.Rule;
import java.io.IOException;

public class FileIOTest {

	FileIO fileIO = new FileIO();
	public static String resourcesPath = "src/test/resources/";
	
	@Test
	public void testReadFileValidInput() {
		int[] expectedNumbers = new int[] {1, 2, 3, 145, 0, -12};
		String validInputFilePath = resourcesPath.concat("numbers_valid.txt");
		Assert.assertArrayEquals(expectedNumbers, fileIO.readFile(validInputFilePath));
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testReadFileNonExistentFile() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input file does not exist");
		String nonExistentFilePath = resourcesPath.concat("non_existent.txt");
		fileIO.readFile(nonExistentFilePath);
	}
	
	@Test
	public void testReadFileEmptyFile() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Given file does not contain any valid values");
		String emptyFilePath = resourcesPath.concat("empty.txt");
		fileIO.readFile(emptyFilePath);
	}
	
	@Test
	public void testReadFileContainsInvalidEntries() {
		int[] expectedNumbers = new int[] {1, -7, 1234, 12};
		String invalidEntriesFilePath = resourcesPath.concat("invalid_entries.txt");
		Assert.assertArrayEquals(expectedNumbers, fileIO.readFile(invalidEntriesFilePath));
	}
	
	@Test
	public void testReadFileOnlyInvalidEntries() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Given file does not contain any valid values");
		String onlyInvalidEntriesFilePath = resourcesPath.concat("only_invalid_entries.txt");
		fileIO.readFile(onlyInvalidEntriesFilePath);
	}
	
}
