package ue4;

/**
 * This class generates a chicken.
 * It inherits from class Pet.
 * @author Paul Jureschek, Michael Kinzkofer
 *
 */

public class Chicken extends Pet {
	private boolean isCackling = false;
	private int eggsLaid = 0;
	
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
	
	@Override
	public String toString() {
		return "CHICKEN:" + this.getName() + ";COLOR:" + this.getColor().toString().toLowerCase()
		+ ";ANIMALAGE:" + this.getAge() + ";OWNER:" + this.getOwner().getName() 
		+ ";CACKLING:" + Boolean.toString(isCackling) + ";NUMEGGS:" + Integer.toString(eggsLaid);
	}
}
