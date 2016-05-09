package ue5;

public class Meat {
	private int meatWeight;
	private int daysTillSpoil;
	private AnimalEnum type;
	
	public Meat(int meatWeight, int daysTillSpoil, AnimalEnum type) {
		this.meatWeight = meatWeight;
		this.daysTillSpoil = daysTillSpoil;
		this.type = type;
	}
	
	/**
	 * Return weight, day till spoil and type of Meat.
	 * @return weight, day till spoil and type of Meat
	 */
	@Override
	public String toString() {
		return "MEAT:" + type + ";DaysTillSpoil:" + daysTillSpoil
				+ ";WEIGHT:" + meatWeight;	
	}
	
}
