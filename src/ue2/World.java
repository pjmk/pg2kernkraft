package ue2;

/**
*
* This class provides a "World", which can store multiple numbers of Biomes.
* It has to have a name.
*
* @author Paul Jureschek, Michael Kinzkofer
*
*/

public class World {
	private static final int MAX_NUM_BIOMES = 20;
	private String name;
	private Biome[] biome;

	/**
	 * Generates new World.
	 * @param name name of world
	 */
	
	public World (String name) {
		this.name = name;
		this.setBiome(new Biome[MAX_NUM_BIOMES]);
	}

	/**
	 * Returns name of the world.
	 * @return name of world
	 */
	
	public String toString() {
       return "WORLD:" + name;
	}
	
	/**
	 * get array Biome[]
	 * @return array Biome[]
	 */

	public Biome[] getBiome() {
		return biome;
	}
	
	/**
	 * Returns constant MAX number of Biomes.
	 * @return constant MAX number of Biomes
	 */
	
	public static int getMaxNumBiomes() {
		return MAX_NUM_BIOMES;
	}
	
	
	/**
	 * Set the array biomes
	 * @param biomes Biome[] array
	 */
	
	private void setBiome(Biome[] biomes) {
		this.biome = biomes;
		
	}

	
}	