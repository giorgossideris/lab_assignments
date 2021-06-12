package metricsexport;

import org.junit.Test;

public class NullExporterTest {
	NullExporter nullExp = new NullExporter("unknown");
	
	@Test(expected = IllegalArgumentException.class)
	public void testWriteToOutput() {
		nullExp.writeToOutput(null, null);
	}
}
