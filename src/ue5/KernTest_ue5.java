package ue5;

import java.util.Arrays;

public class KernTest_ue5 {
	public static void main(String[] args) {
		Biome biome;

		
		WorldUtilities worldutilities = new WorldUtilities();
		World world =  worldutilities.readWorldFromFile("input_file/ue4/weltMitTieren.txt");
		worldutilities.writeWorldToFile(world, "output_file/ue4/weltMitTieren.txt");
		
		System.out.println(world.getBiome(0, 0));
		System.out.println(world.getBiome(0, 1));
		System.out.println(world.getBiome(0, 2));
		System.out.println(world.getVillagerByName("Dieter Knodel").getPets()[1].toString());
		
		Meat meat = new Meat(5, 10, AnimalEnum.COW);
		System.out.println(meat.toString());
		
		
		System.out.println(world.getBiome(0, 0).getVillage()[1]);
		
		System.out.println();
		// Testing of interface Iterator:
		while (world.hasNext()) {
			biome = world.next();
			while (biome.hasNext()) {
				System.out.println("test");
				Village village = biome.next();
				System.out.println(village + " POPULATION: " + Integer.toString(village.getPopulation()) + " " + biome);
			}
			
		}
		
	}
}
