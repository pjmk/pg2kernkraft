package ue5;

/**
 * The interface is for objects, which should be movable.
 * In this case e.g. Animals and Villagers
 * 
 * @author Michael Kinzkofer
 *
 */

public interface IMovable {
	
	/**
	 *  Set coordinates of object.
	 *  @param xCoordinate x-coordinate of object
	 *  @param yCoordinate y-coordinate of 
	 */
	
	public void setCoordinates (int xCoordinate, int yCoordinate);
	
	/**
	 * Set coordinates of object.
	 */
	
	public void setCoordinates ();
	
	/**
	 * Get x-coordinate of object.
	 * @return x-coordinate of object
	 */
	
	public int getXCoordinate();
	
	/**
	 * Get y-coordinate of object.
	 * @return y-coordinate of object
	 */
	
	public int getYCoordinate();
	
	/**
	 * Log the coordinates to the console.
	 */
	
	public void logCoordinates();

}
