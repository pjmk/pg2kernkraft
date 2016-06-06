package ue9;

/**
 * 
 * This class generates a chicken.
 * It inherits from class Pet. 
 * 
 * @author Paul Jureschek, Michael Kinzkofer
 *
 */

public class Camel extends WildAnimal {
	
	/**
	 * Generates Camel object.
	 * @param color color of Camel
	 * @param age age of Camel
	 * @param id ID of Camel
	 * @param currBiome Biome the Camel is living on at the moment
	 * @param pref preferred natural environment of Camel
	 */
	public Camel(Color color, int age, String id, Biome currBiome, Nature pref) {
		super(color, age, id, pref, currBiome);
	}
	
	
	/**
	 * Generates Camel object.
	 * @param row String that contains all necessary information
	 * @param world World object
	 */
	public Camel(String row, World world) {
		//splits each word in inputData[] array
		String[] inputData = row.split(";|\\:");
		for (int i = 0; i < inputData.length; i += 2) {
			switch(inputData[i]) {
				case Keywords.CAMEL:		this.setId(inputData[i + 1]);
											break;
				case Keywords.FAVNATURE:	this.setPreferredNature(Nature.valueOf(inputData[i + 1].toUpperCase()));
											break;
				case Keywords.COLOR:		this.setColor(Color.valueOf(inputData[i + 1].toUpperCase()));			
											break;
				case Keywords.ANIMALAGE:	this.setAge(Integer.parseInt(inputData[i + 1]));
											break;
				case Keywords.CURRBIOME: 	this.setCurrBiome(world.getBiomeByName(inputData[i + 1]));
											break;
				default:					System.out.println("No fitting keyword found for: " + inputData[i] + " for animal " + this.getId());
			}
		}
		// Add Camel to Biom:
		super.getCurrBiome().addWildAnimal(this);
	}
	
	/**
	 * Makes camel drink water.
	 */
	@Override
	public void performAction() {
		System.out.println("Camel " + super.getId() + " is drinking a lot of water");
	}
	
	@Override
	public String toString() {
		return "CAMEL:" + this.getId() + ";COLOR:" + this.getColor().toString().toLowerCase()
		+ ";ANIMALAGE:" + this.getAge() + ";FAVNATURE:" + WorldUtilities.convertUpper(this.getPreferedNature().toString())
		+ ";CURRBIOME:" + this.getCurrBiome().getName();
	}

	/**
	 * Log the Camel coordinates to the console
	 */
	@Override
	public void logCoordinates() {
		System.out.println("CAMEL:" +  "X-COORDINATE:" + getXCoordinate() + ";Y-COORDINATE:" + getYCoordinate());	
	}
	




}
