package ue5;

/**
 * The interface is for objects, which should be movable.
 * In this case e.g. Animals and Villagers
 * 
 * @author Michael Kinzkofer, Paul Jureschek
 *
 */

public interface IMovable {
	
	public void setCoordinates (int xCoordinate, int yCoordinate);
	
	public void setCoordinates ();
	
	public int getXCoordinate();
	
	public int getYCoordinate();
	
	public void logCoordinates();

}
