/****************************************************************************
 * file:  MergeSort
 *
 * Implement and test MergeSort.
 * MergeSort is O(n log n) in computation, and O(n) in storage.
 * And it's a cool algorithm!
 *
 * It could be sped up by doing a bubble sort for any lists of length <= 3.
 * @author phaskell
 ****************************************************************************/


//////
////// Imports
//////


/** class MergeSort
 * 
 * Sort an array of ints, using MergeSort algorithm.
 */
class MergeSorter {
	// Variables to count the number of operations.
	static long numCompares = 0;
	static long numCopies = 0;

	/** Sort()
	 * 
	 * Sort an array of ints.
	 * @param in - the array of ints to be sorted
	 */
	public static void Sort(int[] in) {
		Sort(in, 0, in.length);
	}

	/* Sort()
	 * 
	 * The above function is just a helper. This function does actual sorting, recursively.
	 * Each invocation sorts a PORTION of the array:  indices [start, end-1].
	 * 
	 * @param in - input int array to be sorted
	 * @param start - index of starting subarray to sort
	 * @param end - index of the end of the subarray to sort
	 */
	private static void Sort(int[] in, int start, int end) {
		numCompares++;
		if (end - start == 2) {
			numCompares++;
			if (in[start+1] < in[start]) { // if 2 elements out of order, swap them
				numCopies += 3;
				int tmp = in[start];
				in[start] = in[start+1];
				in[start+1] = tmp;
			} // else we are done with this subarray, since it is already in order
		} else if (end - start > 2) { // recursive!
			numCompares++;
			numCopies++;
			int split = (end + start)/2;
			Sort(in, start, split);
			Sort(in, split, end);
			Merge(in, start, split, end); // after merge, our subarray is sorted
		} else if (end - start < 1) {
			System.err.println("Sort() ERROR: empty array");
		}
		/* else if (end - start < 2) { do nothing } */
	} // end Sort()

	/* Merge()
	 * 
	 * Inputs are two sorted subarrays:  in[start..mid-1] and in[mid..end-1].
	 * This function merges the subarrays, maintaining sort order.
	 * The result is that 'in' is sorted from start to end-1.
	 */
	private static void Merge(int[] in, int start, int mid, int end) {
		int a = start;
		int b = mid;
		int n = 0;
		int[] tmp = new int[end-start]; // temporary storage space.
		// Fill in 'tmp' from start of whichever subarray is smaller.
		while (a < mid && b < end) {
			numCompares += 3;
			if (in[a] < in[b]) {
				numCopies++;
				tmp[n++] = in[a++];
			} else {
				numCopies++;
				tmp[n++] = in[b++];
			}
		}

		// We must handle not-yet-merged elements in 'a' or 'b', and we must copy
		// merged data from 'tmp' to 'in'.  It would be simple to copy remaining
		// unmerged elements to the end of 'tmp' and then to copy all of 'tmp'
		// to in, but let's do this more efficiently.
		//
		// At this point, either the 'a' subarray or 'b' subarray is empty
		// (or both are empty).  If the 'b' subarray is not empty, its largest
		// elements are already at the end of 'in', and we can just copy
		// the "merged" elements to the start of 'in'.  If the 'a' subarray
		// is not empty, then the 'b' subarray IS empty.  We can copy unmerged
		// data from 'a' to the end of 'in', and then copy the "merged" data.

		// Copy unmerged 'a' data (if any) to end of 'in'.
		for (int i = a; i < mid; i++) {
			numCopies++;
			in[end - mid + i] = in[i];
		}
		// Now we copy the merged data to 'in'.
		for (int i = 0; i < n; i++) {
			numCopies++;
			in[i+start] = tmp[i];
		}
	} // end Merge()

	public static String print( ) { return "" + numCompares + " compares, " + numCopies + " copies"; }
} // end class MergeSort


public class MergeSort {

	public static void main(String[] args) {
		// Generate test data
		final int NumVals = 50000;
		int[] testData = new int[NumVals];
		SortHelper.setValues(testData);

		// Sort
		final long startTime = System.currentTimeMillis();
		MergeSorter.Sort(testData);
		final long endTime = System.currentTimeMillis();
		System.out.println("Elapsed time: " + (endTime - startTime)/1000.0 + " seconds");
		System.out.println(MergeSorter.print());

		// Verify
		try {
			SortHelper.validate(testData);
		}
		catch (Exception e) {
			System.err.println(e);
			return;
		}
		System.out.println("Sort good!");
	} // end main()

} // end class MergeSort
