public class DataConvert {
    public static void main(String[] args) {
        float floatVar = 2.5f;
        int intVar = (int) floatVar;
        System.out.println("2.5 cast to int gives " + intVar);

        floatVar = -4.5f;
        intVar = (int) floatVar;
        System.out.println("-4.5 cast to int gives " + intVar);

        double doubleVar = 1.0 / 3.0;
        floatVar = (float) doubleVar;
        System.out.println("double 1/3 = " + doubleVar + " but float 1/3 = " + floatVar);

        intVar = 256;
        byte byteVar = (byte) intVar;
        System.out.println("byte value of 256 is " + byteVar);

        intVar = 257;
        byteVar = (byte) intVar;
        System.out.println("byte value of 257 is " + byteVar);

        intVar = 258;
        byteVar = (byte) intVar;
        System.out.println("byte value of 258 is " + byteVar);

        intVar = 511;
        byteVar = (byte) intVar;
        System.out.println("byte value of 511 is " + byteVar);
    }
}
