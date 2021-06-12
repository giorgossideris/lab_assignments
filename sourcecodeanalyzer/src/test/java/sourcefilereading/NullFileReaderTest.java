package sourcefilereading;

import org.junit.Test;

public class NullFileReaderTest {
	NullFileReader nullReader = new NullFileReader();
	
	@Test(expected = IllegalArgumentException.class)
	public void testReadFile() {
		nullReader.readFile("a filepath");
	}
}
