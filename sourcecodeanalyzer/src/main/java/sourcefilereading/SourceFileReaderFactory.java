package sourcefilereading;

/**
 * The factory for the SourceFileReaders.
 * @author giorgossideris
 *
 */
public class SourceFileReaderFactory {
	/**
	 * This method creates the SourceFileReader.
	 * 
	 * @param sourceType             the location that the file is saved (ex. local).
	 * @return reader                the appropriate SourceFileReader.
	 */
	public SourceFileReader createSourceFileReader(String sourceType) {
		SourceFileReader reader;
		if (sourceType.equals("local")) {
			reader = new LocalFileReader();
		} else if (sourceType.equals("web")) {
			reader = new WebFileReader();
		} else {
			reader = new NullFileReader();
		}
		return reader;
	}
}
