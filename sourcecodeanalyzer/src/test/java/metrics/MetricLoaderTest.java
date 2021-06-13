package metrics;

import org.junit.Assert;
import org.junit.Test;

public class MetricLoaderTest {
	@Test
	public void testLoadMetrics() {
		MetricLoader.loadMetrics();
		Assert.assertTrue(Metric.getMetrics().get(0) instanceof LinesOfCode);
		Assert.assertTrue(Metric.getMetrics().get(1) instanceof NumberOfClasses);
		Assert.assertTrue(Metric.getMetrics().get(2) instanceof NumberOfMethods);
		Assert.assertEquals(Metric.getMetrics().size(), 3);
	}
}
