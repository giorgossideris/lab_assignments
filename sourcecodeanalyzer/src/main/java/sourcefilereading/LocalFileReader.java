package sourcefilereading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads the source code from a file in a local location.
 * @author giorgossideris
 *
 */
public class LocalFileReader implements SourceFileReader {
	@Override
	public BufferedReader readFile(String filepath) throws IOException {
		File file = new File(filepath);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		return reader;
	}
}
