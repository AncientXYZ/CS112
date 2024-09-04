public class FloatLimits {
    public static void main(String[] args) {
        float minFloat = 1.0f;
        double minDouble = 1.0;

        //Smallest float part
        while (minFloat / 2 > 0){
            minFloat /= 2;
        }

        //Smallest double part
        while (minDouble / 2 > 0){
            minDouble /= 2;
        }

        System.out.println("Smallest positive float is " + (minFloat * 2));
        System.out.println("Smallest positive double is " + (minDouble * 2));
    }
}
