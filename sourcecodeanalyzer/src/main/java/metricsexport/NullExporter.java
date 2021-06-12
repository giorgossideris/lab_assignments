package metricsexport;

import java.util.Map;
/**
 * Is used as Null Object for unknown output type.
 * @author giorgossideris
 *
 */
public class NullExporter implements MetricsExporter{
	String unknownType;
	
	public NullExporter(String wrongType) {
		super();
		this.unknownType = wrongType;
	}
	@Override
	public void writeToOutput(Map<String, Integer> metrics, String filepath) {
		throw new IllegalArgumentException("Unknown type : " + unknownType);
	}
}
