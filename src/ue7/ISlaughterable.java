package ue7;

/**
 * The interface is for objects, which should be slaughterable.
 * In this case Pets.
 * 
 * @author Michael Kinzkofer
 *
 */

public interface ISlaughterable {
	
	/**
	 * Returns meat of the animal and deletes it.
	 * @return meat of the animal 
	 */
	
	public Meat slaughter();
}
