package metriccalculation;

import java.util.List;

import metrics.Metric;
import types.SourceCode;

/**
 * Calculates the metrics using strcomp analysis.
 * @author giorgossideris
 *
 */
public class StrcompMetricCalculator extends MetricCalculatorFromList {
	@Override
	public int calculateMetricResult(SourceCode sourceCode, Metric metric) {
		List<String> sourceCodeList = sourceCode.getSourceCodeList();
		int result = 0;
		for (String line : sourceCodeList) {
			line = line.stripLeading().stripTrailing(); //clear all leading and trailing white spaces
			if (metric.strcompLineChecker(line))
				result++;
		}

		if (metric.isToReduceFromTotal()) {
        	int sourceFileLength = sourceCodeList.size();
            result =  sourceFileLength - result;
        }
		
		return result; 
	}
}
