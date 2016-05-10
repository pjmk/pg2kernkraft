package ue5;

public class KernTest_ue5 {
	public static void main(String[] args) {

		
		WorldUtilities worldutilities = new WorldUtilities();
		World world =  worldutilities.readWorldFromFile("input_file/ue4/weltMitTieren.txt");
		worldutilities.writeWorldToFile(world, "output_file/ue4/weltMitTieren.txt");
		
		System.out.println(world.getBiome(0, 0));
		System.out.println(world.getBiome(0, 1));
		System.out.println(world.getBiome(0, 2));
		System.out.println(world.getVillagerByName("Dieter Knodel").getPets()[1].toString());
		
		
		//Test Meat
		Meat meat = world.getBiome()[0][0].getVillage()[1].getVillager()[0].getPets()[0].slaughter();
		
		System.out.println("\n" + world.getBiome()[0][0].getVillage()[1].getVillager()[0].getPets()[0].toString());
		System.out.println(meat.toString());
		System.out.println(AnimalEnum.WOLF.getMaxWeight());
	}
	
}
