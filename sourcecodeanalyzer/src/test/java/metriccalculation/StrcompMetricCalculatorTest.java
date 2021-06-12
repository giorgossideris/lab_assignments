package metriccalculation;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import metrics.LinesOfCode;
import metrics.NumberOfClasses;
import metrics.NumberOfMethods;
import types.SourceCode;

public class StrcompMetricCalculatorTest {
	StrcompMetricCalculator strcompCalc = new StrcompMetricCalculator();
	static BufferedReader buffReader;
	static SourceCode sourceCode = new SourceCode();
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	
	@BeforeClass
	public static void setUp() throws IOException {
		File file = new File(TEST_CLASS);
		buffReader = new BufferedReader(new FileReader(file));
		List<String> lines = new ArrayList<>();
        String line = null;
        while ((line = buffReader.readLine()) != null) {
        	lines.add(line);
        }
        buffReader.close();
        
        sourceCode.setSourceCodeList(lines);
	}
	
	@Test
	public void testCalculateMetricResultLOC() {
		assertEquals(7, strcompCalc.calculateMetricResult(sourceCode, new LinesOfCode()));
	}
	
	@Test
	public void testCalculateMetricResultNOM() {
		assertEquals(3, strcompCalc.calculateMetricResult(sourceCode, new NumberOfMethods()));
	}
	
	@Test
	public void testCalculateMetricResultNOC() {
		assertEquals(3, strcompCalc.calculateMetricResult(sourceCode, new NumberOfClasses()));
	}
	
}
