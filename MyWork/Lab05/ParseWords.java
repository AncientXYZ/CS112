public class ParseWords {
    public static void main(String[] args) {
        if (args.length > 0) {
            String input = args[0];
            String[] words = input.split(":", -1);

            for (String word : words) {
                if (word.isEmpty()) {
                    System.out.println("BLANK");
                } else {
                    System.out.println(word);
                }
            }
        }
    }
}
