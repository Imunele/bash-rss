package bash_rss;

public class BashParserException extends Exception{
	private final String err;	
	public BashParserException(String string) {	
		if ( null == string || "".equals(string) ) {
			throw new IllegalArgumentException("Error message cannot be null.");

		}
		err = string;
	}
	public String toString() {
		final String message = "BashParserException: "+err;
		return message;
	}
}
