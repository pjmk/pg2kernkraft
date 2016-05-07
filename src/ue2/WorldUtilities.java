package ue2;
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
	private static final int NUM_VILLAGES_OVERALL = Biome.getMaxNumVillages() * World.getMaxNumBiomes();
	private int currentBiome;
	private int currentVillage;
	private int currentVillager;
	private int amountVillages;
	private World world = null;
	private int villagePopulation[] = new int[NUM_VILLAGES_OVERALL];
	
	/**
	 * Generates new object by counting villagers from file(format: .txt)
	 */
	
	public WorldUtilities(){
		int villageNum = 0;
		try {
			File datei = new File("input_file/ue2/welt.txt");
			Scanner sc = new Scanner(datei);
			
			while( sc.hasNextLine() ) {
				// reads a single row and splits each word in inputData[] array
				String zeile = sc.nextLine(); 
				String[] inputData = zeile.split(";|\\:");
				
				// counts villagers
				switch(inputData[0]) {
					case "WORLD":	break;
					case "BIOME": 	break;
					case "VILLAGE": villageNum++;
									break;
					case "VILLAGER":this.villagePopulation[villageNum - 1]++;
									break;
				}
			} 
			sc.close();
		} catch (Exception e) {
			// Troubleshooting
			System.out.println("Something went wrong. File does not exist!");
		}
	}
	
	/**
	 * Read World-object from file(format: .txt). 
	 * @return  World-object
	 */
	
	public World readWorldFromFile() {
		try {
			File datei = new File("input_file/ue2/welt.txt");
			Scanner sc = new Scanner(datei);
			
			while( sc.hasNextLine() ) {
				// reads a single row and splits each word in inputData[] array
				String zeile = sc.nextLine(); 
				String[] inputData = zeile.split(";|\\:");
				
				switch(inputData[0]) {
					case "WORLD":	// creates name of new world
									world = new World(inputData[1]);				
									break;
					case "BIOME":	// creates new biome
									Biome biome = new Biome(inputData[1], inputData[3]);
									world.getBiome()[currentBiome] = biome;
									// corrects index of biome[] and village[] array
									currentBiome++;
									currentVillage = 0;
									break;
					case "VILLAGE":	// creates new village, builds houses and set mayor
									Village village = new Village(inputData[1]);
									world.getBiome()[currentBiome - 1].getVillage()[currentVillage] = village;
									world.getBiome()[currentBiome - 1].getVillage()[currentVillage].buildHouse(Integer.valueOf(inputData[3]),villagePopulation[amountVillages]);
									world.getBiome()[currentBiome - 1].getVillage()[currentVillage].setMayor(inputData[5]);
									// corrects the index of village[],villagePopulation[] and villager[] array
									currentVillage++;
									amountVillages++;
									currentVillager = 0;
									break;
					case "VILLAGER":// creates new villager, saves it in and corrects the index of villager[] array
									Villager villager = new Villager(inputData[1], Gender.valueOf(inputData[3]), Integer.valueOf(inputData[5]));
									world.getBiome()[currentBiome - 1].getVillage()[currentVillage - 1].getVillager()[currentVillager] = villager;
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
			FileWriter datei = new FileWriter("output_file/ue2/welt.txt");
			BufferedWriter writer = new BufferedWriter(datei);
			
			writer.write(world.toString());
			writer.newLine();
			
			// loop for biome[] array
			for(int i = 0; i < world.getBiome().length; i++) {
				if (world.getBiome()[i] == null)
					break;
			
				writer.write(world.getBiome()[i].toString());
				writer.newLine();
				
				// loop for village[] array
				for(int j = 0; j < world.getBiome()[j].getVillage().length; j++ ) {
					if (world.getBiome()[i].getVillage()[j] == null)
						break;
					
					writer.write(world.getBiome()[i].getVillage()[j].toString());
					writer.newLine();
				
					// loop for villager [] array
					for(Villager villager : world.getBiome()[i].getVillage()[j].getVillager()){
						if (villager == null)
							break;
						
						writer.write(villager.toString());
						writer.newLine();
					}
				}
			}
		writer.close(); 
		} catch (Exception e){
			// Troubleshooting
			System.out.println("Something went wrong. File does not exist!");	
		}	
	}
	
}

