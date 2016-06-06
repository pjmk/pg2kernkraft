package ue9;

/**
 * Main for testing current project.
 *
 * @author Paul Jureschek, Michael Kinzkofer
 *
 */

public class KernTest_ue9 {
	public static void main(String[] args) {

		WorldUtilities worldutilities = new WorldUtilities();
		
		// Test case for NoSuchKeywordsException:
		
	/*	
		try {
		World world =  worldutilities.readWorldFromFile("input_file/ue9/welt_ue9.txt");
		
		} catch (NoSuchKeywordsException e) {
			//changed first BIOME to BIOMEse in File to check NoSuchKeywordsException
		System.out.println("\nTest case for NoSuchKeywordsException:\n");
		e.printStackTrace();
		}
*/	
		
		
		// Test case for NoSuchFileException:
		
/*		
		System.out.println("\nTest case for NoSuchFileException:\n");
		try {
		World	world2 = worldutilities.readWorldFromFile("input_file/ue10/welt_ue8.txt");
		} catch (NoSuchKeywordsException e) {
		}
*/		
		
		// Test case for ProfessionsException:
		

	   try {
		   World world3 = worldutilities.readWorldFromFile("input_file/ue9/welt_Professions_ue9.txt");
		} catch (NoSuchKeywordsException e) {
			e.printStackTrace();
		}

		
		System.out.println("Test end");
	}
}
