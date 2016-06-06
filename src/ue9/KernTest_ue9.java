package ue9;

/**
 * Main for testing current project.
 *
 * @author Paul Jureschek, Michael Kinzkofer
 *
 */

public class KernTest_ue9 {
	public static void main(String[] args) {

		// read world
		WorldUtilities worldutilities = new WorldUtilities();
		try {
		World world =  worldutilities.readWorldFromFile("input_file/ue9/welt_ue8.txt");
		
		
		// Save the World again
		worldutilities.writeWorldToFile(world, "output_file/ue9/welt_ue8.txt");
		
		// test Map getBiomesVillagesByName
		world.logBiomesVillagesByNameToConsole(world.getBiomesVillagesByName("Kerningen"));	
		
	} catch (NoSuchKeywordsException e) {
		e.printStackTrace();
	}
		
	// Test case for NoSuchFileException
	System.out.println("\nTest case for NoSuchFileException:\n");
	World world;
	try {
		world = worldutilities.readWorldFromFile("input_file/ue10/welt_ue8.txt");
		worldutilities.writeWorldToFile(world, "output_file/ue9/welt_ue8.txt");
	} catch (NoSuchKeywordsException e) {
		e.printStackTrace();
	}
	
	
	}
}
