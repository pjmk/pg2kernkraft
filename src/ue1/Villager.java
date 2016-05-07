package ue1;
/**
 * The class Villager describes one Villager.
 * It must have a name
 * @author Paul Jureschek, Michael Kinzkofer
 *
 */

public class Villager {
	private String name;

	/**
	 * Generates new Villager Object.
	 * @param name name of Villager
	 */
	public Villager(String name) {
		this.name = name;
	}

	/**
	 * Return name of Villager.
	 * @return name of Villager
	 */
	public String getName() {
		return name;
	}
}
