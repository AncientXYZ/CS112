public class Americanize {
    public static void main(String[] args) {
        if (args.length > 0) {
            String sentences = args[0];
            WordConvert converter = new WordConvert();
            StringBuilder result = new StringBuilder();
            String[] words = sentences.split(" ");

            for (String word : words) {
                result.append(converter.convert(word)).append(" ");
            }

            System.out.println(result.toString().trim());
        }
    }

    private static class WordConvert {
        private String convert(String word) {
            char lastChar = word.charAt(word.length() - 1);
            if (!Character.isLetter(lastChar)) {
                String actualWord = word.substring(0, word.length() - 1);
                return replaceWords(actualWord) + lastChar;
            } else {
                return replaceWords(word);
            }
        }

        private String replaceWords(String word) {
            // keep the capitalization
            if (word.equalsIgnoreCase("tea")) {
                if (Character.isUpperCase(word.charAt(0))) {
                    return "Coffee";
                } else {
                    return "coffee";
                }
            } else {
                return word;
            }
        }
    }
}