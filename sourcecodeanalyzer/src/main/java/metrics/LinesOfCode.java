package metrics;

/**
 * A metric for the lines of code.
 * @author giorgossideris
 *
 */
public class LinesOfCode extends Metric {
	public LinesOfCode() {
		super();
		super.setName("loc");
		super.setToReduceFromTotal(true);
		super.setRegexToCompile("((//.*)|(/\\*.*)|(\\*+.*))");
	}
	
	public boolean strcompLineChecker(String line) {
		return line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("{") || line.equals("}") || line.equals("");
	}
}
