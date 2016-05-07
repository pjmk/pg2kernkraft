package ue3;

public class KernTest {
	public static void main(String[] args) {

		
		WorldUtilities worldutilities = new WorldUtilities();
		World world =  worldutilities.readWorldFromFile();
		worldutilities.writeWorldToFile(world);
		
		System.out.println(world.getBiome(0, 0));
		System.out.println(world.getBiome(0, 1));
		System.out.println(world.getBiome(0, 2));		
	}
}
