package sourcefilereading;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * An interface that provides a method to read the given file into a BufferedReader.
 * @author giorgossideris
 *
 */
public interface SourceFileReader {
	/**
	 * This method generates a BufferedReader that has read the given file.
	 * 
	 * @param filepath        the path of the file to be analyzed. The file must contain Java code.
	 * @return                a BufferedReader that contains the source code  of the given file.
	 * @throws IOException
	 */
	public abstract BufferedReader readFile(String filepath) throws IOException;
}
