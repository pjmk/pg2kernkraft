package ue8;
import java.util.Iterator;

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
		World world =  worldutilities.readWorldFromFile("input_file/ue7/weltMitTieren.txt");

		// Save the World again
		worldutilities.writeWorldToFile(world, "output_file/ue8/weltMitTieren.txt");
		
		// test population
		System.out.println(world.getBiome(0, 0).getVillages().get("Kerningen").getName());
		System.out.println(world.getBiome(0, 0).getVillages().get("Kerningen").getPopulation());
		System.out.println(world.getBiome(0, 0).getVillages().get("Kerningen").getVillager().size());
	}
}
