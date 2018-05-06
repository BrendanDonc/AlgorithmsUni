package Assignment;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class BruteForceAlgorithmTests {

	
	int[] testArray;
	
	//Clear the test array before each test
	@Before
	public void setupArray() {
		testArray = null;
	}
	
	/*
	 * Test 1 Find the median of a single element array
	 * 
	 */
	@Test
	public void testSingleInput() {
		testArray = new int[] {1};
		assertEquals(1, BruteForceAlgorithm.BruteForceMedian(testArray));
	}
	
	/*
	 * Test 2 Find the median of an array with all the same elements
	 * 
	 */
	@Test
	public void testAllSame() {
		testArray = new int[] {3,3,3,3,3,3};
		assertEquals(3, BruteForceAlgorithm.BruteForceMedian(testArray));
	}
	
	/*
	 * Test 3 Find the median of an array in ascending order
	 * 
	 */
	@Test
	public void testAscendingOrder() {
		testArray = new int[] {1,2,3,4,5,6,7};
		assertEquals(4, BruteForceAlgorithm.BruteForceMedian(testArray));
	}
	
	/*
	 * Test 4 Find the median of an even length array in ascending order
	 * 
	 */
	@Test
	public void testAscendingOrderEven() {
		testArray = new int[] {1,2,3,4,5,6,7,8};
		assertEquals(4, BruteForceAlgorithm.BruteForceMedian(testArray));
	}
	
	/*
	 * Test 5 Find the median of an array in descending order
	 * 
	 */
	@Test
	public void testDescendingOrder() {
		testArray = new int[] {7,6,5,4,3,2,1};
		assertEquals(4, BruteForceAlgorithm.BruteForceMedian(testArray));
	}
	
	/*
	 * Test 6 Find the median of an even length array in descending order
	 * 
	 */
	@Test
	public void testDescendingOrderEven() {
		testArray = new int[] {8,7,6,5,4,3,2,1};
		assertEquals(4, BruteForceAlgorithm.BruteForceMedian(testArray));
	}
	
	/*
	 * Test 7 Find the median of an array with negative elements
	 * 
	 */
	@Test
	public void testNegative() {
		testArray = new int[] {-4,-7,-10,4,-52};
		assertEquals(-7, BruteForceAlgorithm.BruteForceMedian(testArray));
	}
	
	/*
	 * Test 8 Find the median of an array when the median element is at the end
	 * 
	 */
	@Test
	public void testMedianAtEnd() {
		testArray = new int[] {1,1,1,1,1,1,1,1,9,9,9,9,9,9,9,9,5};
		assertEquals(5, BruteForceAlgorithm.BruteForceMedian(testArray));
	}
	
	/*
	 * Test 9 Find the median of an array when the median element is at the start
	 * 
	 */
	@Test
	public void testMedianAtStart() {
		testArray = new int[] {5,1,1,1,1,1,1,1,1,9,9,9,9,9,9,9,9};
		assertEquals(5, BruteForceAlgorithm.BruteForceMedian(testArray));
	}

}
