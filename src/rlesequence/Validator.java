package rlesequence;

/**
 * <strong>@author Caleb Kinmon (UNI: cgk2128)</strong>
 * <br><br>
 * An instance of this class is used by the sequence class to
 * validate the indexes and elements that are used to
 * create and modify a sequence. 
 * <br><br>
 * This class checks to make sure that an index is valid
 * when trying to access a position in a sequence.  This class
 * also checks to make sure that elements added to a sequence
 * are within the range of 0 and 255. Lastly, this class validates
 * the elements in an array of integers before that array is 
 * converted into a sequence.
 * <br><br>
 * This class also uses the Talker class to display error messages. 
 */
public class Validator {

	/**
	 * Validates that an index is within the bounds of a particular 
	 * sequence.  
	 * @param index represents the desired index. 
	 * @param sequenceLength represents the length of the sequence.
	 * @return true if the index is within bounds, false otherwise.
	 */
	public boolean isValidIndex(int index, int sequenceLength){
		boolean validIndex = true;
		if (index < 0 || index > sequenceLength){
			validIndex = false;
			talker.displayIndexError();
		}
		return validIndex; 
	}
	
	/**
	 * Checks that an element in a sequence is within the bounds of
	 * 0 and 255.
	 * @param element represents the element in the sequence.
	 * @return true if element is within bounds, false otherwise.
	 */
	public boolean isValidElement(int element){
		boolean validElement = true;
		if (element < 0 || element > 255){
			validElement = false;
			talker.displayElementError();
		}
		return validElement;
	}
	
	/**
	 * Checks the validity of the elements in the sequence.
	 * @param sequence of integer array.
	 * @return true if sequence elements are valid, and false if invalid.
	 */
	public boolean isValidArray(int[] sequence){
		boolean validSequence = true;
		for (int element : sequence){
			if (!isValidElement(element)){
				validSequence = false;
				talker.displayElementError();
			}
		}
		return validSequence;
	}
	
	private Talker talker = new Talker();
}
