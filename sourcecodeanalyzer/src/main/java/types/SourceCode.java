package types;

import java.util.List;

/**
 * Contains the source code in the wanted form
 * @author giorgossideris
 *
 */
public class SourceCode {
	/**
	 * The source code as a String.
	 */
	private String sourceCodeString;
	/**
	 * The source code as a List.
	 */
	private List<String> sourceCodeList;
	
	public String getSourceCodeString() {
		return sourceCodeString;
	}
	public void setSourceCodeString(String sourceCodeString) {
		this.sourceCodeString = sourceCodeString;
	}
	public List<String> getSourceCodeList() {
		return sourceCodeList;
	}
	public void setSourceCodeList(List<String> sourceCodeList) {
		this.sourceCodeList = sourceCodeList;
	}
	
	
}
