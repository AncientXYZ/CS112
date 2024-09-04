
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class CSVWriter extends FileWriter {

    private int numberOfEntries = -1;

    public CSVWriter(String fileName) throws IOException {
        super(fileName);
    }

    public void writeln(String[] stringsForALine) throws InconsistentNumberOfEntriesException, IOException {
        if (numberOfEntries == -1) {
            numberOfEntries = stringsForALine.length;
        } else if (stringsForALine.length != numberOfEntries) {
            throw new InconsistentNumberOfEntriesException("Expected " + numberOfEntries + " entries, but got " + stringsForALine.length);
        }

        for (int i = 0; i < stringsForALine.length; i++) {
            write(stringsForALine[i]);
            if (i < stringsForALine.length - 1) {
                write(",");
            }
        }
        write("\n");
    }

    public void close() throws IOException {
        super.close();
    }
}

class InconsistentNumberOfEntriesException extends Exception {
    public InconsistentNumberOfEntriesException(String message) {
        super(message);
    }
}

class EmptyLineException extends InconsistentNumberOfEntriesException {
    public EmptyLineException(String message) {
        super(message);
    }
}

public class CSVTester {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             CSVWriter writer = new CSVWriter("CSVTester.csv")) {
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    throw new EmptyLineException("Empty line entered.");
                }
                String[] words = input.split("\s+");
                writer.writeln(words);
            }
        } catch (EmptyLineException e) {
            System.err.println(e.getMessage());
            // Exit the program with an error code
            System.exit(1);
        } catch (InconsistentNumberOfEntriesException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
