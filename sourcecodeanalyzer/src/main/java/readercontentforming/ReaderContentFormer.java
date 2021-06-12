package readercontentforming;

import java.io.BufferedReader;
import java.io.IOException;

import types.SourceCode;

/**
 * An interface that provides the method for forming the read code into the wanted type.
 * @author giorgossideris
 *
 */
public interface ReaderContentFormer {
	/**
	 * This method forms the read source code into the wanted type.
	 * @param reader         a BufferedReader that has read the source code.
	 * @return sourceCode    a SourceCode object with the corresponding, of the wanted formation type,
	 *                       filled in with the code
	 * @throws IOException
	 * @see IOException
	 */
	public SourceCode formReaderContent(BufferedReader reader) throws IOException;
}
