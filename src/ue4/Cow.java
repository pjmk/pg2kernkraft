package ue4;

/**
 * This class generates Cows.
 * 
 * @author Paul Jureschek, Michael Kinzkofer
 *
 */

public class Cow extends Pet {
	
	/**
	 * Generates Cow object.
	 * 
	 * @param color color of cow
	 * @param age age of cow
	 * @param name name of cow
	 * @param owner owner of cow
	 */
	public Cow(Color color, int age, String name, Villager owner) {
		super(color, age, name, owner);
		
	}
	
	/**
	 * Generates Cow object.
	 * @param row String that contains all necessary information
	 * @param world world the cow is living in
	 */
	public Cow(String row, World world) {
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
				case Keywords.COW: 			this.setName(inputData[i + 1]);
											break;
				default:					System.out.println("No fitting keyword found for: " + inputData[i] + " for animal " + this.getName());
			}
		}
		// Add Cow to Villager
		this.getOwner().addPet(this);
	}

	/**
	 * This Method makes the cow milk.
	 */
	@Override
	public void performAction() {
		System.out.println("Cow: " + super.getName() + " milks!");
	}
	
	@Override
	public String toString() {
		return "COW:" + this.getName() + ";COLOR:" + this.getColor().toString().toLowerCase()
		+ ";ANIMALAGE:" + this.getAge() + ";OWNER:" + this.getOwner().getName();
	}

	
	
}
