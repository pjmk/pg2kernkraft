package ue6;


/**
 * Main for testing current project.
 *
 * @author Paul Jureschek, Michael Kinzkofer
 *
 */


public class KernTest_ue6 {
	public static void main(String[] args) {

		// read world
		WorldUtilities worldutilities = new WorldUtilities();
		World world =  worldutilities.readWorldFromFile("input_file/ue6/weltMitTieren.txt");

		// Save the World again
		worldutilities.writeWorldToFile(world, "output_file/ue6/weltMitTieren.txt");
		
		
		
		
	}
}
