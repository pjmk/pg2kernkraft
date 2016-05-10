package ue5;

import java.util.ArrayList;

public class KernTest_ue5 {
	public static void main(String[] args) {

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
		System.out.println("\n" + world.getBiome()[0][0].getVillage()[1].getVillager()[0].getPets()[0].toString());
		Meat meat = world.getBiome()[0][0].getVillage()[1].getVillager()[0].getPets()[0].slaughter();
		System.out.println(meat.toString());
		System.out.println(AnimalEnum.WOLF.getMaxWeight());
		

		// Save the World again
		worldutilities.writeWorldToFile(world, "output_file/ue5/weltMitTieren.txt");

		//print Villages list (needed in ue5):
		while (world.hasNext()) {
			biome = world.next();
			while (biome.hasNext()) {
				Village village = biome.next();
				System.out.println(village + " POPULATION: " + Integer.toString(village.getPopulation()) + " " + biome);
			}
		}
		
		// print forbes list (needed in ue5):
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
		// sort ArrayList forbes
		for (int k = 0; k < forbes.size(); k++) {
			for (int i = 1; i < forbes.size(); i++)
			if (forbes.get(i).compare(forbes.get(i), forbes.get(i - 1)) > 0) {
				Villager vil = forbes.get(i);
				forbes.set(i, forbes.get(i - 1));
				forbes.set(i - 1, vil);
			}
		}
		// print forbes list
		for (int k = 1; k < forbes.size(); k++) {
			System.out.println(forbes.get(k).getName() + " - Wealth: " + Integer.toString(forbes.get(k).getWealth()));
		}
	}
}
