package metricsexport;

import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class JsonExporterTest {
	JsonExporter jsonExp = new JsonExporter();
	
	@Test
	public void testWriteToOutput() {
		MetricsExporter mockedExporter = mock(JsonExporter.class);
		// create an empty metrics content
		Map<String, Integer> metrics = new HashMap<>();
		String outputFilepath = "whatever-path";
		
		//this is a demo of how a mocked object can call a real method (partial mocking)
		doCallRealMethod().when(mockedExporter).writeToOutput(metrics, outputFilepath);
		mockedExporter.writeToOutput(metrics, outputFilepath);
		//just verify that the method was executed/called
		verify(mockedExporter).writeToOutput(metrics, outputFilepath);
	}
}
