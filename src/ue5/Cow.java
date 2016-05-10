package ue5;

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
		// set the typical max weight ( which is saved in AnimalEnum) 
		this.setMaxWeight(AnimalEnum.COW.getMaxWeight());
		
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
		// set the typical max weight ( which is saved in AnimalEnum) 
		this.setMaxWeight(AnimalEnum.CAMEL.getMaxWeight());
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

	@Override
	public Meat slaughter() {
		Meat meat = new Meat(AnimalEnum.COW.getMaxWeight(), AnimalEnum.COW.getDaysTillSpoil(),
					AnimalEnum.COW);
		// TODO Auto-generated method stub
		// TODO löschen des Tieren, nach slaughter 
		return meat;
	}

	/**
	 *  set the coordinates of the Cow.
	 *  @param xCoordinate x-coordinate of the villager in the biome
	 *  @param yCoordinate y-coordinate of the villager in the biome
	 */
	@Override
	public void setCoordinates(int xCoordinate, int yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

	/**
	 * Generates random coordinates and log the coordinates of the 
	 *  Cow to the console
	 */
	@Override
	public void setCoordinates() {
		this.xCoordinate = (int) (100 * Math.random());
		this.yCoordinate = (int) (100 * Math.random());
		logCoordinates();
	}

	/**
	 * Returns x-coordinate of the Cow.
	 * @return x-coordinate of the Cow
	 */
	@Override
	public int getXCoordinate() {
		return xCoordinate;
	}
	
	/**
	 * Returns y-coordinate of the Cow.
	 * @return y-coordinate of the Cow
	 */
	@Override
	public int getYCoordinate() {
		return yCoordinate;
	}

	/**
	 * log the Cow coordinates to the console
	 */
	@Override
	public void logCoordinates() {
		System.out.println("COW:" + "X-COORDINATE:" + xCoordinate + ";Y-COORDINATE:" + yCoordinate);	
	}
	
	
}
