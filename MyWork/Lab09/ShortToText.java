public class ShortToText {
    public static void main(String[] args) {

        // transform the first argument to short
        short value = Short.parseShort(args[0]);
        // print the binary representation of the short value
        System.out.println(shortToBinaryString(value));
    }

    static String shortToBinaryString(short value) {
        StringBuilder sb = new StringBuilder();
        // reverse order to print the binary representation
        for (int i = 15; i >= 0; i--) {
            // append the i-th bit of value to sb
            sb.append((value >> i) & 1);
        }
        return sb.toString();
    }
}
