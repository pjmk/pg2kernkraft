package ue9;

/**
 * Exception to be thrown if Villager Element is not found. Unchecked Exception.
 * 
 * @author Paul Jureschek
 * 
 */
public class NoSuchVillagerException extends RuntimeException{

	private static final long serialVersionUID = -4154316811973258381L;
	
	/**
	 * Generates new NoSuchVillagerException.
	 * 
	 * @param message - message that will be printed
	 */
	public NoSuchVillagerException(String message) {
		super(message);
	}
	

}
