package metrics;

import org.junit.Assert;
import org.junit.Test;

public class NumberOfClassesTest {
	NumberOfClasses noc = new NumberOfClasses();
	
	@Test
	public void testStrcompLineCheckerStartClass() {
		String startClassLine = "class ClassName {";
		Assert.assertTrue(noc.strcompLineChecker(startClassLine));
	}
	
	@Test
	public void testStrcompLineCheckerMidClass() {
		String midClassLine = "public class ClassName {";
		Assert.assertTrue(noc.strcompLineChecker(midClassLine));
	}
	
	@Test
	public void testStrcompLineCheckerVarInitialization() {
		String variableInitLine = "private int x = 0;";
		Assert.assertFalse(noc.strcompLineChecker(variableInitLine));
	}
	
	@Test
	public void testStrcompLineCheckerMethod() {
		String methodLine = "protected String method() {";
		Assert.assertFalse(noc.strcompLineChecker(methodLine));
	}
	
	@Test
	public void testStrcompLineCheckerDoubleSlash() {
		String doubleSlashLine = "// line starting with double slash";
		Assert.assertFalse(noc.strcompLineChecker(doubleSlashLine));
	}
	
	@Test
	public void testStrcompLineCheckerEmpty() {
		String emptyLine = "";
		Assert.assertFalse(noc.strcompLineChecker(emptyLine));
	}
}
