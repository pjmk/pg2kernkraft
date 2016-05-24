package ue7;
import java.util.Iterator;

/**
 * Main for testing current project.
 *
 * @author Paul Jureschek, Michael Kinzkofer
 *
 */

public class KernTest_ue7 {
	public static void main(String[] args) {

		// read world
		WorldUtilities worldutilities = new WorldUtilities();
		World world =  worldutilities.readWorldFromFile("input_file/ue7/weltMitTieren.txt");

		// Save the World again
		worldutilities.writeWorldToFile(world, "output_file/ue7/weltMitTieren.txt");
		
		// test population
		System.out.println(world.getBiome(0, 0).getVillage().get(0).getName());
		System.out.println(world.getBiome(0, 0).getVillage().get(0).getPopulation());
		System.out.println(world.getBiome(0, 0).getVillage().get(0).getVillager().size());
	}
}
