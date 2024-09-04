public class Limits {
    public static void main(String[] args) {
            // byte limits
            byte byteVar1 = 0;
            byte byteVar2;
            while (true) {
                byteVar2 = byteVar1;
                byteVar1++;
                if (byteVar1 < byteVar2) {
                    break;
                }
            }
            System.out.println("Maximum byte value is " + (byteVar2));
            System.out.println("Minimum byte value is " + (byteVar1));

            // short limits
            short shortVar1 = 0;
            short shortVar2;
            while (true) {
                shortVar2 = shortVar1;
                shortVar1++;
                if (shortVar1 < shortVar2) {
                    break;
                }
            }
            System.out.println("Maximum short value is " + (shortVar2));
            System.out.println("Minimum short value is " + (shortVar1));

            // int limits
            int intVar1 = 0;
            int intVar2;
            while (true) {
                intVar2 = intVar1;
                intVar1++;
                if (intVar1 < intVar2) {
                    break;
                }
            }
            System.out.println("Maximum int value is " + intVar2);
            System.out.println("Minimum int value is " + intVar1);
        }
}