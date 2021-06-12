package metricsexport;

/**
 * The factory for the metrics exporters.
 * @author giorgossideris
 *
 */
public class MetricsExporterFactory {
	/**
	 * This method creates the appropriate MetricsExporter.
	 * 
	 * @param outputType    the type of the output file.
	 */
	public MetricsExporter createMetricsExporter(String outputType) {
		MetricsExporter exporter;
		if (outputType.equals("csv")) {
			exporter = new CsvExporter();
		} else if (outputType.equals("json")) {
			exporter = new JsonExporter();
		} else {
			exporter = new NullExporter(outputType);
		}
		return exporter;
	}
}
