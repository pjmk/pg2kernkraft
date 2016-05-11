package ue5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Main for testing current project.
 *
 * @author Paul Jureschek, Michael Kinzkofer
 *
 */


public class KernTest_ue5 {
	public static void main(String[] args) {
		System.out.println("List of Creatures with their coordinates:\n");

		Biome biome;
		ArrayList <Villager> forbes = new ArrayList<Villager>(); // needed for ue5 - comparator test


		// read world
		WorldUtilities worldutilities = new WorldUtilities();
		World world =  worldutilities.readWorldFromFile("input_file/ue5/weltMitTieren.txt");

		/*
		 * Test Meat:
		 * Meat will be returned and the animal will be deleted
		 * in this case : CHICKEN:Henriette
		 */

		System.out.println("\ntesting class Meat:");
		System.out.println("\n" + world.getBiome()[0][0].getVillage()[1].getVillager()[0].getPets()[0].toString());
		Meat meat = world.getBiome()[0][0].getVillage()[1].getVillager()[0].getPets()[0].slaughter();
		System.out.println(meat.toString());
		System.out.println(AnimalEnum.WOLF.getMaxWeight()+ "\n");


		// Save the World again
		worldutilities.writeWorldToFile(world, "output_file/ue5/weltMitTieren.txt");

		//print Villages list (needed in ue5):
		System.out.println("List of Villages:\n");
		while (world.hasNext()) {
			biome = world.next();
			while (biome.hasNext()) {
				Village village = biome.next();
				System.out.println(village + " POPULATION: " + Integer.toString(village.getPopulation()) + " " + biome);
			}
		}

		// print forbes list (needed in ue5):
		System.out.println("\nForbes list:");
		world.resetIndices();
		while (world.hasNext()) {
			biome = world.next();
			biome.resetIndex();
			while (biome.hasNext()) {
				Village village = biome.next();
				for (int z = 0; z < village.getVillager().length; z++) {
					if (village.getVillager()[z] == null) {
						break;
					}
					// fill ArrayList with all Villager elements in the world:
					forbes.add(village.getVillager()[z]);
				}
			}
		}

		System.out.println();
		// sort ArrayList forbes
		Object[] forbesSort = forbes.toArray();
		Arrays.sort(forbesSort, Collections.reverseOrder());
//		System.out.println(Arrays.toString(forbesSort));
		System.out.println();

		// print forbes list
		for (int k = 1; k < forbes.size(); k++) {
			System.out.println(((Villager) forbesSort[k]).getName() + " - Wealth: " + Integer.toString(((Villager) forbesSort[k]).getWealth()));
		}
	}
}
