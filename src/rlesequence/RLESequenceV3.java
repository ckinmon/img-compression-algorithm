package rlesequence;

import java.util.ArrayList;

/**
 * 
 * @author Caleb Kinmon (UNI: cgk2128)
 * <br><br>
 * An instance of this class is used to create a sequence of
 * numbers that represents a single line of pixels of an image.  
 * The integers range from 0 (pure black) to 255 (pure white). 
 * <br><br>
 * The default length of a sequence is 10 and the default value
 * is 255, to represent an all white background.
 * <br><br>
 * The methods presented allow a sequence and its values to be
 * created, modified, retrieved, printed, and prepended and appended.
 * <br><br>
 * This class differs from RLESequenceV1 and RLESequenceV2 insofar that AFTER it 
 * uses the class RLEConverter to compress the internal representation of the sequence,
 * it never converts back to an uncompressed form. The methods operate on the 
 * compressed sequence.
 * <br><br>  
 */
public class RLESequenceV3 {
	
	/**
	 * <strong>Default Constructor</strong>: <br><br>
	 * Creates a new sequence with a default length of 10
	 * and default values of 255.
	 */
	RLESequenceV3(){
		length = 10;
		this.createSequence(length);
		this.initializeSequence(length);
		converter.toSpace(sequence);
		sequence = converter.getCompressedSequence();
	}

	/**
	 * <strong>Constructor</strong>: <br><br>
	 * Creates a new sequence that has a specified length.
	 * An exception is thrown if the length is below 0.
	 * @param length of type integer.
	 */
	RLESequenceV3(int length){
		if(length > 0){
			this.createSequence(length);
			this.initializeSequence(length);
		}
		else{
			talker.displayLengthError();
			this.createSequence(10);
			this.initializeSequence(10);
		}
		converter.toSpace(sequence);
		sequence = converter.getCompressedSequence();
	}
	
	/**
	 * <strong>Constructor</strong>: <br><br>
	 * Creates a new sequence from an array of integers.
	 * An exception is thrown if the array contains values
	 * outside of the bounds of zero and 255.
	 * @param entireSequence array of type integer.
	 */
	RLESequenceV3(int[] entireSequence){
		length = entireSequence.length;
		
		if(valid.isValidArray(entireSequence)){
			this.createSequence(length);
			for (int i = 0; i < length; i++){
				sequence.add(i, entireSequence[i]);
			}
			converter.toSpace(sequence);
			sequence = converter.getCompressedSequence();
		}
		else{
			talker.displayUpdateError();
		}
	}
	
	/**
	 * Creates a new sequence that can hold integer values.
	 * @param length of type integer that represents the length of the
	 * sequence to be created. 
	 */
	private void createSequence(int length){
		sequence = new ArrayList<Integer>(length);
	}
	
	/**
	 * Initializes an empty sequence to the values of 255, since all
	 * text backgrounds or empty canvases are white. 
	 * @param length of type integer.
	 */
	private void initializeSequence(int length){
		for (int i = 0; i < length; i++){
			sequence.add(i, 255);
		}
	}
	
	/**
	 * Retrieves the number of elements (size) in the sequence. 
	 * @return an integer.
	 */
	public int getSize(){	
		int size = sequence.size();	
		return size;
	}
	
	/**
	 * Insert a new value at the specified index.
	 * An exception is thrown if the index is OOB.
	 * @param index of type integer.
	 * @param element of type integer.
	 */
	public void insertAt(int index, int element){
		if(valid.isValidElement(element) && valid.isValidIndex(index, sequence.size() + 1)){
			sequence.add(index, element);
		}
		else{
			talker.displayUpdateError();
		}
	}
	
	/**
	 * Modify the value at the specified index.
	 * An exception is thrown if the index is OOB.
	 * @param index of type integer.
	 * @param element of type integer.
	 */
	public void modifyAt(int index, int element){
		if(valid.isValidElement(element) && valid.isValidIndex(index, sequence.size())){
			sequence.set(index, element);
		}
		else{
			talker.displayUpdateError();
		}
	}
	
	/**
	 * Returns the value at the specified index. If the method tries to
	 * access an invalid index, an error message is displayed and the
	 * method returns the first index. 
	 * @param index of type integer.
	 * @return an integer.
	 */
	public int retrieveAt(int index){
		try{
			content = sequence.get(index);
		}
		catch(IndexOutOfBoundsException e){
				talker.displayUpdateError();
				content = sequence.get(0);
		}
		return content;
	}
	
	/**
	 * Compares two sequences to check if their elements are equivalent.
	 * @param testSequence of object type RLESequenceV1. 
	 * @return true if they are equal and false if they are not.
	 */
	public boolean compareTo(RLESequenceV3 testSequence){
		boolean matchingSequence = true;
		if (testSequence.getSize() == this.getSize()){
			for (int i = 0; i < this.getSize(); i++){
				if(!sequence.get(i).equals(testSequence.retrieveAt(i))){
					matchingSequence = false;
				}
			}
		}
		else{
			matchingSequence = false;
		}
		return matchingSequence;
	}
	
	/**
	 * Displays a sequence as a String with surrounding brackets
	 * and separated by a white space.
	 */
	public void printSequence(){
		String string = sequence.toString().replace(",", " ");
		System.out.println(string);
	}	
	
	/**
	 * Prepends values to the beginning of a RLEsequence. 
	 * @param element of type integer.
	 */
	public void addToHead(int element){
		if(valid.isValidElement(element)){
			sequence.add(0, element);
		}
		else{
			talker.displayUpdateError();
		}
	}
	
	/**
	 * Appends values to the end of a RLESequence.
	 * @param element of type integer.
	 */
	public void addToTail(int element){
		if(valid.isValidElement(element)){
			sequence.add(element);
		}
		else{
			talker.displayUpdateError();
		}
	}
	
	/**
	 * Inserts the elements of a sequence in an existing sequence, starting
	 * at a specified index. 
	 * @param index of type integer. Marks the starting point of insertion.
	 * @param newSequence of type RLESequenceV3, represents sequence to insert.
	 */
	public void tailReplace(int index, RLESequenceV3 newSequence){
		if(valid.isValidIndex(index, sequence.size())){
			for(int i = 0; i < newSequence.getSize(); i++){
				this.insertAt(index + i, newSequence.retrieveAt(i));
			}
		}
		else{
			talker.displayUpdateError();
		}
	}
	
	private RLEConverter converter = new RLEConverter();
	
	// an instance that calls methods for checking for and preventing errors
	private Validator valid = new Validator();
	private int length;
	private int content;
	
	/* 
	 * This is the data structure to represent the sequence. An ArrayList can
	 * easily grow (and shrink, if necessary) as more values are added, and it
	 * is easy to access its indexes as needed.  
	 */
	private ArrayList<Integer> sequence;
	
	// an instance of this communicates errors to the user
	private Talker talker = new Talker();
}
