package ue2;
/**
 * The class Villager describes one Villager.
 * It must have a name, a gender and an age.
 * 
 * @author Paul Jureschek, Michael Kinzkofer
 *
 */

public class Villager {
	private String name;
	private Gender gender;
	private int age;

	/**
	 * Generates new Villager Object.
	 * @param name name of Villager
	 */	
	
	public Villager(String name) {
		this.name = name;
	}
	
	/**
	 * Generates new Villager Object.
	 * @param name name of Villager
	 * @param gender gender of Villager
	 * @param age age of Villager
	 */
	
	public Villager(String name, Gender gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	/**
	 * Return name of Villager.
	 * @return name of Villager
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Return name, gender and age of Villager.
	 * @return name, gender and age of Villager
	 */
	
	public String toString() {
		return "VILLAGER:" + name + ";GENDER:" + gender + ";AGE:" + age;
	}
}
