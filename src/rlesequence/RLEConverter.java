package rlesequence;

import java.util.ArrayList;

/**
 * 
 * <strong>@author Caleb Kinmon (UNI: cgk2128)</strong>
 * <br><br>
 * An instance of this class converts the data from RLESequenceV2 to a compressed
 * form. If a sequence contains the same integer consecutive times, then the integer
 * is placed in one list, and the number of times it appears is placed in another. 
 * <br><br>
 * I chose two ArrayLists to represent the data. It's compatible with the data structure
 * used in RLESequence and they can easily grow or shrink depending on the modifications 
 * the user makes on the sequence in RLESequence.  
 */
public class RLEConverter {
	
	/**
	 * No default size was chosen for each list. It doesn't seem necessary because we don't
	 * have any way of knowing what size a sequence to compress might be.
	 */
	RLEConverter(){
		createCompressionList();
		createCompanionList();
	}
	
	/**
	 * Creates a sequence that will contain the compressed values. <br>
	 */
	private void createCompressionList(){
		compressedSequence = new ArrayList<Integer>();
	}
	
	/**
	 * Creates a companion list for the compressed sequence that holds
	 * the count for each repeated value. <br>
	 */
	private void createCompanionList(){
		companionList = new ArrayList<Integer>();
	}
	
	/**
	 * This method uncompresses the RLESequenceV2 sequence. The run time is
	 * not O(n) compared to the compressed method below, but it's the best
	 * way I could solve uncompressing the sequence. 
	 */
	public void toAPI(){
		
		// I have to clear this list or otherwise new values begin to
		// stack on old values, and I run out of heap space.
		uncompressedSequence.clear();
		
		int element;
		for (int i = 0; i < companionList.size(); i++){
			for (int a = 0; a < companionList.get(i); a++){
				element = compressedSequence.get(i);
				uncompressedSequence.add(element);
			}
		}
	}
	
	/**
	 * Returns an uncompressed sequence.
	 * @return an ArrayList object that represents an uncompressed sequence.
	 */
	public ArrayList<Integer> getUncompressedSequence(){
		return(uncompressedSequence);
	}
	
	/**
	 * Return a compressed sequence.
	 * @return an ArrayList object that represents a compressed sequence.
	 */
	public ArrayList<Integer> getCompressedSequence(){
		return(compressedSequence);
	}
	
	/**
	 * Compresses a sequence from RLESequenceV2. I chose this form
	 * because it can compress a huge sequence in O(n) by making one
	 * pass and using a companion list to track the running count of
	 * repeating values for each unique integer in the compressed list.
	 * <br><br>
	 * @param RLESequence of the RLESequenceV2 form.
	 */
	public void toSpace(ArrayList<Integer> RLESequence){
		
		/* 
		 * If I don't clear first then new compressions will stack on top of
		 * the values from old compressions. This helps me avoid an error of
		 * running out of heap space. 
		 */
		companionList.clear();
		compressedSequence.clear();
		
		int currentElementCount = 1;
		int currentElementPosition = 0;
		companionList.add(currentElementCount);
		compressedSequence.add(RLESequence.get(0));
		for(int i = 0; i < RLESequence.size() - 1; i++){
			if(RLESequence.get(i).equals(RLESequence.get(i + 1))){
				currentElementCount++;
				companionList.set(currentElementPosition, currentElementCount);
			}
			else{
				currentElementCount = 1;
				companionList.add(currentElementCount);
				compressedSequence.add(RLESequence.get(i + 1));
				currentElementPosition++;
			}
		}
	}
	
	/**
	 * Displays the compressed seqeunce's companion list.
	 * This is a public method used for testing.
	 */
	public void printCompanionList(){
		String string = companionList.toString();
		System.out.println(string);
	}
	
	// The ArrayLists companionList and compressedSequence are used side by 
	// side in conversions
	private ArrayList<Integer> companionList;
	private ArrayList<Integer> compressedSequence;
	
	private ArrayList<Integer> uncompressedSequence = new ArrayList<Integer>();

}
