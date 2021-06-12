package metriccalculation;

import metrics.Metric;
import readercontentforming.StringReaderContentFormer;
import types.SourceCode;

/**
 * MetricsCalculatorFromString is an abstract class that allows the calculation 
 * of metrics using analysis' methods that require an input as a String.
 * @author giorgossideris
 *
 */
public abstract class MetricCalculatorFromString extends MetricCalculator {
	/**
	 * The contentFormer of the reader set to String former.
	 */
	
	public MetricCalculatorFromString () {
		super();
		super.setContentFormer(new StringReaderContentFormer());
	}

	public abstract int calculateMetricResult(SourceCode sourceCode, Metric metric);
}
