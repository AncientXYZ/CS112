import java.util.ArrayList;

/*
 * Demonstrate creation of our own "generic".
 * Also show use of an ArrayList.
 */

class Randomize<TheDataType> {
	TheDataType getRand(TheDataType a, TheDataType b) {
		if (Math.random() > 0.5) {
			return a;
		}
		return b;
	}
}

public class MyWork {

	public static void main(String[] args) {
		// Use our own "generic".
		Randomize<Double> theRandomizer = new Randomize<>();
		Randomize<String> stringRand = new Randomize<>();

		System.out.println(theRandomizer.getRand(1.1, 3.1415));
		System.out.println(stringRand.getRand("bike", "walk"));
		
		
		// Show off the ArrayList.
		ArrayList<Integer> myList = new ArrayList<>();
		myList.add(11);
		myList.add(22);
		myList.add(33);
		myList.add(0, 44);
		myList.remove(1);
		System.out.println(myList);
	}

}
