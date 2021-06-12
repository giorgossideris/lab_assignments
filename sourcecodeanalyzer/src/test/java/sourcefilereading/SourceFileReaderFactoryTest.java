package sourcefilereading;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SourceFileReaderFactoryTest {
	private final static String TYPE_LOCAL = "local";
	private final static String TYPE_WEB = "web";
	SourceFileReaderFactory readerFactory = new SourceFileReaderFactory();
	
	@Test
	public void testCreateSourceFileReaderLocal() {
		SourceFileReader reader = readerFactory.createSourceFileReader(TYPE_LOCAL);
		assertTrue(reader instanceof LocalFileReader);
	}
	
	@Test
	public void testCreateSourceFileReaderWeb() {
		SourceFileReader reader = readerFactory.createSourceFileReader(TYPE_WEB);
		assertTrue(reader instanceof WebFileReader);
	}
	
	@Test
	public void testCreateSourceFileReaderUnknown() {
		SourceFileReader reader = readerFactory.createSourceFileReader("unknown type");
		assertTrue(reader instanceof NullFileReader);
	}
}
