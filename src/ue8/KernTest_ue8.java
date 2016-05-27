package ue8;

/**
 * Main for testing current project.
 *
 * @author Paul Jureschek, Michael Kinzkofer
 *
 */

public class KernTest_ue8 {
	public static void main(String[] args) {

		// read world
		WorldUtilities worldutilities = new WorldUtilities();
		World world =  worldutilities.readWorldFromFile("input_file/ue8/welt_ue8.txt");

		// Save the World again
		worldutilities.writeWorldToFile(world, "output_file/ue8/welt_ue8.txt");
		
		// test Map getBiomesVillagesByName
		world.logBiomesVillagesByNameToConsole(world.getBiomesVillagesByName("Kerningen"));
		
	}
}
