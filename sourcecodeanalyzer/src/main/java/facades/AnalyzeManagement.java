package facades;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import metricsexport.MetricsExporter;
import metricsexport.MetricsExporterFactory;

/**
 * Analyzes the contents of a Java source code file 
 * and exports the calculated metrics to a given output. 
 * @author giorgossideris
 *
 */
public class AnalyzeManagement {
	private static InformationGenerator infGenerator = new InformationGenerator();
	/**
	 * This method executes the code analysis and exports the results.
	 * 
	 * @param filepath               the path of the file to be analyzed. The file must contain Java code.
	 * @param sourceCodeAnalyzerType the type of the analyzer that will be used (ex. regex).
	 * @param sourceFileLocation     the location that the file is saved (ex. local).
	 * @param outputFilePath         the path to the file to be the metrics exported.
	 * @param outputFileType         the type of the output file.
	 * @exception IOException
	 * @see IOException
	 */
	public void executeAnalysis(String filepath, String sourceCodeAnalyzerType, String sourceFileLocation,
			String outputFilePath, String outputFileType) throws IOException {
		HashMap<String, Integer> metrics = generateMetrics(filepath, sourceCodeAnalyzerType, sourceFileLocation);
		exportMetrics(outputFilePath, metrics, outputFileType);
	}
	
	/**
	 * This method calculates the metrics of the given file.
	 * 
	 * @param filepath               the path of the file to be analyzed. The file must contain Java code
	 * @param sourceCodeAnalyzerType the type of the analyzer that will be used (ex. regex)
	 * @param sourceFileLocation     the location that the file is saved (ex. local)
	 * @return metricsResults        a HashMap with the generated metrics. They keys refer to 
	 * 							     the metrics' names and the values to their corresponding values
	 * @exception IOException
	 * @see IOException
	 */
	private HashMap<String, Integer> generateMetrics(String filepath, String sourceCodeAnalyzerType,
			String sourceFileLocation) throws IOException {
		HashMap<String, Integer> metricsResults = infGenerator.calculateMetrics(filepath, sourceCodeAnalyzerType,
				sourceFileLocation);
		return metricsResults;
	}

	/**
	 * This method executes the metrics to a given file.
	 * 
	 * @param outputFilePath the path to the file to be the metrics exported.
	 * @param metricsResults a map that contains the calculated metrics
	 * @param outputFileType the type of the output file.
	 */
	private void exportMetrics(String outputFilePath,Map<String, Integer> metricsResults, String outputFileType) {
		MetricsExporterFactory meFactory = new MetricsExporterFactory();
		MetricsExporter exporter = meFactory.createMetricsExporter(outputFileType);
		exporter.writeToOutput(metricsResults, outputFilePath);
	}
}
