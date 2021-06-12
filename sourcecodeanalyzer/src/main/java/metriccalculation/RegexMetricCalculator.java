package metriccalculation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import metrics.Metric;
import types.SourceCode;

/**
 * Calculates the metrics using regex analysis.
 * @author giorgossideris
 *
 */
public class RegexMetricCalculator extends MetricCalculatorFromString{
	@Override
	public int calculateMetricResult(SourceCode sourceCode, Metric metric) {
		String sourceCodeStr = sourceCode.getSourceCodeString();
		Pattern pattern = Pattern.compile(metric.getRegexToCompile());
        Matcher patternMatcher = pattern.matcher(sourceCodeStr);

        int result = 0;
        while (patternMatcher.find()) {
        	result++;
        }
		
        if (metric.isToReduceFromTotal()) {
        	int sourceFileLength = sourceCodeStr.split("\n").length;
            result =  sourceFileLength - result;
        }

		return result;
	}
}
