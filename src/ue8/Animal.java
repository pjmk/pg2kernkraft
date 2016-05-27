package ue8;

/**
 * The abstract class Animal provides basic features for an animal.
 * 
 * @author Michael Kinzkofer, Paul Jureschek
 *
 */
public abstract class Animal implements IMovable{
	private Color color;
	private int age;
	private int xCoordinate;
	private int yCoordinate;
	
	/**
	 * Generates Animal object.
	 * Is used by subclasses.
	 */
	protected Animal() {
	//  Generates random coordinates
			setCoordinates();
	}
	
	/**
	 * Constructs Animal Object.
	 * Animals cannot be less than 0 years old.
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
	 *  set the coordinates of the Animal.
	 *  @param xCoordinate x-coordinate of the villager in the biome
	 *  @param yCoordinate y-coordinate of the villager in the biome
	 */
	
	public void setCoordinates(int xCoordinate, int yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

	/**
	 * Generates random coordinates and log the coordinates
	 *  of the Animal to the console
	 */
	
	public void setCoordinates() {
		this.xCoordinate = (int) (100 * Math.random());
		this.yCoordinate = (int) (100 * Math.random());
		//logCoordinates();
	}

	/**
	 * Returns x-coordinate of the Animal.
	 * @return x-coordinate of the Animal
	 */
	
	public int getXCoordinate() {
		return xCoordinate;
	}
	
	/**
	 * Returns y-coordinate of the Animal.
	 * @return y-coordinate of the Animal
	 */
	
	public int getYCoordinate() {
		return yCoordinate;
	}
	
}
