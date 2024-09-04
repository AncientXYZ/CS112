/** AList is an ArrayList of Strings
 * that we implemented ourselves!
 */
class AList {
	private String[] data;
	private int indx = 0;
	
	public AList() {
		data = new String[1];
	}

	public void add(String s) {
		// If 'data' is full, make a new array
		// that is longer, and copy our data to the
		// new longer array.
		if (indx >= data.length) {
			String[] newArray = new String[data.length + 1];
			for (int j = 0; j < data.length; j++) {
				newArray[j] = data[j];
			}
			data = newArray; // old 'data' object becomes garbage
		}
		data[indx++] = s; // save the new value to the array
	}

	public void remove() {
		if (data.length < 2) {
			return; // do not let data.length get smaller than 1
		}
		String[] newArray = new String[data.length - 1];
		for(int j = 0; j < newArray.length; j++) {
			newArray[j] = data[j];
		}
		data = newArray;
		indx--;
	}

	public String get(int i) {
		return data[i];
	}

	public int length() {
		return indx;
	}
}


public class ArrayList2 {

	public static void main(String[] args) {
		AList theList = new AList();
		theList.add("red");
		theList.add("green");
		theList.add("blue");
		theList.remove();
		theList.remove();
		theList.remove();
		theList.remove();
		for (int indx = 0; indx < theList.length(); indx++) {
			System.out.println(theList.get(indx));
		}
	}

}
