public class ReadArgs {
    public static void main(String[] args) {
        System.out.println("Program called with " + args.length + " arguments:");
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}