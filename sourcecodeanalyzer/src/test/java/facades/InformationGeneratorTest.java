package facades;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;


public class InformationGeneratorTest {
	InformationGenerator infGen = new InformationGenerator();
	private final static String TYPE_WEB = "web";
	private final static String TYPE_LOCAL = "local";
	private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
	private final static String TEST_CLASS_WEB ="https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";
	private final static String TYPE_REGEX = "regex";
	private final static String TYPE_STRCOMP = "strcomp";
	
	@Test
	public void testCalculateMetricsRegexLocal() throws IOException {
		HashMap<String, Integer> expectedMetrics = infGen.calculateMetrics(TEST_CLASS_LOCAL, TYPE_REGEX, TYPE_LOCAL);
		Assert.assertEquals(21, expectedMetrics.get("loc"), 0);
		Assert.assertEquals(3, expectedMetrics.get("noc"), 0);
		Assert.assertEquals(3, expectedMetrics.get("nom"), 0);
	}
	
	@Test
	public void testCalculateMetricsStrcompLocal() throws IOException {
		HashMap<String, Integer> expectedMetrics = infGen.calculateMetrics(TEST_CLASS_LOCAL, TYPE_STRCOMP, TYPE_LOCAL);
		Assert.assertEquals(7, expectedMetrics.get("loc"), 0);
		Assert.assertEquals(3, expectedMetrics.get("noc"), 0);
		Assert.assertEquals(3, expectedMetrics.get("nom"), 0);
	}
	
	@Test
	public void testCalculateMetricsRegexWeb() throws IOException {
		HashMap<String, Integer> expectedMetrics = infGen.calculateMetrics(TEST_CLASS_WEB, TYPE_REGEX, TYPE_WEB);
		Assert.assertEquals(21, expectedMetrics.get("loc"), 0);
		Assert.assertEquals(3, expectedMetrics.get("noc"), 0);
		Assert.assertEquals(3, expectedMetrics.get("nom"), 0);
	}
	
	@Test
	public void testCalculateMetricsStrcompWeb() throws IOException {
		HashMap<String, Integer> expectedMetrics = infGen.calculateMetrics(TEST_CLASS_WEB, TYPE_STRCOMP, TYPE_WEB);
		Assert.assertEquals(7, expectedMetrics.get("loc"), 0);
		Assert.assertEquals(3, expectedMetrics.get("noc"), 0);
		Assert.assertEquals(3, expectedMetrics.get("nom"), 0);
	}
}
