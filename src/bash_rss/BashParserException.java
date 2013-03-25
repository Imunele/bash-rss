package bash_rss;

public class BashParserException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	private String err;
	
	public BashParserException(String string) {
		err = string;
	}

	public String toString(){
		String message = "BashParserException "+err;
		return message;
	}

}
