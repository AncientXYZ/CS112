import java.util.Scanner;

public class EightLines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = 8;
        for (int i = 0; i < lines; i++) {
            //read a line
            String line = scanner.nextLine();
            //split the line into words
            String[] words = line.split("\\s+");

            //print the words
            for (String word : words) {
                //check if the word is empty
                if (!word.isEmpty()) {
                    System.out.println(word);
                }
            }
        }
    }
}