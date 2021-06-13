package metrics;

import org.junit.Assert;
import org.junit.Test;

public class NumberOfMethodsTest {
	NumberOfMethods nom = new NumberOfMethods();
	
	@Test
	public void testStrcompLineCheckerPublicVoid() {
		String publicVoidLine = "public void method() {";
		Assert.assertTrue(nom.strcompLineChecker(publicVoidLine));
	}
	
	@Test
	public void testStrcompLineCheckerPrivateVoid() {
		String privateVoidLine = "private void method() {";
		Assert.assertTrue(nom.strcompLineChecker(privateVoidLine));
	}
	
	@Test
	public void testStrcompLineCheckerProtectedVoid() {
		String protectedVoidLine = "protected void method() {";
		Assert.assertTrue(nom.strcompLineChecker(protectedVoidLine));
	}
	
	@Test
	public void testStrcompLineCheckerPublicInt() {
		String publicIntLine = "public int method() {";
		Assert.assertTrue(nom.strcompLineChecker(publicIntLine));
	}
	
	@Test
	public void testStrcompLineCheckerPrivateInt() {
		String privateIntLine = "private int method() {";
		Assert.assertTrue(nom.strcompLineChecker(privateIntLine));
	}
	
	@Test
	public void testStrcompLineCheckerProtectedInt() {
		String protectedIntLine = "protected int method() {";
		Assert.assertTrue(nom.strcompLineChecker(protectedIntLine));
	}
	
	@Test
	public void testStrcompLineCheckerPublicString() {
		String publicStringLine = "public String method() {";
		Assert.assertTrue(nom.strcompLineChecker(publicStringLine));
	}
	
	@Test
	public void testStrcompLineCheckerPrivateString() {
		String privateStringLine = "private String method() {";
		Assert.assertTrue(nom.strcompLineChecker(privateStringLine));
	}
	
	@Test
	public void testStrcompLineCheckerProtectedString() {
		String protectedStringLine = "protected String method() {";
		Assert.assertTrue(nom.strcompLineChecker(protectedStringLine));
	}
	
	@Test
	public void testStrcompLineCheckerVarInitialization() {
		String variableInitLine = "private int x = 0;";
		Assert.assertFalse(nom.strcompLineChecker(variableInitLine));
	}
	
	@Test
	public void testStrcompLineCheckerDoubleSlash() {
		String doubleSlashLine = "// line starting with double slash";
		Assert.assertFalse(nom.strcompLineChecker(doubleSlashLine));
	}
	
	@Test
	public void testStrcompLineCheckerClass() {
		String classLine = "public class ClassName {";
		Assert.assertFalse(nom.strcompLineChecker(classLine));
	}
	
	@Test
	public void testStrcompLineCheckerEmpty() {
		String emptyLine = "";
		Assert.assertFalse(nom.strcompLineChecker(emptyLine));
	}
}
