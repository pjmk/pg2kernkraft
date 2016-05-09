package ue5;

/**
 * The abstract class Animal provides basic features for an animal.
 * 
 * @author Michael Kinzkofer, Paul Jureschek
 *
 */
public abstract class Animal {
	private Color color;
	private int age;
	private int maxWeight;
	
	/**
	 * Generates Animal object.
	 * Is used by subclasses.
	 */
	protected Animal() {	
	}
	
	/**
	 * Constructs Animal Object.
	 * Animals cannot be less than 0 years old.
	 * 
	 * @param color color of Animal
	 * @param age age of Animal
	 */
	public Animal(Color color, int age) {
		this.color = color;
		if (age >= 0) {
			this.age = age;
		} else {
			System.out.println("Animal age must not be less than 0");
		}
	}
	
	/**
	 * Sets color of animal.
	 * @param color color of animal
	 */
	protected void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Sets age of animal.
	 * @param age age of animal
	 */
	protected void setAge(int age) {
		this.age = age;
	}

	/**
	 * Abstract method. Implemented in Subclasses.
	 * Used to perform the typical animal action.
	 */
	
	abstract public void performAction();

	/**
	 * Returns color of animal as enum.
	 * @return Color color of animal
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Return age of animal.
	 * @return age of animal
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Get the max weight of the animal.
	 * @return max weight of the animal
	 */
	
	public int getMaxWeight() {
		return maxWeight;
	}

	/**
	 * Set the max weight of the animal.
	 * @param maxWeight max weight of the animal
	 */
	
	protected void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	} 
}
