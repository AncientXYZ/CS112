import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.CharBuffer;


/** We write a class that implements the <b>Readable</b> interface.
 * "Readables" <u>must implement</u> two methods:<br>
 * - char read()<br>
 * - int read(CharBuffer)
 * @author phaskell
 */
class RandomChars implements Readable {
	//
	// Class variables
	//
	private static Random rand = new Random();
	private int charsToSend = 500; // send this many :)

	//
	// Class methods
	//
	private static char nextChar() {
		return (char) (32 + rand.nextInt(58)); // from SPACE thru 'Z'
	}

	public char read() {
		if (--charsToSend <= 0) {
			return (char) -1; // END OF FILE
		}
		return nextChar();
	}

	public int read(CharBuffer cb) throws IOException {
		int charsSent = 0;
		while (--charsToSend >= 0) {
			charsSent++;
			cb.put(nextChar());
		}

		if (charsSent > 0) { return charsSent; }
		return -1; // END OF FILE
	}
}








public class ReadableExample {

	public static void main(String[] args) {
		Scanner scan = new Scanner( new RandomChars() );
		while (scan.hasNext()) {
			System.out.println("WORD: " + scan.next());
		}
		scan.close();

		System.out.println("\nPROGRAM ENDED.");
	}

}








/** A class that implements <b>Readable</b> and <b>Writer</b>, i.e. the read() and write() methods.<br>
 * - <b>read()</b> returns strings from a hard-coded string array of test inputs.
 * Read data is logged to a file, prepended by "READ:"<br>
 * - <b>write()</b> writes to the same log file, prepended by "WRITE:"<br>
 * The constructor takes a <b>File</b>, the log file, as an argument.<br><br>
 * This class can be used for testing. The hard-coded String contains desired test inputs,
 * and when used, the Log file contains a printout of all read and written data.
 * @author phaskell
 */
class DebugSrc
	extends
		Writer
	implements
		Readable
{
	//
	// Class variables
	//
	private String[] testInput = {
			"login",
			"bet:500",
			"play:dealer:AH:you:10D:5D",
			"status:lose",
			"done:out of money"
	};

	private int indx = 0; // which String from testString to send next

	PrintWriter m_pw = null; // log all read and write activity

	//
	// Constructor
	//
	DebugSrc(File f) throws FileNotFoundException {
		m_pw = new PrintWriter(f);
	}

	//
	// Class methods
	//
	public int read(CharBuffer cb) throws IOException {
		if (indx < testInput.length) {
			cb.put(testInput[indx]); // return the next input String to the requesting buffer 
			m_pw.println("READ: " + testInput[indx]); // ... and save it to the Log
			final int charsSent = testInput[indx++].length();
			return charsSent;
		}
		// END OF INPUT
		return -1; 
	}

	public void write(char[] cbuf, int off, int len) throws IOException {
		char[] tmp = new char[len-off];
		for (int i = 0; i < len-off; i++) { tmp[i] = cbuf[i+off]; }
		String s = new String(tmp);
		m_pw.println("WRITE: " + s);
	}

	public void flush() {
		m_pw.flush();
	}

	public void close() {
		m_pw.close();
	}
}
