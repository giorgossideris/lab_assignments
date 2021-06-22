package facades;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

import metriccalculation.MetricCalculator;
import metriccalculation.MetricCalculatorFactory;
import metrics.MetricLoader;
import sourcefilereading.SourceFileReader;
import sourcefilereading.SourceFileReaderFactory;

/**
 * Calculates the metrics for a given file. 
 * @author giorgossideris
 *
 */
public class InformationGenerator {
	/**
	 * This method calculates the metrics given the essential parameters.
	 * 
	 * @param filepath               the path of the file to be analyzed. The file must contain Java code
	 * @param sourceCodeAnalyzerType the type of the analyzer that will be used (ex. regex)
	 * @param sourceFileLocation     the location that the file is saved (ex. local)
	 * @return metricsResults        a HashMap with the generated metrics. The keys refer to 
	 * 							     the metrics' names and the values to their corresponding values
	 * @exception IOException
	 * @see IOException
	 */
	public HashMap<String, Integer> calculateMetrics(String filepath, String sourceCodeAnalyzerType,
			String sourceFileLocation) throws IOException {
		// Load the metrics to be calculated
		MetricLoader.loadMetrics();
		// Read the file
		SourceFileReaderFactory readerFactory = new SourceFileReaderFactory();
		SourceFileReader reader = readerFactory.createSourceFileReader(sourceFileLocation);
		BufferedReader buffReader = reader.readFile(filepath);
		// Calculate the metrics
		MetricCalculatorFactory calculatorFactory = new MetricCalculatorFactory();
		MetricCalculator calculator = calculatorFactory.createMetricCalculator(sourceCodeAnalyzerType);
		HashMap<String, Integer> metricsResults = calculator.calculateAllMetrics(buffReader);
		return metricsResults;
	}
}
