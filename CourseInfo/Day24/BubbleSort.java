/****************************************************************
 * filename: BubbleSort.java
 * 
 * Methods to perform a bubble sort.
 *
 * Main() method generates test data, sorts it, validates result.
 *
 * @author phaskell
 ****************************************************************/


//////
////// Class definitions
//////
/** class BubbleSort
 *
 * A class that performs and validates bubble sort.
 * Relies on methods in SortHelper.java.
 * @author phaskell
 */
public class BubbleSort {
	// Variables for counting how many operations are used
	// by different sort methods.
	static long numCompares = 0;
	static long numCopies = 0;

	
	/** BubbleSort()
	 *
	 * Perform an in-place bubble sort on 'values'.
	 * @param values - the data to sort
	 */
	private static void bubbleSort(int[] values) {
		for (int i = values.length - 1; i > 0; --i) {
			numCompares++;
			numCopies++;
			for(int j = 1; j <= i; j++) {
				numCompares += 2;
				numCopies++;
				if (values[j-1] > values[j]) {
					// swap
					int tmp = values[j-1];
					values[j-1] = values[j];
					values[j] = tmp;
					numCopies += 3;
				}
			}
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
		bubbleSort(values);

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
	
} // end class BubbleSort
