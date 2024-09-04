public class Euclid {
    //recursion method to find the greatest common factor of two numbers
    public int GCF(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return GCF(b, a % b);
        }
    }

    public static void main(String[] args) {
        //if the user does not enter two numbers, the program will not run
        if (args.length != 2) {
            System.err.println("Please enter two numbers.");
            return;
        }
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        Euclid e = new Euclid();
        System.out.println(e.GCF(a, b));
    }
}
