package ue5;

/**
 * This Enum provides possible Animals, their activities
 * and the aibility to check if a string matches one if the enums
 * 
 * @author Paul Jureschek, Michael Kinzkofer
 *
 */

public enum AnimalEnum {
	WOLF(80),
	COW(1100),
	CHICKEN(1),
	CAMEL(600);
	
	private int maxWeight;
	
	AnimalEnum(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

}
