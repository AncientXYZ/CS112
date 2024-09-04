import java.util.Scanner;


public class Quiz10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Error checking (not required).
		if (!scan.hasNextLine() ) {
			System.err.println("ERROR: no input at all!");
			return;
		}
		
		// Actual input handling.
		while (scan.hasNextLine()) {
			String a = scan.nextLine();
			String b = a.toUpperCase();
			System.out.println( b );
		}
		scan.close();

	}

}
