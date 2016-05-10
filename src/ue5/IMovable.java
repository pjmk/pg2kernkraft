package ue5;

/**
 * The interface is for objects, which should be movable.
 * In this case e.g. Animals and Villagers
 * 
 * @author Michael Kinzkofer, Paul Jureschek
 *
 */

public interface IMovable {
	
	/**
	 *  set coordinates of object.
	 *  @param xCoordinate x-coordinate of object
	 *  @param yCoordinate y-coordinate of 
	 */
	
	public void setCoordinates (int xCoordinate, int yCoordinate);
	
	/**
	 * set coordinates of object
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
	 * log the coordinates to the console
	 */
	
	public void logCoordinates();

}
