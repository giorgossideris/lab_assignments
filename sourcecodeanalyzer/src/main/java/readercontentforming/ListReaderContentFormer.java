package readercontentforming;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import types.SourceCode;

/**
 * Forms the read content (source code) into a List.
 * @author giorgossideris
 *
 */
public class ListReaderContentFormer implements ReaderContentFormer{

	@Override
	public SourceCode formReaderContent(BufferedReader reader) throws IOException{
		SourceCode sourceCode = new SourceCode();
		List<String> lines = new ArrayList<>();
        String line = null;
        while ((line = reader.readLine()) != null) {
        	lines.add(line);
        }
        reader.close();
        
        sourceCode.setSourceCodeList(lines);
		return sourceCode;
	}
	
}
