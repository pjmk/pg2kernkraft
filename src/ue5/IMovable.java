package ue5;

public interface IMovable {
	
	public void setCoordinates (int xCoordinate, int yCoordinate);
	
	public void setCoordinates ();
	
	public int getXCoordinate();
	
	public int getYCoordinate();
	
	public void logCoordinates();

}
