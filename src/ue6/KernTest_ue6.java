package ue6;

import javax.swing.text.html.HTMLDocument.Iterator;

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
		
		// example animals cows
		System.out.println(world.getBiome()[0][0].getVillage()[0].getVillager()[2].getPets()[0]);
		System.out.println(world.getBiome()[0][0].getVillage()[0].getVillager()[2].getPets()[1]);
		
		// example animals 
		
		//Test Case 1: cage is full
		Cage<Animal> cage1 = new Cage<Animal>();
		cage1.putInCage(world.getBiome()[0][0].getVillage()[0].getVillager()[2].getPets()[0]);
		cage1.putInCage(world.getBiome()[0][0].getVillage()[0].getVillager()[2].getPets()[1]);
		cage1.putInCage(world.getBiome()[0][0].getVillage()[0].getVillager()[2].getPets()[1]);
		cage1.putInCage(world.getBiome()[0][0].getVillage()[0].getVillager()[2].getPets()[1]);
		cage1.putInCage(world.getBiome()[0][0].getVillage()[0].getVillager()[2].getPets()[1]);
		// test passed successfully
		
		// Test Case 2: toString of Cage
		System.out.println(cage1.toString());
		// test passed successfully
	
		
		
		
		
		
	}
}
