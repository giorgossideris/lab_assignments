package sourcefilereading;

import java.io.BufferedReader;

/**
 * Is used as Null Object for unknown source type.
 * @author giorgossideris
 *
 */
public class NullFileReader implements SourceFileReader {
	@Override
	public BufferedReader readFile(String filepath) {
		throw new IllegalArgumentException("Unknown source type.");
	}
}
