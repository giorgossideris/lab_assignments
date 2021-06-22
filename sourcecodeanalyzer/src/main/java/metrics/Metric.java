package metrics;

import java.util.ArrayList;
import java.util.List;

/**
 * Metric is the abstract base class of the metrics that can be calculated.
 * @author giorgossideris
 *
 */
public abstract class Metric {
	/**
	 * The name of the metric, that will be written in the exported file.
	 */
	private String name;
	/**
	 * It is <code>true</code> if the counted lines must be reduced from the total lines.
	 * Else, it is <code>false</code> as the counted lines are the metric requested.
	 */
	private boolean toReduceFromTotal;
	/**
	 * The regex to be compiled in order to calculate the metric, refers
	 * to the metric calculators from String.
	 */
	private String regexToCompile;
	/**
	 * The List with the metrics to be calculated.
	 */
	private static List<Metric> metrics = new ArrayList<Metric>();
	/**
	* Class constructor.
	*/
	public Metric() {
		metrics.add(this);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static List<Metric> getMetrics() {
		return metrics;
	}

	public static void setMetrics(List<Metric> metrics) {
		Metric.metrics = metrics;
	}

	public boolean isToReduceFromTotal() {
		return toReduceFromTotal;
	}

	public void setToReduceFromTotal(boolean toReduceFromTotal) {
		this.toReduceFromTotal = toReduceFromTotal;
	}
	
	public String getRegexToCompile() {
		return regexToCompile;
	}

	public void setRegexToCompile(String regexToCompile) {
		this.regexToCompile = regexToCompile;
	}
	
	/**
	 * This method checks if the line is to be counted within the metric, using strcomp. 
	 * @param line   the line to be checked
	 * @return <code>true</code> if the line must be inclued to the metric, else <code>false</code>
	 */
	public abstract boolean strcompLineChecker(String line);
}
