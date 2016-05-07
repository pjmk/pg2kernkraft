package ue3;

/**
*
* This class provides a "World", which can store multiple numbers of Biomes.
* It has to have a name.
*
* @author Paul Jureschek, Michael Kinzkofer
*
*/

public class World {
	private static final int MAX_NUM_BIOMES = 5;
	private String name;
	private Biome[][] biome;

	/**
	 * Generates new World.
	 * @param name name of world
	 */
	
	public World (String name) {
		this.name = name;
		this.setBiome(new Biome[MAX_NUM_BIOMES][MAX_NUM_BIOMES]);
	}

	/**
	 * Returns name of the world.
	 * @return name of world
	 */
	
	public String toString() {
       return "WORLD:" + name;
	}
	
	/**
	 * Returns constant MAX number of Biomes.
	 * @return constant MAX number of Biomes
	 */
	
	public static int getMaxNumBiomes() {
		return MAX_NUM_BIOMES;
	}
	
	/**
	 * get array Biome[][]
	 * @return array Biome[][]
	 */

	public Biome[][] getBiome() {
		return biome;
	}
	
	/**
	 * get Biome slot from array Biome[][]
	 * @return Biome slot from array Biome[][]
	 */

	public Biome getBiome(int x, int y) {
		return biome[x][y];
	}
	
	/**
	 * Set the array biomes
	 * @param biomes Biome[] array
	 */
	
	private void setBiome(Biome[][] biome) {
		this.biome = biome;
		
	}
	
}

	
