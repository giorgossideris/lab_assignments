package metriccalculation;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import metrics.LinesOfCode;
import metrics.NumberOfClasses;
import metrics.NumberOfMethods;
import types.SourceCode;

public class RegexMetricCalculatorTest {
	RegexMetricCalculator regexCalc = new RegexMetricCalculator();
	static BufferedReader buffReader;
	static SourceCode sourceCode = new SourceCode();
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	
	@BeforeClass
	public static void setUp() throws IOException {
		File file = new File(TEST_CLASS);
		buffReader = new BufferedReader(new FileReader(file));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = buffReader.readLine()) != null) {
			sb.append(line + "\n");
		}
		buffReader.close();
		sourceCode.setSourceCodeString(sb.toString());
	}
	
	@Test
	public void testCalculateMetricResultLOC() {
		assertEquals(21, regexCalc.calculateMetricResult(sourceCode, new LinesOfCode()));
	}
	
	@Test
	public void testCalculateMetricResultNOM() {
		assertEquals(3, regexCalc.calculateMetricResult(sourceCode, new NumberOfMethods()));
	}
	
	@Test
	public void testCalculateMetricResultNOC() {
		assertEquals(3, regexCalc.calculateMetricResult(sourceCode, new NumberOfClasses()));
	}
	
	
	
}
