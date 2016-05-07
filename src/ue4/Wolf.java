package ue4;

/**
 * The class Wolf provides wolves.
 * It extends WildAnimal.
 * 
 * Wolf will be raging nonstop after hunting chicken.
 * 
 * @author Michael Kinzkofer, Paul Jureschek
 *
 */

public class Wolf extends WildAnimal {
	private boolean isRaging = false;
	
	/**
	 * Generates Wolf object. Input must be a special string containing all information.
	 * Needed to load World from file.
	 * @param row String that contains all necessary information.
	 * @param world World object 
	 */
	public Wolf(String row, World world) {
		//splits each word in inputData[] array
		String[] inputData = row.split(";|\\:");
		for (int i = 0; i < inputData.length; i += 2) {
			switch(inputData[i]) {
				case Keywords.WOLF:			this.setId(inputData[i + 1]);
											break;
				case Keywords.RAGEMODE:		isRaging = Boolean.valueOf(inputData[i + 1]);			
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
		// Add Wolf to Biom:
		super.getCurrBiome().addWildAnimal(this);
	}
	
	/**
	 * Generates Wolf object.
	 * 
	 * @param color color of Wolf
	 * @param age age of Wolf
	 * @param id ID of Wolf	 
	 * @param currBiome Biome the wolf is living on
	 * @param pref preferred natural environment of wolf
	 * @param isRaging whether wolf is in ragemode or not
	 */
	public Wolf(Color color, int age, String id, Biome currBiome, Nature pref, boolean isRaging) {
		super(color, age, id, pref, currBiome);
		
		this.isRaging = isRaging;
	}

	/**
	 * Return whether Wolf is raging or not.
	 * @return boolean value whether Wolf is raging or not
	 */
	
	public boolean isRaging() {
		return isRaging;
	}

	/**
	 * Prints what wolf is doing (hunting chicken)
	 * And sets isRaging to true.
	 */
	@Override
	public void performAction() {
		System.out.println(super.getId() + " is hunting chicken");
		isRaging = true;	
	}
	
	@Override
	public String toString() {
		return "WOLF:" + this.getId() + ";COLOR:" + this.getColor().toString().toLowerCase()
		+ ";ANIMALAGE:" + this.getAge() + ";FAVNATURE:" + WorldUtilities.convertUpper(this.getPreferedNature().toString())
		+ ";CURRBIOME:" + this.getCurrBiome().getName() + ";RAGEMODE:" 
		+ Boolean.toString(isRaging); 
	}
}
