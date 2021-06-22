package sourcefilereading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Reads the source code from a file in a local location.
 * @author giorgossideris
 *
 */
public class WebFileReader implements SourceFileReader{
	@Override
	public BufferedReader readFile(String filepath) throws IOException {
		URL url = new URL(filepath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		return reader;
	}
}
