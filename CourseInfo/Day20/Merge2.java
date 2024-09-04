/** filename: Merge2.java
 * Merge two sorted arrays into a combined
 * sorted output array.  Do not perform sorting
 * to do the merge!
 */

public class Merge2 {

	public static void main(String[] args) {
		int[] array1 = {1,3,3,6,8,11,27,33};
		int[] array2 = {2,4,5,6,9,15,44,55,66};
		// Indices that point to the FIRST NOT-YET-USED
		// elements in array1 and array2
		int i1 = 0;
		int i2 = 0;
		
		// A new array to hold the output.
		int[] output = new int[array1.length + array2.length];
		
		// For each slot in the output array...
		for(int o = 0; o < output.length; o++) {
			// If we still have data in both input arrays...
			if (i1 < array1.length && i2 < array2.length) { 
				// Find which input has smaller UNUSED input,
				// and copy that one to the output.
				if (array1[i1] < array2[i2]) {
					output[o] = array1[i1++];
				} else {
					output[o] = array2[i2++];
				}
			} else if (i1 < array1.length) { // array2 is done
				output[o] = array1[i1++];
			} else { // array1 is done
				output[o] = array2[i2++];
			}
		}

		// Print final results!
		for(int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}
		System.out.println();
	}

}
