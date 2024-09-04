/** Plagiarism.java
 *
 * This version is BUGGY!
 *
 * @author Paul Haskell
 */


// BUGS:  upper/lowercase, multiple spaces, punctuation 


/** class Plagiarism
 *
 * Read a single command line argument, which contains multiple words.
 * Calculate and print the percentage of words that are 'the' or 'a' and
 * 'an'.  Ignore upper/lowercase, ignore punctuation, spacing, etc.
 */
public class Plagiarism {

	// Do all work in the main() method.
	// In the future, should move most functions to a separate class.
	static public void main(String[] args) {
		// Input is expected in args[0]. Make sure input exists.
		if (args.length < 1) { return; }
		
		// count total words
		String[] words = inp.split(" ");
		int totWords = words.length;
		
		// count 'the' words.
		int theCount = 0;
		for (int i = 0; i < totWords; i++) {
			if (words[i].equals("the")) {
				theCount++;
			}
		}
		
		// count 'a' and 'an' words
		int anCount = 0;
		for (int i = 0; i < totWords; i++) {
			if (words[i].equals("a") || words[i].equals("an")) {
				anCount++;
			}
		}
		
		// Calculate percentages and print the results as
		// an integer percentage (in range from 0 thru 100).
		System.out.println("Percentage of THE words is " +
				((int) (0.5 + 100.0*((float)theCount)/totWords)));
		System.out.println("Percentage of A or AN words is " +
				((int) (0.5 + 100.0*((float)anCount)/totWords)));
	} // end main()
} // end class Plagiarism
