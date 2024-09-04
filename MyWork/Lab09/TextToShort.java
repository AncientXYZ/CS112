public class TextToShort {
    public static void main(String[] args) {
        // check if there is exactly one argument
        if (args.length != 1) {
            System.err.println("ERROR");
            return;
        }

        // remove all whitespaces and commas from the input
        String input = args[0].replaceAll("[,\\s]+", "");

        // check the length of the input
        if (input.length() > 16) {
            System.err.println("ERROR");
            return;
        }

        // check the input contains only 0s and 1s
        if (!input.matches("[01]+")) {
            System.err.println("ERROR");
            return;
        }

        // transform the binary string to short
        short value = convertBinaryStringToShort(input);

        // print the short value
        System.out.println(value);
    }

    static short convertBinaryStringToShort(String binaryString) {
        // if the binary string is shorter than 16 characters, add leading zeros
        StringBuilder binaryStringBuilder = new StringBuilder(binaryString);
        while (binaryStringBuilder.length() < 16) {
            binaryStringBuilder.insert(0, "0");
        }
        binaryString = binaryStringBuilder.toString();

        // transform the binary string to short
        short value = 0;
        for (int i = 0; i < 16; i++) {
            value <<= 1;
            if (binaryString.charAt(i) == '1') {
                value |= 1;
            }
        }
        return value;
    }
}
