/****************************************************************
 * filename: InsertionSort.java
 * 
 * Methods to perform insertion sort.
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
/** class InsertionSort
 *
 * A class that performs and validates several types of sorts.
 * @author phaskell
 */
public class InsertionSort {
	// Variables for counting how many operations are used
	// by different sort methods.
	static long numCompares = 0;
	static long numCopies = 0;


	/** class Node
	 * A "member class".
	 * Store an int in a linked list node.
	 */
	static class Node {
		int val;
		Node next;
		Node(int v) {
			val  = v;
			next = null;
			numCopies += 2;
		}
	}


	/** class IntList
	 * Another "member class".
	 * A singly-linked list of Nodes.
	 */
	static class IntList {
		Node head;

		/* add()
		 *
		 * Add integer 'v' to our list, in sorted order!
		 */
		void add(int v) {
			Node n = new Node(v); // the new Node for value 'v'.
			numCopies ++;
			numCompares++;
			if (head == null) { // empty list
				numCopies++;
				head = n;
				return;
			}
			numCompares++;
			if (head.val > v) { // 'v' is smallest value so far
				numCopies += 2;
				n.next = head;
				head = n;
				return;
			}
			// Must stick 'n' somewhere in middle of list.
			numCopies++;
			Node curr = head;
			numCompares += 2;
			while (curr.next != null && curr.next.val < v) {
				numCompares += 2;
				numCopies++;
				curr = curr.next;
			}
			// Found where in list to insert 'n', so insert it.
			numCopies += 2;
			n.next = curr.next;
			curr.next = n;
		}
	} // end class IntList


	/** insertionSort()
	 *
	 * Do an insertion sort using a list, rather than sorting an array.
	 */
	private static void insertionSort(int[] values) {
		IntList list = new IntList();

		// Put each element of 'values' into the sorted 'list'.
		for(int i = 0; i < values.length; i++) {
			numCopies++;
			numCompares++;
			list.add(values[i]); // add to list in correct sorted order
		}

		// Now read values out of the list back into the array.
		Node head = list.head;
		int i = 0;
		while (head != null) {
			numCompares++;
			numCopies += 3;
			values[i++] = head.val;
			head = head.next;
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
		insertionSort(values);

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


} // end class InsertionSort