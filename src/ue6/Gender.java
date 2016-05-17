package ue6;

/**
 * This enum contains different types of genders.
 *
 * @author Michael Kinzkofer
 *
 */

public enum Gender {
	   MALE,
	   FEMALE;

	/**
	 * Check string to see whether the string is contained in enumeration Gender or not.
	 * @param input String to be compared
	 * @return boolean
	 */

	public static boolean isEqualToGenderElement(String input)
	  {
	    for(Gender gender : Gender.values()) {
	      if(gender.toString().toLowerCase().equals(input.toLowerCase())) {
	        return true;
	      }
	    }
	    // Troubleshooting
	    System.out.println("error: '" + input + "' is an unknown Gender!"
	    		+ "\nfailed to initialize villager...");
	    return false;
	  }

}