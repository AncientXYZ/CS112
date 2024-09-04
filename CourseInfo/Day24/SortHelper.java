/**********************************
 * SortHelper.java contains a class
 * with methods to help with dedicated
 * sorting algorithms.
 *
 * @author Paul Haskell
 */

import java.util.Random;


/** SortHelper contains several static methods
 * that help implement and test sorting
 * algorithms.
 */
public class SortHelper {
	private static Random randGen = new Random();

	/** Assigns random integer values to all elements in
	 * the provided int array.
	 * @param values the array to be filled in
	 */
	static void setValues(int[] values) {
		final int L = values.length;
		final int MaxVal = 2*L;
		for(int i = L-1; i >= 0; i--) {
			values[i] = randGen.nextInt(MaxVal);
		}
	}

	/** Validates that the input values are sorted in increasing order.
	 * @param values the int array values to validate
	 * @throws Exception if the data are not in increasing order
	 */
	static void validate(int[] values)
		throws
			Exception // if input array is not sorted properly
	{
		for(int i = values.length - 1; i > 0; i--) {
			if (values[i-1] > values[i]) {
				throw(new Exception("Sort failed"));
			}
		}
	} // end validate()

	/** Swaps element 'i' and element 'j' in the
	 * int array 'data'.<br>
	 * Requires three 'copy' operations and zero
	 * 'compare' operations.
	 */
	static void swap(int[] data, int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
}