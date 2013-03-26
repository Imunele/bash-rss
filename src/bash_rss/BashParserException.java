package bash_rss;

public class BashParserException extends Exception{
	private final String err;	
	public BashParserException(String string) {
		err = string;
		if ( null == err || "".equals(err) ) {
			throw new IllegalArgumentException("Error message cannot be null.");
		}
	}
	public String toString() {
		String message = "BashParserException: "+err;
		return message;
	}

}
