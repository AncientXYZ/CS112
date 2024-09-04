public class FixCapitalization {
    public static void main(String[] args) {
        if (args.length > 0) {
            String sentences = args[0];
            StringBuilder result = new StringBuilder();
            boolean beginOfNewSentence = true;

            for (int i = 0; i < sentences.length(); i++) {
                char currentChar = sentences.charAt(i);

                if (beginOfNewSentence && Character.isLetter(currentChar)) {
                    // check the beginning of sentence
                    result.append(Character.toUpperCase(currentChar));
                    beginOfNewSentence = false;
                } else {
                    result.append(Character.toLowerCase(currentChar));
                }

                // check the end mark
                if (currentChar == '.' || currentChar == '!' || currentChar == '?') {
                    beginOfNewSentence = true;
                }
            }
            System.out.println(result);
        }
    }
}