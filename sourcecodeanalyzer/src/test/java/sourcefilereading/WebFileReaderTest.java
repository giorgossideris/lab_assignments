package sourcefilereading;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.junit.Test;

public class WebFileReaderTest {
	WebFileReader webReader = new WebFileReader();
	private final static String TEST_CLASS_WEB ="https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";
	
	@Test
	public void testReadFile() throws IOException {
		URL url = new URL(TEST_CLASS_WEB);
        BufferedReader expectedBuffReader = new BufferedReader(new InputStreamReader(url.openStream()));
		BufferedReader buffReader = webReader.readFile(TEST_CLASS_WEB);
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
