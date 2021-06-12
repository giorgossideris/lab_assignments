package metricsexport;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MetricsExporterFactoryTest {
	private final static String TYPE_CSV = "csv";
	private final static String TYPE_JSON = "json";
	MetricsExporterFactory expFactory = new MetricsExporterFactory();
	
	@Test
	public void testCreateMetricsExporterCsv() {
		MetricsExporter exporter = expFactory.createMetricsExporter(TYPE_CSV);
		assertTrue(exporter instanceof CsvExporter);
	}
	
	@Test
	public void testCreateMetricsExporterJson() {
		MetricsExporter exporter = expFactory.createMetricsExporter(TYPE_JSON);
		assertTrue(exporter instanceof JsonExporter);
	}
	
	@Test
	public void testCreateMetricsExporterUknown() {
		MetricsExporter exporter = expFactory.createMetricsExporter("uknown type");
		assertTrue(exporter instanceof NullExporter);
	}
}
