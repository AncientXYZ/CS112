/****************************************************************
 * filename: SelectionSort.java
 * 
 * Methods to perform a selection sort.
 *
 * Main() method generates test data, sorts it, validates result.
 *
 * @author phaskell
 ****************************************************************/


//////
////// Imports
//////

//////
////// Class definitions
//////
/** class SelectionSort
 *
 * A class that performs and validates selection sort.
 * @author phaskell
 */
public class SelectionSort {
	// Variables for counting how many operations are used
	// by different sort methods.
	static long numCompares = 0;
	static long numCopies = 0;

	/** selectionSort()
	 *
	 * Perform an in-place selection sort on 'values'.
	 * @param values - the data to sort
	 */
	private static void selectionSort(int[] values) {
		for (int i = 0; i < values.length; i++) {
			int minVal = values[i];
			int minIndx = i;
			numCopies += 3;
			numCompares++;
			for(int j = i+1; j < values.length; j++) {
				numCopies++;
				numCompares += 2;
				if (values[j] < minVal) {
					minVal = values[j];
					minIndx = j;
					numCopies += 2;
				}
			}
			int tmp = values[i];
			values[i] = values[minIndx];
			values[minIndx] = tmp;
			numCopies += 3;
		}
	}

	public static void main(String[] args) {
		// Create a list of integers
		final int NumValues = 50000;
		int values[] = new int[NumValues];

		// Assign random values to values[]
		SortHelper.setValues(values);

		// Sort the data and print run-time info.
		final long startTime = System.currentTimeMillis();
		selectionSort(values);

		final long endTime = System.currentTimeMillis();
		System.out.println("Elapsed time: " + (endTime - startTime)/1000.0 + " seconds");
		System.out.println(numCompares + " compares, " + numCopies + " copies");

		// Validate the sort worked properly
		try {
			SortHelper.validate(values);
		} catch (Exception e) {
			System.err.println(e);
			return;
		}
		System.out.println("Sort good!");
	} // end main()

} // end class SelectionSort
