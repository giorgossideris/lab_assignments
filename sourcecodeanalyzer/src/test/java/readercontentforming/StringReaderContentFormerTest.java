package readercontentforming;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import types.SourceCode;

public class StringReaderContentFormerTest {
	StringReaderContentFormer stringFormer = new StringReaderContentFormer();
	static BufferedReader buffReader;
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	private static String expectedString;
	
	@BeforeClass
	public static void setUp() throws IOException {
		File file = new File(TEST_CLASS);
		buffReader = new BufferedReader(new FileReader(file));
		List<String >expectedList = Files.readAllLines(new File(TEST_CLASS).toPath(), Charset.defaultCharset());
		expectedString = String.join("\n", expectedList) + "\n"; // transforms a list into a String (with 'new line' as delimiter) 
	}
	
	@Test
	public void testFormReaderContent() throws IOException {
		SourceCode actualSourceCode = stringFormer.formReaderContent(buffReader);
		String actuals = actualSourceCode.getSourceCodeString();
		assertEquals(expectedString, actuals);
	}
}
