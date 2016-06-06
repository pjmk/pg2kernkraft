package ue9;

/**
 * Main for testing current project.
 *
 * @author Paul Jureschek, Michael Kinzkofer
 *
 */

public class KernTest_ue9 {
	public static void main(String[] args) {
		
		System.out.println("\nTest case for NoSuchKeywordsException:\n");
		
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
	World world2;
	
	try {
		world2 = worldutilities.readWorldFromFile("input_file/ue10/welt_ue8.txt");
		worldutilities.writeWorldToFile(world2, "output_file/ue9/welt_ue8.txt");
	} catch (NoSuchKeywordsException e) {
		e.printStackTrace();
	}
	
	
	System.out.println("Test end");
	}
}
