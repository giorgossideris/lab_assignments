package metriccalculation;

import metrics.Metric;
import types.SourceCode;

/**
 * Is used as Null Object for unknown analyzer type.
 * @author giorgossideris
 *
 */
public class NullMetricCalculator extends MetricCalculator {
	public int calculateMetricResult(SourceCode sourceCode, Metric metric) {
		return -1;
	}
}
