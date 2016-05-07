package ue4;

/**
* This enum contains different kind of biomes (e.g. "Desert", "Jungle"...).
* 
* @author Paul Jureschek, Michael Kinzkofer
* 
*/

public enum Nature {
	MEADOWS, 
	JUNGLE, 
	DESERT, 
	ARCTIC, 
	MOUNTAINS,
	VULCANO,
	FOREST,
	SWAMPLAND,
	BEACH,
	OCEAN,
	ISLAND;
	
	/**
	 * Check string to see whether the string is contained in enumeration Nature or not.
	 * @param input String to be compared
	 * @return boolean
	 */
	
	public static boolean isEqualToNatureElement(String input)
	  {
	    for(Nature nature : Nature.values()) {
	      if(nature.toString().toLowerCase().equals(input.toLowerCase())) {
	        return true;
	      }
	    }
	 // Troubleshooting
	    System.out.println("error: '" + input + "' is an unknown kind of nature!"
	    		+ "\nfailed to initialize biome...");
	    return false;
	  }
	
}
