package metriccalculation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import readercontentforming.ListReaderContentFormer;
import readercontentforming.StringReaderContentFormer;

public class MetricCalculatorFactoryTest {
	private final static String TYPE_REGEX = "regex";
	private final static String TYPE_STRCOMP = "strcomp";
	MetricCalculatorFactory calcFactory = new MetricCalculatorFactory();
	
	@Test
	public void testCreateMetricCalculatorRegex() {
		MetricCalculator calculator = calcFactory.createMetricCalculator(TYPE_REGEX);
		assertTrue(calculator instanceof RegexMetricCalculator);
		assertTrue(calculator.getContentFormer() instanceof StringReaderContentFormer);
	}
	
	@Test
	public void testCreateMetricCalculatorStrcomp() {
		MetricCalculator calculator = calcFactory.createMetricCalculator(TYPE_STRCOMP);
		assertTrue(calculator instanceof StrcompMetricCalculator);
		assertTrue(calculator.getContentFormer() instanceof ListReaderContentFormer);
	}
	
	@Test
	public void testCreateMetricCalculatorUnknown() {
		MetricCalculator calculator = calcFactory.createMetricCalculator("mistake");
		assertTrue(calculator instanceof NullMetricCalculator);
	}
	
}
