package metricsexport;

import java.util.Map;

/**
 * An interface that provides the method for the metrics exporting.
 * @author giorgossideris
 *
 */
public interface MetricsExporter {
	/**
	 * This method exports the calculated metrics to the given file.
	 * 
	 * @param metrics   a Map with the generated metrics. The keys refer to 
	 * 				    the metrics' names and the values to their corresponding values
	 * @param filepath  the path to the file to be the metrics exported.
	 */
	public void writeToOutput(Map<String, Integer> metrics, String filepath);
}
