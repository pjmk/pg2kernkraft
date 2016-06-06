package ue9;

/**
 * Exception to be thrown if Keyword constant is not found.
 * 
 * @author Michael Kinzkofer
 * 
 */

public class NoSuchKeywordsException extends Exception{

	private static final long serialVersionUID = 1L;
	private String keyword;
	
	/**
	 * generates new NoSuchKeywordsException.
	 * @param keyword - keyword which caused the exception
	 * @param message - message that will be printed
	 */
	public NoSuchKeywordsException(String message, String keyword) {
		super(message);
		this.keyword = keyword;
	}

	/**
	 * @return the keyword which caused the exception
	 */
	public String getKeyword() {
		return keyword;
	}

		

}
