package ue6;

/**
 * This Enum provides possible Animals, their activities
 * and the aibility to check if a string matches one if the enums
 * 
 * @author Paul Jureschek, Michael Kinzkofer
 *
 */

public enum AnimalEnum {
	WOLF(80, 5),
	COW(1100, 7),
	CHICKEN(5, 4),
	CAMEL(600, 6);
	
	// weight in kilogram
	private int maxWeight;
	private int daysTillSpoil;
	
	AnimalEnum(int maxWeight, int daysTillSpoil) {
		this.maxWeight = maxWeight;
		this.daysTillSpoil = daysTillSpoil;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public int getDaysTillSpoil() {
		return daysTillSpoil;
	}

}
