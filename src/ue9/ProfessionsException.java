package ue9;

/**
 * Exception to be thrown if Biome Element is not found.
 * 
 * @author Michael Kinzkofer, Paul Jureschek
 * 
 */

public class ProfessionsException extends Exception {
	
	private static final long serialVersionUID = 8964794084280968103L;

	/**
	 * Generates new NoSuchBiomeException.
	 * 
	 * @param message - message that will be printed
	 */
	public ProfessionsException(String message) {
		super(message);
	}
	
}
