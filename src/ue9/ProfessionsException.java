package ue9;

/**
 * Exception to be thrown if Biome Element is not found.
 * 
 * @author Michael Kinzkofer
 * 
 */

public class ProfessionsException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Generates new NoSuchBiomeException.
	 * 
	 * @param message - message that will be printed
	 */
	public ProfessionsException(String message) {
		super(message);
	}
	
}
