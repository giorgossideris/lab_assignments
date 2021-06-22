package sourcefilereading;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class LocalFileReaderTest {
	LocalFileReader locReader = new LocalFileReader();
	private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
	
	@Test
	public void testReadFile() throws IOException {
		BufferedReader expectedBuffReader = new BufferedReader(new FileReader(new File(TEST_CLASS_LOCAL)));
		BufferedReader buffReader = locReader.readFile(TEST_CLASS_LOCAL);
		String line = null;
		String expectedLine = null;
		while ((line = buffReader.readLine()) != null) {
			expectedLine = expectedBuffReader.readLine();
			assertEquals(line, expectedLine);
		}
		// to check that both buffered readers finished the same time
		expectedLine = expectedBuffReader.readLine();
		assertEquals(line, expectedLine);
		expectedBuffReader.close();
		buffReader.close();
	}
}
