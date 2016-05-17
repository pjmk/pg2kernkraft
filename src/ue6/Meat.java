package ue6;

/**
*
* The class Meat is described by type, daysTillSpoil and weight.
* It is returned, if a Animal is slaughtered.
*
* @author Michael Kinzkofer
*
*/
public class Meat {
	private int meatWeight;
	private int daysTillSpoil;
	private AnimalEnum type;
	
	/**
	 * Generates Meat object.
	 * 
	 * @param maxWeight maxWeight of meat 
	 * @param daysTillSpoil Days till the meat starts to spoil
	 * @param type type of meat e.g. chicken, cow...
	 */
	
	public Meat(int meatMaxWeight, int daysTillSpoil, AnimalEnum type) {
		this.meatWeight = (int) (meatMaxWeight * Math.random());
		this.daysTillSpoil = daysTillSpoil;
		this.type = type;
	}
	
	/**
	 * Return weight, day till spoil and type of Meat as concatenated String.
	 * @return weight, day till spoil and type of Meat
	 */
	@Override
	public String toString() {
		return "MEAT:" + type + ";DaysTillSpoil:" + daysTillSpoil
				+ ";WEIGHT:" + meatWeight;	
	}
	
}
