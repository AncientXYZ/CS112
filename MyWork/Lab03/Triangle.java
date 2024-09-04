public class Triangle {
    public static void main(String[] args) {
        for (int i = 1; i <= 15; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }
}
