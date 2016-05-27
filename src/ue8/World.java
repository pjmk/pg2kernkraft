package ue8;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
*
* This class provides a "World", which can store multiple numbers of Biomes.
* It has to have a name.
*
* @author Paul Jureschek, Michael Kinzkofer
*
*/

public class World implements Iterator<Biome> {
	private static final int MAX_NUM_BIOMES = 5;
	private String name;
	private Biome[][] biome;
	
	//For Iterator Implementation
	private int xIndex = 0;
	private int yIndex = 0;

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
	 * Returns current xIndex used by Iterator implementation.
	 * @return the xIndex
	 */
	public int getxIndex() {
		return xIndex;
	}

	/**
	 * Reset indices, so iterator can go over everything again.
	 * Sets xIndex and yIndex used by Iterator implementation to 0.
	 */
	public void resetIndices() {
		xIndex = 0;
		yIndex = 0;
	}

	/**
	 * Returns current yIndex used by Iterator implementation.
	 * @return the yIndex
	 */
	public int getyIndex() {
		return yIndex;
	}

	/**
	 * Set the array biomes.
	 * @param biome Biome[] array
	 */
	
	private void setBiome(Biome[][] biome) {
		this.biome = biome;
		
	}
	
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
				for (Village village : this.getBiome(i, k).getVillages().values()) {
					if(village.getName().equals(name)) {
						return village;
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
				// Iterate over Villages	
				for (Village village : this.getBiome(i, k).getVillages().values()) {
					//Now get the Villager
					if (village.getVillager().get(name) == null) {
						continue;
					} else {
						return village.getVillager().get(name);
					}
				}
			}
		}
		System.out.println("Could not find Villager: " + name);
		return null;
	}

	/**
	 * Checks if there is another Biome after the current index or not.
	 * @return whether there is another Biome after the index or not as boolean
	 */
	@Override
	public boolean hasNext() {
		if (xIndex == MAX_NUM_BIOMES && yIndex == MAX_NUM_BIOMES) {
			return false;
		}
		if (biome[xIndex][yIndex] == null) {
			return false;

		}
		return true;
	}
	
	/**
	 * Returns Biome object, at current Index. 
	 * Additionally it increments index if hasNext() is true.
	 * @return Biome object, that is next
	 */
	@Override
	public Biome next() {
		int oldYIndex = yIndex;
		int oldXIndex = xIndex;
		if (hasNext()) {
			if (yIndex < MAX_NUM_BIOMES - 1) { 
				yIndex++;
			} else {
				xIndex++;
				yIndex = 0;
			}
		} else {
			throw new NoSuchElementException("No biome in array at position: biome[" + xIndex + "]" + "[" + yIndex + "]");
		}
		return biome[oldXIndex][oldYIndex];
	}
}

	
