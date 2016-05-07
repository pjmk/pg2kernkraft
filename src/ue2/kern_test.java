package ue2;

public class kern_test {

	public static void main(String[] args) {

	WorldUtilities worldutilities = new WorldUtilities();
	worldutilities.writeWorldToFile(worldutilities.readWorldFromFile());	
	
	}
}

	
