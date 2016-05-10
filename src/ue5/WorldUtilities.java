package ue5;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
*
* This class contains utilities to read World-object from file 
* or write a World-object to file.
*
* @author Paul Jureschek, Michael Kinzkofer
*
*/

public class WorldUtilities {
	private static final int NUM_VILLAGES_OVERALL = Biome.getMaxNumVillages() * World.getMaxNumBiomes() *  World.getMaxNumBiomes();
	private int currentBiomeX;
	private int currentBiomeY;
	private int currentVillage;
	private int currentVillager;
	private static int villageNum;
	private World world = null;
	private static int villagePopulation[] = new int[NUM_VILLAGES_OVERALL];
	private int villageProffesions[][] = new int[NUM_VILLAGES_OVERALL][2];
		
	/**
	 * Read World-object from file(format: .txt). 
	 * @param pathToFile path to file to load
	 * @return World-object
	 */
	
	public World readWorldFromFile(String pathToFile) {
		try {
			File datei = new File("input_file/ue3/weltMitBerufen.txt");
			Scanner sc = new Scanner(datei);
			
			while( sc.hasNextLine() ) {
				// reads a single row and splits each word in inputData[] array 
				String zeile = sc.nextLine(); 
				String[] inputData = zeile.split(";|\\:");
				
				// counts villagers, farmers and doctors
				switch(inputData[0]) {
					case Keywords.WORLD:	break;
					case Keywords.BIOME: 	break;
					case Keywords.VILLAGE: 	villageNum++;
											break;
					case Keywords.VILLAGER:	//System.out.println("job: " + inputData[7]);
											WorldUtilities.villagePopulation[villageNum - 1]++;
											if (inputData[7].toUpperCase().contains(Keywords.DOCTOR)) {
												//System.out.println("im in doctor" + (villageNum - 1));
												villageProffesions[villageNum - 1][0]++;
											}
											if (inputData[7].toUpperCase().contains(Keywords.FARMER)){
												//System.out.println("im in farmer");
												villageProffesions[villageNum - 1][1]++;
											}
											break;
					// For animals there is nothing to do here!
					case Keywords.WOLF: 	 
					case Keywords.CAMEL:	
											
					case Keywords.COW:
					case Keywords.CHICKEN: break;
				}
			} 
			sc.close();
		} catch (Exception e) {
			// Troubleshooting
			System.out.println("Something went wrong, while reading from file and counting population!");
		}
	
		try {
			File datei = new File(pathToFile);
			Scanner sc = new Scanner(datei);
			// reset villageNum
			villageNum = 0;
			
			while( sc.hasNextLine() ) {
				// reads a single row and splits each word in inputData[] array  
				String row = sc.nextLine(); 
				String[] inputData = row.split(";|\\:");
				
				switch(inputData[0]) {
					case Keywords.WORLD:	// creates name of new world
											world = new World(inputData[1]);				
											break;
					case Keywords.BIOME:	// corrects the index of biome[x][y] array
											if (currentBiomeY == World.getMaxNumBiomes()) {
												currentBiomeX++;
												currentBiomeY = 0;
											}
											// compares input-string to enum Nature
											if (!Nature.isEqualToNatureElement(inputData[3]))
												continue;
											// creates new biome
											Biome biome = new Biome(row);
											world.getBiome()[currentBiomeX][currentBiomeY] = biome;
											// corrects the index of biome[][y] and village[] array
											currentBiomeY++;
											currentVillage = 0;
											break;
					case Keywords.VILLAGE:	// check amount of farmers and doctors
											if (checkProfession()) {
												// creates new village
												Village village = new Village(row);
												world.getBiome()[currentBiomeX][currentBiomeY - 1]
														.getVillage()[currentVillage] = village;
												/*
												 *  corrects the index of village[],villagePopulation[]
												 *   and villager[] array
												 */
												currentVillage++;
												currentVillager = 0;
											}
											villageNum++;
											break;
					case Keywords.VILLAGER:	// compares input-string to enum Gender
											if (!Gender.isEqualToGenderElement(inputData[3]) || !Profession.isEqualToProfessionElement(inputData[7])  )
												continue;
											/*
											 * creates new villager, saves it in and corrects
											 *  the index of villager[] array
											 */
											Villager villager = new Villager(row);
											world.getBiome()[currentBiomeX][(currentBiomeY % 5) - 1]
													.getVillage()[currentVillage - 1]
															.getVillager()[currentVillager] = villager;
											currentVillager++;
											break;
											
					//Load Animals
					case Keywords.WOLF: 	
											// Need to also pass world object, so we can find fitting Biome object in constructor						
											new Wolf(row, world);
											break;
											
					case Keywords.CAMEL:    // Need to also pass world object, so we can find fitting Biome object in constructor
											new Camel(row, world);
											break;
											
					case Keywords.CHICKEN:  // Need to also pass world object, so we can find fitting Villager object in constructor
											new Chicken(row, world);
											break;
											
					case Keywords.COW:		// Need to also pass world object, so we can find fitting Villager object in constructor
											new Cow(row, world);
											break;
											
					default:				System.out.println("No Keyword found for: " + inputData[0]);
				}
			}
			sc.close();
		} catch (Exception e) {
			// Troubleshooting		
			System.out.println("Something went wrong, while reading the file!: " + e + "\n");
			e.printStackTrace();
		}
		return world;
	}
	
	/**
	 * Write World-object from file (format: .txt). 
	 * @param world  World-object
	 * @param pathToFile path to file where world will be saved
	 */
	
	public void  writeWorldToFile(World world, String pathToFile) {
		try { 
			FileWriter datei = new FileWriter(pathToFile);
			BufferedWriter writer = new BufferedWriter(datei);
			
			writer.write(world.toString());
			
			// loop for first index [x][] of biome[][] array 
			for (int i = 0; i < World.getMaxNumBiomes(); i++) {
				
				// loop for second index [][y] of biome[][] array
				for(int j = 0; j < World.getMaxNumBiomes() ; j++) {
					if (world.getBiome()[i][j] == null)
						break;
					
					writer.newLine();
					writer.write(world.getBiome()[i][j].toString());
					
					//loop for (wild) animals[] array
					for (int z = 0; z < world.getBiome(i, j).getAnimals().length; z++) {
						if (world.getBiome(i, j).getAnimals()[z] == null) {
							break;
						}
						
						writer.newLine();
						writer.write(world.getBiome(i, j).getAnimals()[z].toString());
					}
					
					// loop for village[] array
					for(int k = 0; k < world.getBiome()[i][j].getVillage().length; k++ ) {
						if (world.getBiome()[i][j].getVillage()[k] == null)
							break;
						
						writer.newLine();
						writer.write(world.getBiome()[i][j].getVillage()[k].toString());			
					
						// loop for villager[] array
						for(Villager villager : world.getBiome()[i][j].getVillage()[k].getVillager()){
							if (villager == null)
								break;
							
							writer.newLine();
							writer.write(villager.toString());
							
							// loop for pets[] array
							for(int h = 0; h < villager.getPets().length; h++) {
								if (villager.getPets()[h] == null) {
									continue;
								}
								
								writer.newLine();
								writer.write(villager.getPets()[h].toString());
							}
						}
					}
				}
			}
		writer.close(); 
		} catch (Exception e){
			// Troubleshooting
			System.out.println("Something went wrong, while writing world to file!: " + e);
			e.printStackTrace();
		}	
	}
	
	/**
	 * Converts string in lower case with exception of first letter.   
	 * @param string String
	 * @return String in lower case with exception of first letter
	 */
	
	static public String convertUpper(String string) {
	    String firstLetter, rest;
	    firstLetter = string.substring(0,1).toUpperCase();
	    rest = string.substring(1).toLowerCase();
	    return (firstLetter+rest);
	}
	
	/**
	 * Returns Amount of villages.
	 * @return Amount of villages 
	 */
	
	public static int getVillageNum() {
		return villageNum;
	}

	/**
	 * Returns Population for every village.
	 * @return Population for every village 
	 */
	
	public static int[] getVillagePopulation() {
		return villagePopulation;
	}
	
	/**
	 * Returns true if the amount of farmers and doctor is enough
	 * for creating new village. Otherwise returns false.   
	 * @return boolean
	 */
	
	private boolean checkProfession(){
		/*
		 * amount of farmers and doctors is saved in villageProffesion[][] array
		 * short explanation: 
		 * villageProffesions[villageNum][0] == amount of doctors in this village
		 * villageProffesions[villageNum][1] == amount of farmers in this village
		 */
		if (villageProffesions[villageNum][0] >= 1 && villageProffesions[villageNum][1] >= 2)
			return true;
		else
			 // Troubleshooting
		    System.out.println("error: village # " + villageNum + " misses farmes and/or doctors."
		    		+ "\nfailed to initialize village...");
		return false;
	}
	
	
}