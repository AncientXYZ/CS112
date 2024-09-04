import java.util.Iterator;

/* Iterable and Iterator work together to let
 * users iterate over a set of values.
 *
 * Both are "generics" -- we have to specify the
 * type we are iterating over to convert the "generic"
 * into an actual class.
 */

class ResistorCodes implements Iterable<String> {

	// List of all the electrical resistor color codes.
	final String[] colors = {
		"black", "brown", "red", "orange", "yellow", "green",
		"blue", "violet", "gray", "white"
	};
	
	// A member class.  RR uses 'colors' from
	// ResistorCodes, so it must be a member class.
	class RR implements Iterator<String> {
		int index = 0;

		public boolean hasNext() {
			return index < colors.length;
		}

		public String next() {
			return colors[index++];
		}
	}

	// This method is required by interface Iterable
	public Iterator<String> iterator() {
		return new RR();
	}
}

public class IterableDemo {

	public static void main(String[] args) {
		ResistorCodes r = new ResistorCodes();
		for (String c : r) {
			System.out.println(c);
		}
	}

}
