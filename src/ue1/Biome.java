package ue1;
/**
 *
 * This class provides a "Biome", which can store one Village.
 * It has to have a name and a kind (e.g. "desert", "gras"...).
 *
 *
 * @author Paul Jureschek
 *
 */


public class Biome {
	private String name;
	private String kind;
	private Village village;

	/**
	 * Generates new Biome.
	 *
	 * @param name name of biome
	 * @param kind kind of biome (e.g. "desert", "gras"...)
	 */
	public Biome(String name, String kind) {
		this.name = name;
		this.kind = kind;
	}

	/**
	 * Returns name of Biome.
	 *
	 * @return name of Biome
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns kind of Biome (e.g. "desert", "gras"...).
	 *
	 * @return kind of Biome (e.g. "desert", "gras"...)
	 */
	public String getKind() {
		return kind;
	}

	/**
	 * Returns Village saved in Biome (built on Biome).
	 *
	 * @return Village saved in Biome (built on Biome)
	 */
	public Village getVillage() {
		return village;
	}

	/**
	 * Adds existing Village to Biome.
	 * @param village Village Element of type Village that should be added to this Biome
	 */

	public void addVillage(Village village) {
		this.village = village;
	}


}


