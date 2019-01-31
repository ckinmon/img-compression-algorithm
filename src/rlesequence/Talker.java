package rlesequence;

/**
 * 
 * <strong>@author Caleb Kinmon (UNI: cgk2128)</strong>
 * <br><br>
 * An instance of this class is used to display error messages
 * when an index of a sequence is out of bounds, a sequence element is not within
 * the range 0 and 255, or when a new sequence has an invalid length.
 * <br><br>
 * The RLESequence and Validator classes use this class.
 */
public class Talker {
	
	/**
	 * Displays that the sequence did not update. 
	 */
	public void displayUpdateError(){
		System.out.println("Sequence did not update.");
	}
	
	/**
	 * Displays that the new sequence was given an invalid length.
	 */
	public void displayLengthError(){
		System.out.println("Invalid length. Must be greater than zero. Length "
				+ "default is 10.");
	}
	
	/**
	 * Displays that an element is out of bounds.
	 */
	public void displayElementError(){
		System.out.println("Invalid element. Must be an integer between 0 and 255.");
	}
	
	/**
	 * Displays that an index is out of bounds.
	 */
	public void displayIndexError(){
		System.out.println("Invalid index. Must be an integer greater than 0 and "
				+ "less than the length of the sequence.");
	}

}
