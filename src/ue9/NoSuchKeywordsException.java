package ue9;

public class NoSuchKeywordsException extends Exception{

	private static final long serialVersionUID = 1L;
	private String keyword;
	
	/**
	 * generates new exception object
	 * @param keyword keyword which caused the exception
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
