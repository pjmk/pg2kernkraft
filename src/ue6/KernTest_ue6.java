package ue6;
import java.util.Iterator;

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
		System.out.println("\n\nExample animals:\n ");
		System.out.println(world.getBiome()[0][0].getVillage()[0].getVillager()[2].getPets()[0]);
		System.out.println(world.getBiome()[0][0].getVillage()[0].getVillager()[2].getPets()[1]);
		
		// example animals chicken and wolf
		System.out.println(world.getBiome()[0][0].getVillage()[1].getVillager()[0].getPets()[0]);
		System.out.println(world.getBiome()[0][0].getVillage()[1].getVillager()[0].getPets()[1]);
		System.out.println(world.getBiome()[0][0].getAnimals()[0]);
		
		//Test Case 1: cage is full
		System.out.println("\n\nTest Case 1: cage is full: \n ");
		Cage<Animal> cage1 = new Cage<Animal>();
		cage1.putInCage(world.getBiome()[0][0].getVillage()[0].getVillager()[2].getPets()[0]);
		cage1.putInCage(world.getBiome()[0][0].getVillage()[0].getVillager()[2].getPets()[1]);
		cage1.putInCage(world.getBiome()[0][0].getVillage()[0].getVillager()[2].getPets()[1]);
		cage1.putInCage(world.getBiome()[0][0].getVillage()[0].getVillager()[2].getPets()[1]);
		cage1.putInCage(world.getBiome()[0][0].getVillage()[0].getVillager()[2].getPets()[1]);
		cage1.putInCage(world.getBiome()[0][0].getVillage()[0].getVillager()[2].getPets()[1]);
		cage1.putInCage(world.getBiome()[0][0].getVillage()[0].getVillager()[2].getPets()[1]);
		cage1.putInCage(world.getBiome()[0][0].getVillage()[0].getVillager()[2].getPets()[1]);
		// test passed successfully
		
		// Test Case 2: toString of Cage
		System.out.println("\n\nTest Case 2: toString of Cage: \n ");
		System.out.println(cage1.toString());
		// test passed successfully
		
		
		//Test Case 3: wolf eat chicken
		System.out.println("\n\nTest Case 3: wolf eat chicken \n ");
		Cage<Animal> cage2 = new Cage<Animal>();
		cage2.putInCage(world.getBiome()[0][0].getVillage()[1].getVillager()[0].getPets()[0]);
		cage2.putInCage(world.getBiome()[0][0].getVillage()[1].getVillager()[0].getPets()[1]);
		cage2.putInCage(world.getBiome()[0][0].getAnimals()[0]);

		Iterator<Animal> iti = cage2.iterator();
		
		while(iti.hasNext()) {
			System.out.println(iti.next());
		}
		// test passed successfully
		
		
		//Test Case 4: Only Chickens
		System.out.println("\n\nTest Case 4: Only Chickens \n ");
		Cage<Chicken> cage3 = new Cage<Chicken>();
		cage3.putInCage((Chicken)world.getBiome()[0][0].getVillage()[1].getVillager()[0].getPets()[0]);
		cage3.putInCage((Chicken)world.getBiome()[0][0].getVillage()[1].getVillager()[0].getPets()[1]);
		

		Iterator<Chicken> iti2 = cage3.iterator();
				
		while(iti2.hasNext()) {
			System.out.println(iti2.next());
		}
		// test passed successfully
		
		
		//Test Case 5: Only Pets: Chicken and Cows
		System.out.println("\n\nTest Case 5: Only Pets: Chicken and Cows\n ");
		Cage<Pet> cage4 = new Cage<Pet>();
		cage4.putInCage(world.getBiome()[0][0].getVillage()[1].getVillager()[0].getPets()[0]);
		cage4.putInCage(world.getBiome()[0][0].getVillage()[1].getVillager()[0].getPets()[1]);
		cage4.putInCage(world.getBiome()[0][0].getVillage()[0].getVillager()[2].getPets()[0]);
		cage4.putInCage(world.getBiome()[0][0].getVillage()[0].getVillager()[2].getPets()[1]);
		//cage3.putInCage(world.getBiome()[0][0].getAnimals()[0]);

		Iterator<Pet> iti3 = cage4.iterator();
						
		while(iti3.hasNext()) {
			System.out.println(iti3.next());
		}
		// test passed successfully
				
	}
}
