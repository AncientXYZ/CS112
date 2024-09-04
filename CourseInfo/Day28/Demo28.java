import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.IOException;


public class Demo28 {

	public static void main(String[] args) {
		try {
			Scanner kbd = new Scanner(System.in);
			File theFile = new File("output.txt");
			PrintWriter pw = new PrintWriter(theFile);
			while (kbd.hasNextLine()) {
				String theLine = kbd.nextLine();
				theLine = theLine.toUpperCase();
				pw.write(theLine + "\n");
			}
			pw.close();
			kbd.close();

			// Part 2: see if file has a '$'
			File file2 = new File("output.txt");
			System.out.println("File length is " + file2.length());
			FileReader fr = new FileReader(file2);
			int theChar = fr.read();
			while (theChar != -1) { // not end-of-file
				if (theChar == '$') {
					System.out.println("Found '$'");
					break;
				}
				theChar = fr.read(); // read next char
			}
			if (theChar == -1) {
				System.out.println("Did not find '$'");
			}
			fr.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
