package ue7;

import java.util.Iterator;

/**
 * This class generates a chicken.
 * It inherits from class Pet.
 * @author Paul Jureschek, Michael Kinzkofer
 *
 */

public class Chicken extends Pet {
	private boolean isCackling = false;
	private int eggsLaid = 0;
	private int weight;
	
	/**
	 * Generates Chicken object.
	 * 
	 * @param color color of chicken
	 * @param age age of chicken
	 * @param name name of chicken
	 * @param owner owner of chicken
	 * @param isCackling whether chicken is cackling or not
	 * @param eggsLaid number of eggs the chicken has already laid
	 */
	public Chicken(Color color, int age, String name, Villager owner, boolean isCackling, int eggsLaid) {
		super(color, age, name, owner);
		
		this.isCackling = isCackling;
		this.eggsLaid = eggsLaid;
		//Set Weight;
		setWeight();
	}
	
	/**
	 * Generates Chicken object.
	 * @param row String that contains all necessary information
	 * @param world world object the chicken is living on
	 */
	public Chicken(String row, World world) {
		//splits each word in inputData[] array
		String[] inputData = row.split(";|\\:");
		for (int i = 0; i < inputData.length; i += 2) {
			switch(inputData[i]) {
				case Keywords.COLOR:		this.setColor(Color.valueOf(inputData[i + 1].toUpperCase()));			
											break;
				case Keywords.ANIMALAGE:	this.setAge(Integer.parseInt(inputData[i + 1]));
											break;
				case Keywords.OWNER:		this.setOwner(world.getVillagerByName(inputData[i + 1]));
											break;
				case Keywords.CHICKEN: 		this.setName(inputData[i + 1]);
											break;
				case Keywords.CACKLING:		isCackling = Boolean.valueOf(inputData[i + 1]);
											break;
				case Keywords.NUMEGGS: 		eggsLaid = Integer.parseInt(inputData[ i + 1]);
											break;
				default:					System.out.println("No matching keyword found for: " + inputData[i] + " for animal " + this.getName());
			}
		}
		// Add Chicken to Villager
		this.getOwner().addPet(this);
		//Set Weight;
		setWeight();
	}
	
	/**
	 * Chicken will lay an egg. Must have been cackling before.
	 * eggsLayed will be incremented if successful.
	 */
	@Override
	public void performAction() {
		if (isCackling == true) {
			System.out.println("Chicken " + super.getName() +
					"is laying an egg");
			eggsLaid++;
			isCackling = false;
		} else {
			System.out.println("Chicken is not cackling!"
					+ " - It can't lay an egg right now");
		}
	}

	/**
	 * Return boolean whether chicken is cackling or not.
	 * @return boolean whether chicken is cackling or not
	 */	
	public boolean isCackling() {
		return isCackling;
	}

	/**
	 * Set Cackling of chicken.
	 * @param isCackling whether chicken is cackling or not
	 */	
	public void setCackling(boolean isCackling) {
		this.isCackling = isCackling;
	}
	
	/**
	 * Returns the amount of eggs the chicken has laid yet in its life.
	 * @return amount of eggs the chicken has laid yet in its life
	 */
	public int getEggsLaid() {
		return eggsLaid;
	}
	
	public int getWeight() {
		return weight;
	}
	
	/**
	 * Sets weight of Animal to something between 1 and defined maxWeight in AnimalEnum.
	 */
	public void setWeight() {
		weight = (int) Math.floor(Math.random() * AnimalEnum.CHICKEN.getMaxWeight() + 1);
	}
	
	@Override
	public String toString() {
		return "CHICKEN:" + this.getName() + ";COLOR:" + this.getColor().toString().toLowerCase()
		+ ";ANIMALAGE:" + this.getAge() + ";OWNER:" + this.getOwner().getName() 
		+ ";CACKLING:" + Boolean.toString(isCackling) + ";NUMEGGS:" + Integer.toString(eggsLaid);
	}

	/**
	 * Returns meat of the animal and deletes himself.
	 * @return meat of the animal 
	 */

	@Override
	public Meat slaughter() {
		Meat meat = new Meat(weight, AnimalEnum.CHICKEN.getDaysTillSpoil(),
					AnimalEnum.CHICKEN);
		// Delete the animal in Pet[] in Villager
		for(int i = 0; i < Villager.getMaxNumPets(); i++) {
			Pet pet =  getOwner().getPets()[i];
			if (pet == this){
				getOwner().getPets()[i] = null;
			}
		}
		return meat;
	}

	/**
	 * log the Chickens coordinates to the console
	 */
	@Override
	public void logCoordinates() {
		System.out.println("CHICKEN:" + ";X-COORDINATE:" + getXCoordinate() + ";Y-COORDINATE:" + getYCoordinate());	
	}
}
