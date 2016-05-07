package ue3;
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
	private int villageNum;
	private World world = null;
	private int villagePopulation[] = new int[NUM_VILLAGES_OVERALL];
	private int villageProffesions[][] = new int[NUM_VILLAGES_OVERALL][2];
	
	/**
	 * Generates new object, counts all villagers from file(format: .txt)
	 * and checks the amount of doctors and farmers.
	 */
	
	public WorldUtilities(){
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
											this.villagePopulation[villageNum - 1]++;
											if (inputData[7].toUpperCase().contains(Keywords.DOCTOR)) {
												//System.out.println("im in doctor" + (villageNum - 1));
												villageProffesions[villageNum - 1][0]++;
											}
											if (inputData[7].toUpperCase().contains(Keywords.FARMER)){
												//System.out.println("im in farmer");
												villageProffesions[villageNum - 1][1]++;
											}
											break;
				}
			} 
			sc.close();
		} catch (Exception e) {
			// Troubleshooting
			//System.out.println("Something went wrong. File does not exist!");
		}
		//System.out.println(villagePopulation[2]);
		//System.out.println(villageProffesions[0][0]);
	}
	
	/**
	 * Read World-object from file(format: .txt). 
	 * @return  World-object
	 */
	
	public World readWorldFromFile() {
		try {
			File datei = new File("input_file/ue3/weltMitBerufen.txt");
			Scanner sc = new Scanner(datei);
			
			// reset villageNum
			villageNum = 0;
			
			while( sc.hasNextLine() ) {
				// reads a single row and splits each word in inputData[] array  
				String zeile = sc.nextLine(); 
				String[] inputData = zeile.split(";|\\:");
				
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
											if (!Nature.containsNatureElement(inputData[3]))
												continue;
											// creates new biome
											Biome biome = new Biome(inputData[1], Nature.valueOf(inputData[3].toUpperCase()));
											world.getBiome()[currentBiomeX][currentBiomeY] = biome;
											// corrects the index of biome[][y] and village[] array
											currentBiomeY++;
											currentVillage = 0;
											break;
					case Keywords.VILLAGE:	// check amount of farmers and doctors
											if (checkProfession()) {
												// creates new village, builds houses and set mayor
												Village village = new Village(inputData[1]);
												world.getBiome()[currentBiomeX][currentBiomeY - 1].getVillage()[currentVillage] = village;
												world.getBiome()[currentBiomeX][currentBiomeY - 1].getVillage()[currentVillage].buildHouse(Integer.valueOf(inputData[3]), villagePopulation[villageNum]);
												world.getBiome()[currentBiomeX][currentBiomeY - 1].getVillage()[currentVillage].setMayor(inputData[5]);
												//// corrects the index of village[],villagePopulation[] and villager[] array
												currentVillage++;
												currentVillager = 0;
											}
											villageNum++;
											break;
					case Keywords.VILLAGER:	// compares input-string to enum Gender
											if (!Gender.containsGenderElement(inputData[3]) || !Profession.containsProfessionElement(inputData[7])  )
												continue;
											// creates new villager, saves it in and corrects the index of villager[] array
											Villager villager = new Villager(inputData[1], Gender.valueOf(inputData[3].toUpperCase()), Integer.valueOf(inputData[5]), Profession.valueOf(inputData[7].toUpperCase()));
											world.getBiome()[currentBiomeX][(currentBiomeY % 5) - 1].getVillage()[currentVillage - 1].getVillager()[currentVillager] = villager;
											currentVillager++;
											break;
				}
			} 
			sc.close();
		} catch (Exception e) {
			// Troubleshooting
			System.out.println("Something went wrong. File does not exist!");
		}
		return world;
	}
	
	/**
	 * Write World-object from file(format: .txt). 
	 * @param world  World-object
	 */
	
	public void  writeWorldToFile(World world) {
		try { 
			FileWriter datei = new FileWriter("output_file/ue3/weltMitBerufen.txt");
			BufferedWriter writer = new BufferedWriter(datei);
			
			writer.write(world.toString());
			writer.newLine();
			
			// loop for first index [x][] of biome[][] array 
			for (int i = 0; i < World.getMaxNumBiomes(); i++) {
				
				// loop for second index [][y] of biome[][] array
				for(int j = 0; j < World.getMaxNumBiomes() ; j++) {
					if (world.getBiome()[i][j] == null)
						break;
				
					writer.write(world.getBiome()[i][j].toString());
					writer.newLine();
					
					// loop for village[] array
					for(int k = 0; k < world.getBiome()[i][j].getVillage().length; k++ ) {
						if (world.getBiome()[i][j].getVillage()[k] == null)
							break;
						
						writer.write(world.getBiome()[i][j].getVillage()[k].toString());
						writer.newLine();
					
						// loop for villager [] array
						for(Villager villager : world.getBiome()[i][j].getVillage()[k].getVillager()){
							if (villager == null)
								break;
							
							writer.write(villager.toString());
							writer.newLine();
						}
					}
				}
			}
		writer.close(); 
		} catch (Exception e){
			// Troubleshooting
			System.out.println("Something went wrong. File does not exist!");	
		}	
	}
	
	/**
	 * Converts string in lower case with exception of first letter.   
	 * @param string String
	 * @return String in lower case with exception of first letter
	 */
	
	static public String convert_upper(String string) {
	    String firstLetter, rest;
	    firstLetter = string.substring(0,1).toUpperCase();
	    rest = string.substring(1).toLowerCase();
	    return (firstLetter+rest);
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