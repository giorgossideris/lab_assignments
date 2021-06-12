package metrics;

/**
 * Loads the metrics to be calculated.
 * @author giorgossideris
 *
 */
public class MetricLoader {
	/**
	 * This method creates and object for each of the metric to be calculated.
	 */
	public static void loadMetrics() {
		new LinesOfCode();
		new NumberOfClasses();
		new NumberOfMethods();
	}
}
