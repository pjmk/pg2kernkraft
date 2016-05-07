package ue2;

/**
*
* This class provides a "Biome", which can store multiple numbers of Villages.
* It has to have a name and a kind of biome (e.g. "desert", "gras"...).
*
* @author Paul Jureschek, Michael Kinzkofer
*
*/


public class Biome {
	private static final int MAX_NUM_VILLAGES = 100;
	private String name;
	private String nature;
	private int amountVillages;
	private Village[] village;


	/**
	 * Generates new Biome.
	 * @param name name of biome
	 * @param nature kind of biome (e.g. "desert", "gras"...)
	 */
	
	public Biome(String name, String nature) {
		this.name = name;
		this.nature = nature;
		setVillage(new Village [MAX_NUM_VILLAGES]);
	}

	/**
	 * Returns name of Biom.
	 * @return name of Biom
	 */
	
	public String getName() {
		return name;
	}

	/**
	 * Returns constant MAX number of Villages.
	 * @return constant MAX number of Villages
	 */
	
	public static int getMaxNumVillages() {
		return MAX_NUM_VILLAGES;
	}
	
	/**
	 * Returns kind of Biome (e.g. "desert", "gras"...).
	 * @return kind of Biome (e.g. "desert", "gras"...)
	 */
	
	public String getKind() {
		return nature;
	}

	/**
	 * Returns Village saved in Biome (built on Biome).
	 * @return Village saved in Biome (built on Biome)
	 */
	
	public Village[] getVillage() {
		return village;
	}

	/**
	 * Adds existing Village to Biome.
	 * @param village Village Element of type Village that should be added to this Biome
	 */
	
	public void addVillage(Village village) {
		this.village[amountVillages] = village;
		amountVillages++;
	}
	
	/**
	 * Return  string, which contains name of biome and kind of nature
	 * @return  String, which contains name of biome and kind of nature
	 */
	
	public String toString() {
		return "BIOME:"+ name + ";NATURE:" + nature;
	}
	
	/**
	 * Set the array village
	 * @param village Village[] array
	 */
	
	private void setVillage(Village[] village) {
		this.village = village;
	}
	
}
