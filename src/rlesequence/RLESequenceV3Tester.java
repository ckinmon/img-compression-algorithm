package rlesequence;

import java.util.ArrayList;

/**
 * 
 * <strong>@author Caleb Kinmon (UNI: cgk2128)</strong>
 * <br><br>
 * An instance of this class can be used to call the methods of
 * the RLESequenceV3 class, to test each public method and the
 * three constructors. Results of the tests are included here. Full output
 * of each test can be found in the attached .txt documents.
 * <br><br>
 * This class contains more than seven methods because it tests the seven methods from
 * the RLESequenceV3 class, and also tests its three constructors. It seemed inappropriate
 * to create a second tester class to stay within the rule of less than 7 methods per class.
 * <br><br>
 * <em>I added one more test that checks to make sure the tailReplace method for Step Four
 * is working properly</em>. 
 * <br><br>
 * NOTE: THIS CLASS COPIES THE SAME METHODS THAT ARE PRESENT IN THE RLESEQUENCEV1 CLASS.
 * BUT BECAUSE THIS CLASS COMPRESSES A SEQUENCE BEFORE IT OPERATES ON IT, 
 * THE EXPECTED AND ACTUAL TEST RESULTS SHOULD BE THE DIFFERENT FROM RLESequenceV1Tester and RLESequenceV2Tester. 
 * WHILE I PERFORMED THE SAME TESTS, THE RESULTS ARE DIFFERENT. 
 * <br><br>
 * <strong>Test Results:</strong>
 * <br><br>
 * Test One: Calling the default constructor, and displaying the default elements.
 * The constructors also test the private helper methods that create and initialize 
 * a sequence. Each constructor test checks the printSequence method.
 * This constructor should generate 10 default elements of 255. But it should
 * compress the sequence to just one value of 255.<br>
 * Expected Result: [255]<br>
 * Actual Result: [255]
 * <br><br>
 * Test Two: Calling the constructor with parameter of length, and displaying the 
 * default elements. The length that is passed is 20.<br>
 * Expected Result: [255]<br>
 * Actual Result: [255] 
 * <br><br>
 * Test Three: Calling the constructor that accepts an array of integers.<br>
 * Expected Result: [1 2 3 4 5]<br>
 * Actual Result: [1  2  3  4  5]
 * <br><br>
 * Test Four: Testing the InsertAt method to make sure that the correct index is chosen,
 * the correct element is inserted, and all the following elements are shifted one place
 * to the right. <br>
 * Expected Result: [1 2 3 4 6 5]<br>
 * Actual Result: [1  2  3  4  6  5] 
 * <br> <br>
 * Test Five: Testing the ModifyAt method that changes the element at a specific index
 * without shifting elements to the right.<br>
 * Expected Result:  [5 2 3 4 6 5]<br>
 * Actual Result:  [5  2  3  4  6  5] 
 * <br><br>
 * Test Six: Test the getSize method that tells the number of elements in a sequence.<br>
 * Expected Result: 6<br>
 * Actual Result: 6
 * <br><br>
 * Test Seven: Test the retrieveAt method to make sure the correct index is chosen, and the
 * right element is returned.<br>
 * Expected Result: 3<br>
 * Actual Result: 3
 * <br><br>
 * Test Eight: This is a two part test that compares two sequences. The first test should
 * identify two equal sequences, the second test should identity non-equal sequences.<br>
 * Expected Result: Equal<br>
 * Actual Result:  Equal<br>
 * Expected Result: Not equal<br>
 * Actual Result: Not equal
 * <br><br>
 * Test Nine: Check to make sure a new value is added to the head of the sequence, and all
 * values are shifted to the right.<br>
 * Expected Result: [1 5 2 3 4 6 5]<br>
 * Actual Result: [1  5  2  3  4  6  5]
 * <br><br>
 * Test Ten: Check to make sure a new value is added to the tail of the sequence.<br>
 * Expected Result: [1 5 2 3 4 6 5 7]<br>
 * Actual Result: [1  5  2  3  4  6  5 7]
 * <br><br>
 * Test 11:  Test the default constructor of RLEConverter and display the contents of the two lists.<br>
 * Expected Result: []<br>
 * Expected Result: []<br>
 * Actual Result: []<br>
 * Actual Result: []  <br><br>
 * Test 12: Test the compression method of RLEConverter and display the contents of the
 * compressed sequence and its companion list.<br>
 * Expected Result: [0 4 5]<br>
 * Expected Result: [3 1 1]<br>
 * Actual Result: [0 4 5]<br>
 * Actual Result: [3 1 1]<br><br>
 * Test 13:  Test the uncompress method of the RLEConverter class and display the contents
 * of the uncompressed sequence.<br>
 * Expected Result: [0, 0, 0, 4, 5]<br>
 * Actual Result: [0, 0, 0, 4, 5]<br><br>
 * Test 14: Test the method tailReplace() to make sure it adds the correct number of elements
 * at the correct index, without removing existing elements. I am printing a compressed list
 * sequence, and then printing a second compressed list sequence, and then printing the first
 * list sequence after nesting the second one inside it starting at the first index.
 * Expected Results: [255] <br>
 * Expected Results: [0 1 2 3 4 5 6 7 8 9]<br>
 * Expected Results:  [0 1 2 3 4 5 6 7 8 9 255]<br>
 * Actual Results: [255]<br>
 * Actual Results: [0  1  2  3  4  5  6  7  8  9]<br>
 * Actual Results: [0  1  2  3  4  5  6  7  8  9  255]<br><br>
 * 
 */
public class RLESequenceV3Tester {
	
	RLESequenceV3 newSequence;
	RLEConverter converter;
	
	/**
	 * Create a sequence using the default constructor. This method
	 * also tests the createSequence and initializeSequence.
	 */
	public void testDefaultConstructor(){
		newSequence = new RLESequenceV3();
	}
	
	/**
	 * Create a sequence using the constructor that accepts 
	 * an integer to specify a length. This method
	 * also tests the createSequence and initializeSequence.
	 * @param length of type integer.
	 */
	public void testParamConstructor(int length){
		newSequence = new RLESequenceV3(length);
	}
	
	/**
	 * Create a sequence using the constructor that accepts
	 * an array of integers as the argument. This method
	 * also tests the createSequence and initializeSequence.
	 * @param testArray of type integer array.
	 */
	public void testArrayConstructor(int[] testArray){
		newSequence = new RLESequenceV3(testArray);		
	}
	
	/**
	 * Checks the method that returns the number of elements in a sequence.
	 */
	public void testGetSize(){
		System.out.println(newSequence.getSize());
	}
	
	/**
	 * Checks the method that inserts new integers at a
	 * specific index without replacing the occupying element.
	 * So all the following values should be shifted to the right.
	 * @param index of type integer, between 0 and length of sequence.
	 * @param element of type integer, between 0 and 255. 
	 */
	public void testInsertAt(int index, int element){
		newSequence.insertAt(index, element);
	}
	
	/**
	 * Checks to make sure the index that needs to be updated
	 * is replaced and not inserted.
	 * @param index of type integer, between 0 and length of sequence.
	 * @param element of type integer, between 0 and 255.
	 */
	public void testModifyAt(int index, int element){
		newSequence.modifyAt(index, element);
	}
	
	/**
	 * Checks to make sure the correct element is returned.
	 * @param index of type integer, represents the index of
	 * element to be returned.
	 */
	public void testRetrieveAt(int index){
		System.out.println(newSequence.retrieveAt(index));
	}
	
	/**
	 * Check to make sure comparing two sequences returns the right
	 * truth value.
	 * @param testSequence of type class object RLESequenceV1.
	 */
	public void testCompareTo(RLESequenceV3 testSequence){
		if(newSequence.compareTo(testSequence)){
			System.out.println("Equal");	
		}
		else{
			System.out.println("Not equal");
		}
	}
	
	/**
	 * Print the current sequence.
	 */
	public void testPrintSequence(){
		newSequence.printSequence();
	}
	
	/**
	 * Checks to make sure the correct value is prepended
	 * to the sequence.
	 * @param element of type integer, to be prepended to sequence. 
	 */
	public void testAddToHead(int element){
		newSequence.addToHead(element);
	}
	
	/**
	 * Checks to make sure the correct value is added
	 * to the end of the sequence.
	 * @param element of type integer, to be appended.
	 */
	public void testAddToTail(int element){
		newSequence.addToTail(element);
	}
	
	/**
	 * Call the only constructor and make sure it creates
	 * the data structures required for compression/uncompression.
	 */
	public void testConverterConstructor(){
		converter = new RLEConverter();
		System.out.println(converter.getCompressedSequence());
		converter.printCompanionList();
	}
	
	/**
	 * Tests the methods to compress a sequence, return a sequence, 
	 * and display a compressed sequence's companion list.
	 * @param testList of ArrayList integer. 
	 */
	public void testConverterCompress(ArrayList<Integer> testList){
		converter.toSpace(testList);
		System.out.println(converter.getCompressedSequence());
		converter.printCompanionList();
	}
	
	/**
	 * Tests the methods to uncompress a compressed sequence and return an
	 * uncompressed sequence.
	 */
	public void testConverterUncompress(){
		converter.toAPI();
		System.out.println(converter.getUncompressedSequence());
	}
	
	/**
	 * Checks that the method that adds a new sequence at some index in a 
	 * current sequence does not delete current elements, but adds at 
	 * the correct index, and then shifts all elements that follow to the right.
	 * @param index of type integer. 
	 * @param testSequence object of type RLESequenceV3. 
	 */
	public void testTailReplace(int index, RLESequenceV3 testSequence){
		newSequence.tailReplace(index, testSequence);
	}
}
