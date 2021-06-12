package readercontentforming;

import static org.junit.Assert.assertArrayEquals;

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

public class ListReaderContentFormerTest {
	ListReaderContentFormer listFormer = new ListReaderContentFormer();
	static BufferedReader buffReader;
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	private static List<String> expectedList;
	
	@BeforeClass
	public static void setUp() throws IOException {
		File file = new File(TEST_CLASS);
		buffReader = new BufferedReader(new FileReader(file));
		expectedList = Files.readAllLines(new File(TEST_CLASS).toPath(), Charset.defaultCharset());
	}
	
	@Test
	public void testFormReaderContent() throws IOException {
		SourceCode actualSourceCode = listFormer.formReaderContent(buffReader);
		List<String >actualList = actualSourceCode.getSourceCodeList();
		
		String[] expecteds = expectedList.stream().toArray(String[]::new);
		String[] actuals = actualList.stream().toArray(String[]::new);

		assertArrayEquals(expecteds, actuals);
	}
}
