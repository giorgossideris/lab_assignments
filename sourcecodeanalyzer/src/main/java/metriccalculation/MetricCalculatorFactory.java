package metriccalculation;

/**
 * The factory for the MetricCalculators.
 * @author giorgossideris
 *
 */
public class MetricCalculatorFactory {
	/**
	 * This method creates the appropriate MetricCalculator.
	 * 
	 * @param AnalyzerType           the type of the analyzer that will be used (ex. regex).
	 * @param sourceType             the location that the file is saved (ex. local).
	 * @return calculator            the appropriate calculator.
	 */
	public MetricCalculator createMetricCalculator(String analyzerType) {
		MetricCalculator calculator;
		if (analyzerType.equals("regex")) {
			calculator = new RegexMetricCalculator();
		} else if (analyzerType.equals("strcomp")) {
			calculator = new StrcompMetricCalculator();
		} else {
			calculator = new NullMetricCalculator();
		}
		return calculator;
	}
}
