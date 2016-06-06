package ue9;

/**
 * Exception to be thrown if Villager Element is not found.
 * 
 * @author Paul Jureschek
 * 
 * 
 *
 */
public class NoSuchVillagerException extends RuntimeException{

	private static final long serialVersionUID = -4154316811973258381L;
	
	public NoSuchVillagerException() {
	}
	
	public NoSuchVillagerException(String message) {
		super(message);
	}
	

}
