package ue3;

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
	 * @param eingabe String
	 * @return boolean
	 */
	
	public static boolean containsNatureElement(String eingabe)
	  {
	    for(Nature nature : Nature.values()) {
	      if(nature.toString().toLowerCase().contains(eingabe.toLowerCase())) {
	        return true;
	      }
	    }
	 // Troubleshooting
	    System.out.println("error: '" + eingabe + "' is an unknown kind of nature!"
	    		+ "\nfailed to initialize biome...");
	    return false;
	  }
	
}
