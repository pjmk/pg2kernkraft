package ue2;

/**
*
* The class Village describes a Village with name, population, amount of houses and a mayor.
* - It has to have a name
*
* @author Paul Jureschek, Michael Kinzkofer
*
*/


public class Village {
	private static final int MAX_NUM_VILLAGER = 100;
	private String name;
	private int amountHouses;
	private int population;
	private Villager mayor;
	private Villager[] villager;
	
	/**
	 * Generates new Village Object.
	 * @param name name of Villager
	 */
	
	public Village(String name) {
		amountHouses = 1;
		population = 2;
		this.name = name;
		setVillager(new Villager [MAX_NUM_VILLAGER]);
	}

	/**
	 * Returns name of Village.
	 * @return name of Village
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Returns Villager[] array 
	 * @return Villager[] array
	 */
	
	public Villager[] getVillager() {
		return villager;
	}

	/**
	 * Returns amount of houses in Village.
	 * @return amountHouses in Village
	 */
	
	public int getAmountHouses() {
		return amountHouses;
	}

	/**
	 * Returns population of Village.
	 * @return population in Village
	 */
	
	public int getPopulation() {
		return population;
	}

	/**
	 * Returns Villager that is mayor of Village.
	 * @return mayor of Village
	 */
	
	public Villager getMayor() {
		return mayor;
	}

	/**
	 * Won't change variables and quit printing errors if houses will be more than 30, less than 2 inhabitants are added for each house or population will be more than 100 or than 0.
	 *
	 * @param amountHouses houses that will be added
	 * @param amountInhabitants inhabitants that will be added
	 */

	public void buildHouse(int amountHouses, int amountInhabitants) {
		if (amountHouses > 30) {
			System.out.println("This Village would have more than 30 houses by adding " + amountHouses + " Houses. That is too much!");
			return;
		}

		if (amountInhabitants < (amountHouses * 2)) {
			System.out.println("Too less Inhabitants added. Need to add at least 2 per house");
			return;
		}

		if (isNewPopulationOK(amountInhabitants)) {
			population = amountInhabitants;
		} else {
			return;
		}

		this.amountHouses = amountHouses;
	}

	/**
	 * Adds exactly one inhabitant to population when called.
	 * Only increased if population stays less or equal 100 and not less than 0.
	 */

	public void addInhabitant() {
		if (isNewPopulationOK(1)) {
			population++;
		}
	}

	/**
	 * Only increased if population stays less or equal 100 and not less than 0.
	 * @param amount amount that will be added to village's population
	 */
	
	public void addInhabitant(int amount) {
		if (isNewPopulationOK(amount)) {
			population += amount;
		}
	}

	/**
	 * Elects new mayor (Villager) of Village, a default name is used for him/her.
	 * @return Villager Object of new mayor
	 */
	
	public Villager electMayor() {
		final String name = "Mayor Bob";

		mayor = new Villager(name);
		return mayor;
	}
	
	/**
	 * Set the mayor of the village.
	 * @param name name of the mayor
	 * @return the mayor with type Villager
	 */
	
	public Villager setMayor(String name) {
		mayor = new Villager(name);
		return mayor;
	}
	
	/**
	 * Return name of the village, amount of houses and inhabitants.
	 * @return name of the village, amount of houses and inhabitants
	 */
	
	public String toString(){
		return 	"VILLAGE:" + name + ";NUMHOUSES:" + amountHouses + ";MAYOR:" + mayor.getName();
	}
	
	/**
	 * Only used in this class to prevent code duplication.
	 * @param amount that is added to population and checked if it's less than 0 or more than 100
	 * @return boolean
	 */
	
	private boolean isNewPopulationOK(int amount) {
		if (population + amount > 100) {
			System.out.println("This Village would have more than 100 inhabitants by adding " 
								+ amount + " inhabitants. That is too much!");
			return false;
		} else if (population + amount < 0) {
			System.out.println("This Village would have less than 0 inhabitants by adding " 
								+ amount + " inhabitants. That is not possible!");
			return false;
		}
		return true;
	}

	/**
	 * Set the array villager
	 * @param villager Villager[] array
	 */
	
	private void setVillager(Villager[] villager) {
		this.villager = villager;
	}
}