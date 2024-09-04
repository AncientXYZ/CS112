/***********************************************************************
 * filename: heapsort.java
 *
 * An Order(N*log(N)) in-place sort routine!
 *
 * A heap is a balanced, sorted binary tree with "larger" elements on
 * top. The value of each node is larger than the values of each
 * of its two children.
 *
 * The tree is stored as an array, in which the children of
 * the element in position N are stored in array elements 2N+1 and 2N+2
 * (with array indexing starting at 0).
 * For example, the top of the tree is element 0, and its children
 * are 1 and 2. The children of 1 are 3 and 4. The children of 2 are
 * 5 and 6.
 *
 * The "heap sort" first builds a proper heap from an UNsorted tree,
 * then pulls out the largest element (top of the tree),
 * and then remakes a new heap without the already-sorted largest
 * element. This process repeats until all elements are pulled out.
 **********************************************************************/


public class HeapSort {
	static long numCompares = 0;
	static long numCopies = 0;

	public static void main(String[] args) {
		int[] theData = new int[50000];
		SortHelper.setValues(theData);

		// Sort the data and print run-time info.
		final long startTime = System.currentTimeMillis();
		heapsort(theData, theData.length);

		final long endTime = System.currentTimeMillis();
		System.out.println("Elapsed time: " + (endTime - startTime)/1000.0 + " seconds");
		System.out.println(numCompares + " compares, " + numCopies + " copies");

		// Validate the sort worked properly
		try {
			SortHelper.validate(theData);
		} catch (Exception e) {
			System.err.println(e);
			return;
		}
		System.out.println("Sort good!");
	} // end main()


	/* The left() and right() methods define how we map between the
	 * tree (i.e. heap) and its representation as an array.
	 */

	// Array index of left child of node 'i'
	static int left(int i)
	{ return (2*i+1); }

	// Array index of right child of node 'i'
	static int right(int i)
	{ return (2*i+2); }


	/* heapify()
	 *
	 * Input a balanced binary tree (stored as an array and with
	 * child-dependencies determined by the left() and right() functions
	 * above) and, starting at node 'startnode' and working downwards,
	 * convert it into a "heap" (i.e. swap elements so that the value
	 * of every node is greater than the values of its children).
	 *
	 * 'a' is a pointer to the array that represents our tree (i.e. heap).
	 * 'size' is the number of elements in 'a'.
	 * 'startnode' is the node where we start "heapifying".
	 */
	static void heapify(int[] a, int size, int startnode)
	{
		int largest = startnode; // build a heap starting at 'startnode'
		int pivot;

		do {
			pivot = largest; // this is the 'current' node
			final int l = left(pivot);
			final int r = right(pivot);
			numCopies += 3;

			// Find largest value among {parent, leftchild, rightchild}...
			numCompares += 2;
			if (l < size) {
				numCompares++;
				if (a[largest] < a[l]) {
					largest = l;
					numCopies++;
				}
			}
			if (r < size) {
				numCompares++;
				if (a[largest] < a[r]) {
					largest = r;
					numCopies++;
				}
			}

			// if 'parent' is not the largest...
			numCompares++;
			if (pivot != largest) {
				numCopies += 3;
				// ... swap the largest child with the parent...
				int tmp = a[pivot]; a[pivot] = a[largest]; a[largest] = tmp;

				// ... and "re-heapify" the child tree on the next
				// while() iteration.
				// 'largest' becomes the new 'parent' node.
			}
			numCompares++;
		} while (pivot != largest);
	}


	/* heapsort()
	 *
	 * Perform an in-place sort on the elements in 'data'.
	 * 'length' is the number of elements in 'data'.
	 *
	 * On exit, the elements of 'data' have been arranged so that
	 * they are increasing.
	 */
	static void heapsort(int[] data, int length)
	{
		// Build the initial heap. Start with a balanced binary tree,
		// and starting at the bottom, turn each "subtree" into a proper heap:
		// foreach node with children...
		for(int i = length/2-1; i >= 0; i--) {
			numCompares++;
			numCopies++;
			// ... build a proper heap.
			heapify(data, length, i);
		}

		// Foreach step in the sort...
		for(int i = length-1; i >= 1; i--) {
			numCompares++;
			numCopies += 4;
			// ...put the biggest element at the end of 'data'
			// and the former "last" element at the top of the heap...
			int tmp = data[i]; data[i] = data[0]; data[0] = tmp;

			// ...and rebuild a new heap.
			//
			// This new heap has one fewer element every time through the
			// for() loop, since the element at the end of 'data' already
			// is sorted.
			//
			// The '0' argument to heapify() means to build a heap starting
			// at the top of the tree, with the element just moved to the
			// top in the previous line of code.
			heapify(data, i, 0);
		}
	}

}