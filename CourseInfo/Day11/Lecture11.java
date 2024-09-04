import java.util.InputMismatchException;
import java.util.Scanner;

class Lecture11 {
	// Might throw different kinds of exceptions.
	static int parseAPositiveInt(String inp)
		throws
			IllegalArgumentException,
			InputMismatchException
	{
		Scanner scan = new Scanner(inp);
		int retval = scan.nextInt(); // this might throw InputMismatchException
		if (retval < 0) {
			scan.close();
			throw new IllegalArgumentException("Need positive value");
		}
		scan.close();
		return retval;
	}
	
	// Throws AND handles an exception.
	static void willFail() {
		try {
			System.out.println(0 / 5);
			System.out.println(5 / 0);
		}
		catch (ArithmeticException ae) {
			System.err.println("We got an exception");
			System.err.println("Its message is " + ae.toString());
			ae.printStackTrace();
		}
		System.out.println("WE MADE IT HERE!");
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean done = false;
		while (!done) {
			System.out.println("Please enter a positive number");
			try {
				int v = parseAPositiveInt(scan.next());
				System.out.println("Read the number " + v);
				done = true;
			}
			catch (IllegalArgumentException iae) {
				done = false;
			}
			catch (InputMismatchException ime) {
				done = false;
			}
		}
		scan.close();
		
		willFail();
	}
}