package metriccalculation;

import metrics.Metric;
import readercontentforming.ListReaderContentFormer;
import types.SourceCode;

/**
 * MetricsCalculatorFromList is an abstract class that allows the calculation
 * of metrics using analysis' methods that require an input as a List.
 * @author giorgossideris
 *
 */
public abstract class MetricCalculatorFromList extends MetricCalculator {
	/**
	 * The contentFormer of the reader set to List former.
	 */
	
	public MetricCalculatorFromList () {
		super();
		super.setContentFormer(new ListReaderContentFormer());
	}

	public abstract int calculateMetricResult(SourceCode sourceCode, Metric metric);
}
