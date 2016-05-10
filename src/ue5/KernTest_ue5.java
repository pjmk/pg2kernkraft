package ue5;

public class KernTest_ue5 {
	public static void main(String[] args) {
		
		// read and write world 
		WorldUtilities worldutilities = new WorldUtilities();
		World world =  worldutilities.readWorldFromFile("input_file/ue5/weltMitTieren.txt");
		
		/*
		 * Test Meat:
		 * Meat will be returned and the animal will be deleted
		 * in this case : CHICKEN:Henriette
		 */
		System.out.println("\n" + world.getBiome()[0][0].getVillage()[1].getVillager()[0].getPets()[0].toString());
		Meat meat = world.getBiome()[0][0].getVillage()[1].getVillager()[0].getPets()[0].slaughter();
		System.out.println(meat.toString());
		System.out.println(AnimalEnum.WOLF.getMaxWeight());
		
		// Save the World again
		worldutilities.writeWorldToFile(world, "output_file/ue5/weltMitTieren.txt");
	}
	
}
