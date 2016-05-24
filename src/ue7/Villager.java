package ue7;

import java.lang.Comparable;
import java.util.ArrayList;
import java.util.List;

/**
 * The class Villager describes one Villager.
 * It must have a name, a gender and an age.
 *
 * @author Paul Jureschek, Michael Kinzkofer
 *
 */

public class Villager implements IMovable, Comparable<Villager>{
	private String name;
	private Profession profession;
	private Gender gender;
	private int age, xCoordinate, yCoordinate;
	private final static int MAX_WEALTH = 1000;
	private int wealth;
	private List<Pet> pets = new ArrayList<>();

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
				case Keywords.VILLAGER:		System.out.println("NAme of villager: '" + inputData[i + 1] + "'");
											this.name = inputData[i + 1];
											break;
				case Keywords.GENDER:		this.gender = Gender.valueOf(inputData[i + 1].toUpperCase());
											break;
				case Keywords.AGE:			this.age = Integer.valueOf(inputData[i + 1]);
											break;
				case Keywords.PROFESSION:	this.profession = Profession.valueOf(inputData[i + 1].toUpperCase());
											break;
			}
		}
		// Generates random coordinates
		setCoordinates();

		//Generate random wealth of Villager
		setWealth();
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

		//  Generates random coordinates
		setCoordinates();
		setWealth();
	}

	/**
	 * Returns Villager's profession.
	 * @return Villager's profession
	 */
	public Profession getProfession() {
		return profession;
	}

	/**
	 * Sets wealth of Villager. Will be a random value between 0 and value of MAX_WEALTH.
	 */
	public void setWealth() {
		wealth = (int) (Math.random() * MAX_WEALTH);
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
		pets.add(pet);
	}

	/**
	 * Returns pets array owned by Villager.
	 * @return pets owned by Villager
	 */
	public List<Pet> getPets() {
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
	 * Generates random coordinates and log the villager to the console.
	 */
	@Override
	public void setCoordinates() {
		this.xCoordinate = (int) (100 * Math.random());
		this.yCoordinate = (int) (100 * Math.random());
		//logCoordinates();
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
	 * Returns wealth of Villager.
	 * @return wealth of Villager
	 */
	public int getWealth() {
		return wealth;
	}

	/**
	 * log the villagers coordinates to the console.
	 */
	@Override
	public void logCoordinates() {
		System.out.println("VILLAGER:" + name + ";X-COORDINATE:" + xCoordinate + ";Y-COORDINATE:" + yCoordinate);
	}

	/**
	 * Compares two Villagers by their wealth attribute.
	 * Note: this comparator imposes orderings that are inconsistent with equals.
	 * @param o1 Villager Object
	 * @return 1 if first argument is of greater wealth greater than second -
	 *		   0 if both arguments are of the same wealth -
	 *		   -1 if first argument is of less wealth than second
	 */
	@Override
	public int compareTo(Villager o1) {
		if (wealth > o1.wealth) {
			return 1;
		} else if (wealth == o1.wealth) {
			return 0;
		} else
			return -1;
	}

}
