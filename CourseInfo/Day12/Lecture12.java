class Lecture12 {
	private static String helper(int d)
			throws
			ArithmeticException
	{
		String retval = convert(d);
		System.out.println("End of helper");
		return retval;
	}

	private static String convert(int d)
			throws ArithmeticException
	{
		if (d < 0) {
			throw new ArithmeticException("Must be positive!");
		}
		return "value is " + d;
	}

	public static void main(String[] args) {
		// Show left-shift and right-shift in a byte.
		byte b = -1;
		System.out.println("-1 / 2 = " + (b>>1));
		byte c = (byte) (b << 1);
		System.out.println(c);

		// Show exception throwing and catching
		boolean done = false;
		int n = -44;
		// helper(n);
		while (!done) {
			done = true;
			try {
				System.out.println(helper(n++));
			}
			catch (ArithmeticException ae) {
				System.out.print('.');
				done = false;
			}
		}

		// Demonstrate a few methods in class String.
		String a = "Good Morning San Francisco";

		if (a.toLowerCase().equals("good morning san francisco")) {
			System.out.println("Match!");
		}
	}
}