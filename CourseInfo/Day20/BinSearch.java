
public class BinSearch {

	public static void main(String[] args) {
		int[] array1 = {1,2,2,4,7,9,10,20};
		int searchVal = 1;
		
		// Index 'j1' is for the start of the portion of
		// the array we are searching.
		// Index 'j2' is for the end of the portion of
		// the array we are still searching.
		int j1 = 0, j2 = array1.length - 1;
		int mid = (j1 + j2 + 1)/2;
		System.out.println(j1 + "," + mid + "," + j2);
		while (j2 - j1 >1) {
			if (array1[mid] == searchVal) {
				System.out.println("Found at index " + mid);
				break;
			} else if (array1[mid] < searchVal) {
				j1 = mid;
			} else {
				j2 = mid;
			}
			mid = (j1 + j2 + 1)/2;
			System.out.println(j1 + "," + mid + "," + j2);
		}
		if (array1[j1] == searchVal || array1[j2] == searchVal) {
			System.out.println("Found");
		} else if (j2 - j1 <= 1) {
			System.out.println("Not found");
		}
	}

}
