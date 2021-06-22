package metrics;

/**
 * A metric for the number of methods.
 * @author giorgossideris
 *
 */
public class NumberOfMethods extends Metric {
	public NumberOfMethods() {
		super();
		super.setName("nom");
		super.setToReduceFromTotal(false);
		super.setRegexToCompile(".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*");
	}
	
	public boolean strcompLineChecker(String line) {
		return ((line.contains("public") || line.contains("private") || line.contains("protected"))
				|| line.contains("void") || line.contains("int") || line.contains("String"))
			   && line.contains("(") && line.contains(")") && line.contains("{");
	}
}
