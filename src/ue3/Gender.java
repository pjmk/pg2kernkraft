package ue3;

/**
 * This enum contains different types of genders.
 * 
 * @author Paul Jureschek, Michael Kinzkofer
 * 
 */


public enum Gender {
	   MALE,
	   FEMALE;
	
	/**
	 * Check string to see whether the string is contained in enumeration Gender or not.
	 * @param eingabe String
	 * @return boolean
	 */
	
	public static boolean containsGenderElement(String eingabe)
	  {
	    for(Gender gender : Gender.values()) {
	      if(gender.toString().toLowerCase().contains(eingabe.toLowerCase())) {
	        return true;
	      }
	    }
	    // Troubleshooting
	    System.out.println("error: '" + eingabe + "' is an unknown Gender!"
	    		+ "\nfailed to initialize villager...");
	    return false;
	  }
	
}