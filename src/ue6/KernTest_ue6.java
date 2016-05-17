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
		
		//example animals
		System.out.println(world.getBiome()[0][0].getVillage()[0].getVillager()[2].getPets()[0]);
		System.out.println(world.getBiome()[0][0].getVillage()[0].getVillager()[2].getPets()[1]);
		
		Cage<Animal> cage1 = new Cage<Animal>();
		cage1.putInCage(world.getBiome()[0][0].getVillage()[0].getVillager()[2].getPets()[0]);
		cage1.putInCage(world.getBiome()[0][0].getVillage()[0].getVillager()[2].getPets()[1]);
		System.out.println(cage1.toString());
		
		
	}
}
