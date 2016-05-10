package ue5;

import java.util.ArrayList;

public class KernTest_ue5 {
	public static void main(String[] args) {
		Biome biome;
		ArrayList <Villager> forbes = new ArrayList<Villager>(); // needed for ue5 - comparator test

		
		WorldUtilities worldutilities = new WorldUtilities();
		World world =  worldutilities.readWorldFromFile("input_file/ue4/weltMitTieren.txt");
		worldutilities.writeWorldToFile(world, "output_file/ue4/weltMitTieren.txt");
		
		System.out.println(world.getBiome(0, 0));
		System.out.println(world.getBiome(0, 1));
		System.out.println(world.getBiome(0, 2));
		System.out.println(world.getVillagerByName("Dieter Knodel").getPets()[1].toString());
		
		
		//Test Meat
		Meat meat = world.getBiome()[0][0].getVillage()[1].getVillager()[0].getPets()[0].slaughter();
		
		System.out.println("\n" + world.getBiome()[0][0].getVillage()[1].getVillager()[0].getPets()[0].toString());
		System.out.println(meat.toString());
		System.out.println(AnimalEnum.WOLF.getMaxWeight());
		
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
