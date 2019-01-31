package rlesequence;

import java.util.ArrayList;

/**
 * 
 * <strong>@author Caleb Kinmon (UNI: cgk2128)</strong>
 * <br><br>
 * This class uses the three RLESequenceTester classes to test input, output, and
 * check for errors. Because the three classes contain the same exact methods, I
 * used the same Runner class for all three. In order to save time and be more efficient 
 * for testing, I manually changed the object tester type depending on which class I want 
 * to test. So after I tested RLESequenceV1Tester, I changed the name to
 * RLESequenceV2Tester, without changing the object reference name. Then did the same for V3.
 * But be careful that you don't call tests for V1 that only exist for V2+ (tests 11-14). 
 * <br><br>
 * Tests one through ten are applicable to RLESequenceV1Tester, RLESequenceV2Tester, and RLESequenceV3Tester.
 * The results are the same for RLESequenceV2Tester since it converts back to an
 * uncompressed form. This was validated in testing. I also ran these ten tests for
 * RLESequenceV3Tester, but the expected/actual results are different, because it
 * operates on the compressed sequence. 
 * <br><br>
 * Tests 11 through 13 are applicable to RLESequenceV2Tester and RLESequenceV2Tester; they test the RLEConverter
 * class and make sure the constructor works, and the sequences are compressed and uncompressed.
 * <br><br>
 * Tests 14 are applicable only to RLESequenceV3Tester.  Here I am checking that the tailReplace() method
 * for step four is correctly inserting the new sequence at the correct index without deleting
 * existing elements.  
 *
 */
public class Runner {

	public static void main(String[] args) {
		
		RLESequenceV3Tester tester = new RLESequenceV3Tester();
		
		/* 
		 * Test One: See each RLESequenceTester for test details
		 * Tests default constructor
		 */
		tester.testDefaultConstructor();
		tester.testPrintSequence();
		
		/* 
		 * Test Two: See each RLESequenceTester for test details
		 * Tests constructor that accepts integer	
		 */
		tester.testParamConstructor(20);
		tester.testPrintSequence();
		
		/* 
		 * Test Three: See each RLESequenceTester for test details
		 * Tests constructor that accepts array of integers
		 */
		int[] testArray = new int[]{1,2,3,4,5};
		tester.testArrayConstructor(testArray);
		tester.testPrintSequence();
		
		// Test Four: See each RLESequenceTester for test details
		tester.testInsertAt(4, 6);
		tester.testPrintSequence();
		
		// Test Five: See each RLESequenceTester for test details
		tester.testModifyAt(0, 5);
		tester.testPrintSequence();
		
		// Test Six: See each RLESequenceTester for test details
		tester.testGetSize();
		
		// Test Seven: See each RLESequenceTester for test details
		tester.testRetrieveAt(2);
		
		// Test Eight: See each RLESequenceTester for test details
		// Tests compareTo methods
		// Part One
		RLESequenceV3 testSequence = new RLESequenceV3(testArray);
		testSequence.insertAt(4, 6);
		testSequence.modifyAt(0, 5);
		tester.testCompareTo(testSequence);
		
		// Part Two
		RLESequenceV3 testSequence2 = new RLESequenceV3(testArray);
		testSequence.insertAt(3, 6);
		testSequence.modifyAt(0, 5);
		tester.testCompareTo(testSequence2);
		
		// Test Nine: See each RLESequenceTester for test details
		tester.testAddToHead(1);
		tester.testPrintSequence();
		
		// Test Ten: See each RLESequenceTester for test details
		tester.testAddToTail(7);
		tester.testPrintSequence();
		
		// Test 11: See each RLESequenceTester for test details
		tester.testConverterConstructor();
		
		// Test 12: See each RLESequenceTester for test details
		ArrayList<Integer> testAL = new ArrayList<Integer>();
		testAL.add(0);
		testAL.add(0);
		testAL.add(0);
		testAL.add(4);
		testAL.add(5);
		tester.testConverterCompress(testAL);
		
		// Test 13: See RLESequenceV2Tester for test details
		tester.testConverterUncompress();
		
		// Test 14: See RLESequenceV3Tester for test details
		int[] testArray2 = new int[10];
		for (int i = 0; i < 10; i++){
			testArray2[i] = i;
		}
		RLESequenceV3Tester testSequence3 = new RLESequenceV3Tester();
		testSequence3.testDefaultConstructor();
		testSequence3.testPrintSequence();
		
		RLESequenceV3 testSequence4 = new RLESequenceV3(testArray2);
		testSequence4.printSequence();
		
		testSequence3.testTailReplace(0, testSequence4);
		testSequence3.testPrintSequence();
	 
	}

}
