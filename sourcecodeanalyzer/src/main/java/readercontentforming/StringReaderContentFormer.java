package readercontentforming;

import java.io.BufferedReader;
import java.io.IOException;

import types.SourceCode;

/**
 * Forms the read content (source code) into a String.
 * @author giorgossideris
 *
 */
public class StringReaderContentFormer implements ReaderContentFormer {
 
	@Override
	public SourceCode formReaderContent(BufferedReader reader) throws IOException{
		SourceCode sourceCode = new SourceCode();
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
		reader.close();
		sourceCode.setSourceCodeString(sb.toString());
		return sourceCode;
	}
}
