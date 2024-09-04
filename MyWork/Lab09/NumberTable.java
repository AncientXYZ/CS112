public class NumberTable {
    public static void main(String[] args) {
        for (int i = 100; i <= 255; i++) {
            // print the number, its hexadecimal representation and its binary representation.
            System.out.printf("%-5d%-5s%-5s%n", i, Integer.toHexString(i).toUpperCase(), Integer.toBinaryString(0x100 | i).substring(1));
        }
    }
}
