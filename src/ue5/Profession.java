package ue5;

/**
* This enum contains different kind of professions (e.g. "Priest", "Dcotor"...).
*
* @author Michael Kinzkofer
*
*/

public enum Profession {
	PRIEST,
	DOCTOR,
	FARMER,
	PROFESSOR,
	UNEMPLOYED,
	KID,
	STUDENT,
	CONSULTANT,
	ENGINEER,
	MANAGER,
	ARTIST;

	/**
	 * Check string to see whether the string is contained in enumeration Profession or not.
	 * @param input String to be compared
	 * @return boolean
	 */

	public static boolean isEqualToProfessionElement(String input)
	  {
	    for(Profession profession : Profession.values()) {
	      if(profession.toString().toLowerCase().equals(input.toLowerCase())) {
	        return true;
	      }
	    }
	 // Troubleshooting
	    System.out.println("error: '" + input + "' is an unknown profession!"
	    		+ "\nfailed to initialize villager...");
	    return false;
	  }


}
