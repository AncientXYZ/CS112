public class DemoRecursion {

	// Calculate factorial of n
	static long fact(long n) {
		// MUST have a stopping case
		if (n <= 1) {
			return 1;
		}
		return n * fact(n-1);
	}
	
	// Not recursive!
	static long fact2(long n) {
		long retval = 1;
		while (n > 1) {
			retval *= n--;
		}
		return retval;
	}

	// Fibonacci
	static long fib(long n) {
		// Base case
		if (n <= 1) {
			return 1;
		}
		
		return fib(n-1) + fib(n-2);
	}

	public static void main(String[] args) {
		System.out.println(fact(7));
		System.out.println(fact2(7));
		System.out.println(fib(15));
	}

}
