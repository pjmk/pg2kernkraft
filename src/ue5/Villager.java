package ue5;

/**
 * The class Villager describes one Villager.
 * It must have a name, a gender and an age.
 * 
 * @author Paul Jureschek, Michael Kinzkofer
 *
 */

public class Villager implements IMovable{
	private String name;
	private Profession profession;
	private Gender gender;
	private int age, xCoordinate, yCoordinate;
	private final int MAX_NUM_PETS = 10; //Just used because we don't know dynamic arrays yet
	private Pet[] pets = new Pet[MAX_NUM_PETS];

	/**
	 * Generates new Villager.
	 * @param row 	String containing all attributes e.g. (Gender,
	 *  			Profession or Age)
	 */	
	
	public Villager(String row) {
		//splits each word in inputData[] array
		String[] inputData = row.split(";|\\:");
		for (int i = 0; i < inputData.length; i += 2) {
			switch(inputData[i]) {
				case Keywords.VILLAGER:		this.name = inputData[i + 1];			
											break;
				case Keywords.GENDER:		this.gender = Gender.valueOf(inputData[i + 1].toUpperCase());
											break;		
				case Keywords.AGE:			this.age = Integer.valueOf(inputData[i + 1]);	
											break;
				case Keywords.PROFESSION:	this.profession = Profession.valueOf(inputData[i + 1].toUpperCase());
											break;
			}
		}
		// Generates random coordinates and log the villager to the console
		setCoordinates();
	}
	
	public Profession getProfession() {
		return profession;
	}

	/**
	 * Generates new Villager Object.
	 * @param name name of Villager
	 * @param gender gender of Villager
	 * @param age age of Villager
	 * @param profession profession of Villager
	 */
	
	public Villager(String name, Gender gender, int age, Profession profession) {
		this.name = name;
		this.profession = profession;
		this.gender = gender;
		this.age = age;
		
		// Generates random coordinates and log the villager to the console
		setCoordinates();
		logCoordinates();
	}

	/**
	 * Return name of Villager.
	 * @return name of Villager
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Add pet to villager.
	 * @param pet pet to be added
	 */
	public void addPet(Pet pet) {		
		for (int i = 0; i < MAX_NUM_PETS; i++) {
			if (pets[i] == null) {
				pets[i] = pet;
				return;
			}
		}
		System.out.println("No more pets allowed on this villager");
	}
	
	/**
	 * Returns pets array owned by Villager.
	 * @return pets owned by Villager
	 */
	public Pet[] getPets() {
		return pets;
	}

	/**
	 * Return name, gender and age of Villager.
	 * @return name, gender and age of Villager
	 */
	@Override
	public String toString() {
		return "VILLAGER:" + name + ";GENDER:" + gender.toString().toLowerCase()
				+ ";AGE:" + age + ";PROFESSION:" + WorldUtilities.convertUpper(profession.toString());
	}

	/**
	 *  set the coordinates of the villager.
	 *  @param xCoordinate x-coordinate of the villager in the biome
	 *  @param yCoordinate y-coordinate of the villager in the biome
	 */
	@Override
	public void setCoordinates(int xCoordinate, int yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

	/**
	 * Generates random coordinates and log the villager to the console
	 */
	@Override
	public void setCoordinates() {
		this.xCoordinate = (int) (100 * Math.random());
		this.yCoordinate = (int) (100 * Math.random());
		logCoordinates();
	}

	/**
	 * Returns x-coordinate of the Villager.
	 * @return x-coordinate of the Villager
	 */
	@Override
	public int getXCoordinate() {
		return xCoordinate;
	}
	
	/**
	 * Returns y-coordinate of the Villager.
	 * @return y-coordinate of the Villager
	 */
	@Override
	public int getYCoordinate() {
		return yCoordinate;
	}

	/**
	 * log the villagers coordinates to the console
	 */
	@Override
	public void logCoordinates() {
		System.out.println("VILLAGER:" + name + ";X-COORDINATE:" + xCoordinate + ";Y-COORDINATE:" + yCoordinate);	
	}
	

}
