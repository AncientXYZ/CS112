public class BigSums {
    public static void main(String[] args) {
        double d1 = 1024.0;
        double d2 = d1;
        double d3;
        int dc = 0;

        //double part until d3 - d2 is not 1
        do {
            d3 = d2 + 1.0;
            if (d3 - d2 == 1.0) {
                d2 *= d1;
                dc++;
            } else {
                break;
            }
        } while (true);

        System.out.println(dc);

        float f1 = 1024.0f;
        float f2 = f1;
        float f3;
        int fc = 0;

        // float part until f3 - f2 is not 1
        do {
            f3 = f2 + 1.0f;
            if (f3 - f2 == 1.0f) {
                f2 *= f1;
                fc++;
            } else {
                break;
            }
        } while (true);

        System.out.println(fc);
    }
}
