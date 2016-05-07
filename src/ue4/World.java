package ue4;

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
	@Override
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
	 * @param x x-coordinate of biome
	 * @param y y-coordinate of biome
	 * @return Biome slot from array Biome[][]
	 */

	public Biome getBiome(int x, int y) {
		return biome[x][y];
	}
	
	/**
	 * Set the array biomes
	 * @param biome Biome[] array
	 */
	
	private void setBiome(Biome[][] biome) {
		this.biome = biome;
		
	}
	
	
	
	//METHODS to make finding objects easier:
	
	/**
	 * Returns Biome identified by name string.
	 * @param name name of biome
	 * @return Biome object with matching name
	 */
	public Biome getBiomeByName(String name) {
		// Iterate over x-axis 
		for (int i = 0; i < MAX_NUM_BIOMES; i++) {
			// Iterate over y-axis
			for (int k = 0; k < World.getMaxNumBiomes(); k++) {
				if (this.getBiome()[i][k].getName().equals(name)) {
					return this.getBiome(i, k);
				}
			}
		}
		return null;
	}
	
	/**
	 * This method finds a Village by its name and doesn't care where in the world it is located.
	 * @param name name of Village to Find
	 * @return Village object with matching name
	 */
	public Village getVillageByName(String name) {
		// Iterate over x-axis 
		for (int i = 0; i < MAX_NUM_BIOMES; i++) {
			// Iterate over y-axis
			for (int k = 0; k < World.getMaxNumBiomes(); k++) {
				// Iterate over Villages
				for (int j = 0; j < this.getBiome(i, k).getAmountVillages(); j++) {
					if (this.getBiome(i, k).getVillage()[j].getName().equals(name)) {
						return this.getBiome(i, k).getVillage()[j];
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * This method finds a Villager identified by its name and doesn't care where in the world it is located.
	 * @param name name of Villager
	 * @return Villager object with matching name
	 */
	public Villager getVillagerByName(String name) {
		// Iterate over x-axis
		for (int i = 0; i < MAX_NUM_BIOMES; i++) {
			// Iterate over y-axis
			for (int k = 0; k < World.getMaxNumBiomes(); k++) {
				//Iterate over Villages
				for (int j = 0; j < this.getBiome(i, k).getVillage().length; j++) {
					if (this.getBiome(i, k).getVillage()[j] == null) {
						continue;
					}
					//Iterate over Villagers
					for (int z = 0; z < this.getBiome(i, k).getVillage()[j].getVillager().length; z++) {
						if (this.getBiome(i, k).getVillage()[j].getVillager()[z] == null) {
							continue;
						}
						
						if (this.getBiome(i, k).getVillage()[j].getVillager()[z].getName().equals(name)) {
							return this.getBiome(i, k).getVillage()[j].getVillager()[z];
						}
					}
				}
			}
		}
		return null;
	}
	
}

	
