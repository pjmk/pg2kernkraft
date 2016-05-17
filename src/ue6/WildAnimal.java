package ue6;

 /**
  * The class WildAnimal provides attributes for its subclasses.
  * It inherits from the class Animal.
  * 
  * @author Michael Kinzkofer, Paul Jureschek
  *
  */

public abstract class WildAnimal extends Animal {
	private String id;
	private Nature preferredNature;
	private Biome currBiome;

	
	/**
	 * Generates WildAnimal object.
	 * Used by subclasses.
	 */
	protected WildAnimal() {
	}
	
	/**
	 * Generates WildAnimal Object.
	 * 
	 * @param color color of WildAnimal 
	 * @param age age of WildAnimal
	 * @param id ID of WildAnimal
	 * @param pref preferred natural environment of WildAnimal 
	 * @param curr Biome where the WildAnimal is living
	 */
	public WildAnimal(Color color, int age, String id, Nature pref, Biome curr) {
		super(color, age);
		
		this.id = id;
		preferredNature = pref;
		currBiome = curr;
		
	}

	/**
	 * Sets the id of WildAnimal.
	 * @param id the id for WildAnimal
	 */
	protected void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets preferred natural environment of WildAnimal.
	 * @param preferredNature the preferred natural environment of WildAnimal
	 */
	protected void setPreferredNature(Nature preferredNature) {
		this.preferredNature = preferredNature;
	}

	/**
	 * Set current biome.
	 * @param curr the Biome where the WildAnimal should be living at the moment 
	 */
	protected void setCurrBiome(Biome curr) {
		currBiome = curr;
	}

	/**
	 * Returns ID of WildAnimal.
	 * @return id of WildAnimal
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns preferred natural environment of WildAnimal.
	 * @return preferred natural environment of WildAnimal
	 */
	public Nature getPreferedNature() {
		return preferredNature;
	}

	/**
	 * Returns Biome where the WildAnimal is living at the moment.
	 * @return Biome where the WildAnimal is living at the moment
	 */
	public Biome getCurrBiome() {
		return currBiome;
	}
}
