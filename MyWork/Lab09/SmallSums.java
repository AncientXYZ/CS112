public class SmallSums {
    public static void main(String[] args) {
        //float part
        float fc = 0.000001f;
        float sum = 0.0f;
        for (int i = 0; i < 1000000; i++) {
              sum += fc;
        }
        System.out.println(sum);

        //double part
        double dc = 0.000001;
        double dsum = 0.0;
        for (int i = 0; i < 1000000; i++) {
            dsum += dc;
        }
        System.out.println(dsum);
    }
}
