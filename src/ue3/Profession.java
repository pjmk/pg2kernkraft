package ue3;

/**
* This enum contains different kind of professions (e.g. "Priest", "Dcotor"...).
* 
* @author Paul Jureschek, Michael Kinzkofer
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
	 * @param eingabe String
	 * @return boolean
	 */
	
	public static boolean containsProfessionElement(String eingabe)
	  {
	    for(Profession profession : Profession.values()) {
	      if(profession.toString().toLowerCase().contains(eingabe.toLowerCase())) {
	        return true;
	      }
	    }
	 // Troubleshooting
	    System.out.println("error: '" + eingabe + "' is an unknown profession!"
	    		+ "\nfailed to initialize villager...");
	    return false;
	  }
	
	
}
