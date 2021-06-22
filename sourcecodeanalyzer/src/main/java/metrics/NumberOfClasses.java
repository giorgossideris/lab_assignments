package metrics;

/**
 * A metric for the number of classes.
 * @author giorgossideris
 *
 */
public class NumberOfClasses extends Metric {
	public NumberOfClasses() {
		super();
		super.setName("noc");
		super.setToReduceFromTotal(false);
		super.setRegexToCompile(".*\\s*class\\s+.*");
	}
	
	public boolean strcompLineChecker(String line) {
		return (line.startsWith("class ") || line.contains(" class ")) && line.contains("{");
	}
}
