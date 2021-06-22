package metriccalculation;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

import metrics.Metric;
import readercontentforming.ReaderContentFormer;
import types.SourceCode;

/**
 * MetricsCalculator is the abstract base class which allows the programs
 * to execute metrics' calculations using different types of analysis.
 * @author giorgossideris
 *
 */
public abstract class MetricCalculator {
	/**
	 * The former of the read source code into the appropriate type.
	 */
	private ReaderContentFormer contentFormer;
	
	public ReaderContentFormer getContentFormer() {
		return contentFormer;
	}

	public void setContentFormer(ReaderContentFormer contentFormer) {
		this.contentFormer = contentFormer;
	}

	/**
	 * This method calculates the metrics for the given file.
	 * 
	 * @param filepath               the path of the file to be analyzed. The file must contain Java code
	 * @return metricsResults        a HashMap with the generated metrics. They keys refer to 
	 * 							     the metrics' names and the values to their corresponding values
	 * @exception IOException
	 * @see IOException
	 */
	public HashMap<String, Integer> calculateAllMetrics(BufferedReader buffReader) throws IOException {
		SourceCode sourceCode = getContentFormer().formReaderContent(buffReader);
		HashMap<String, Integer> metricsResults = new HashMap<String, Integer>();
		for (Metric metric: Metric.getMetrics()) {
			int result = calculateMetricResult(sourceCode, metric);
			metricsResults.put(metric.getName(), result);
		}
		return metricsResults;
	}
	
	/**
	 * This method calculates a single metric for the read code.
	 * 
	 * @param sourceCode             the source code that a reader has already read
	 * @param metric				 the metric to be calculated
	 * @return metricsResult         the value of the requested metric for the particular code
	 */
	public abstract int calculateMetricResult(SourceCode sourceCode, Metric metric);
}
