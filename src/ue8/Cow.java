package ue8;

/**
 * This class generates Cows.
 * 
 * @author Paul Jureschek, Michael Kinzkofer
 *
 */

public class Cow extends Pet {
	private int weight;
	
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
		//Set Weight;
		setWeight();
		
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
		//Set Weight;
		setWeight();
	}

	public int getWeight() {
		return weight;
	}
	
	/**
	 * Sets weight of Animal to something between 1 and defined maxWeight in AnimalEnum.
	 */
	public void setWeight() {
		weight = (int) Math.floor(Math.random() * AnimalEnum.COW.getMaxWeight() + 1);
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

	/**
	 * Returns meat of the animal and deletes itself.
	 * @return meat of the animal 
	 */

	@Override
	public Meat slaughter() {
		Meat meat = new Meat(weight, AnimalEnum.COW.getDaysTillSpoil(),
					AnimalEnum.COW);
		// Delete the animal in Pet List in Villager
		for(int i = 0; i < getOwner().getPets().size(); i++) {
			Pet pet =  getOwner().getPets().get(i);
			if (pet == this){
				getOwner().getPets().remove(i);
			}
		}
		return meat;
	}

	/**
	 * Log the Cows coordinates to the console.
	 */
	@Override
	public void logCoordinates() {
		System.out.println("COW:" + "X-COORDINATE:" + getXCoordinate() + ";Y-COORDINATE:" + getYCoordinate());	
	}
}
