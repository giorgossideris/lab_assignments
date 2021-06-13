package metrics;

import org.junit.Assert;
import org.junit.Test;

public class LinesOfCodeTest {
	LinesOfCode loc = new LinesOfCode();
	
	@Test
	public void testStrcompLineCheckerDoubleSlash() {
		String doubleSlashLine = "// line starting with double slash";
		Assert.assertTrue(loc.strcompLineChecker(doubleSlashLine));
	}
	
	@Test
	public void testStrcompLineCheckerSlashAsterisk() {
		String slashAsteriskLine = "/* line starting with slash asterisk";
		Assert.assertTrue(loc.strcompLineChecker(slashAsteriskLine));
	}
	
	@Test
	public void testStrcompLineCheckerAsterisk() {
		String asteriskLine = "* line starting with double asterisk";
		Assert.assertTrue(loc.strcompLineChecker(asteriskLine));
	}
	
	@Test
	public void testStrcompLineCheckerLeftBracket() {
		String leftBracketLine = "{";
		Assert.assertTrue(loc.strcompLineChecker(leftBracketLine));
	}
	
	@Test
	public void testStrcompLineCheckerRightBracket() {
		String rightBracketLine = "}";
		Assert.assertTrue(loc.strcompLineChecker(rightBracketLine));
	}
	
	@Test
	public void testStrcompLineCheckerEmpty() {
		String emptyLine = "";
		Assert.assertTrue(loc.strcompLineChecker(emptyLine));
	}
	
	@Test
	public void testStrcompLineCheckerCode() {
		String codeLine = "x = 10;";
		Assert.assertFalse(loc.strcompLineChecker(codeLine));
	}
}
