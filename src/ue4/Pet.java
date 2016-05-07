package ue4;

/**
 * The class pet provides attributes for its subclasses
 * It inherits from Animal
 * 
 * @author Michael Kinzkofer, Paul Jureschek
 *
 */

public abstract class Pet extends Animal {
	private String name;
	private Villager owner;
	
	
	/**
	 * Generates Pet object.
	 * Used by subclasses.
	 */
	protected Pet() {
	}
	
	
	/**
	 * Constructor for Pets.
	 * Checks if owner is farmer, but after calling super-constructor.
	 * If owner is not farmer, it will break.
	 * 
	 * @param color color of pet
	 * @param age age of pet
	 * @param name name of pet
	 * @param owner owner of pet
	 */
	public Pet(Color color, int age, String name, Villager owner) {
		super(color, age);
		
		// Only farmers may have cows and chicken
		// So break if not a farmer
		// Don't know howto check before calling super constructor
		
		if (owner.getProfession() != Profession.FARMER) {
			System.out.println("Only Farmers may own cows and chicken");
			return;
		}
		this.name = name;
		this.owner = owner;	
	}
	
	/**
	 * Return name of Pet.
	 * @return name of Pet
	 */
	public String getName() {
		return name;
	}

	/**
	 * Return owner of Pet.
	 * @return owner of Pet
	 */
	public Villager getOwner() {
		return owner;
	}


	/**
	 * Sets the name of pet.
	 * @param name the name of pet
	 */
	protected void setName(String name) {
		this.name = name;
	}


	/**
	 * Sets owner of pet.
	 * @param owner the owner of pet
	 */
	protected void setOwner(Villager owner) {
		this.owner = owner;
	}
}