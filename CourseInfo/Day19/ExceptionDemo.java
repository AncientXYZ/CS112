/* Show off all aspects of exception management:
 * - try
 * - catch
 * - throws
 * - throw
 */

public class ExceptionDemo {
	static int doTheWork(int a, int b) throws
		ArithmeticException,
		IllegalArgumentException
	{
		if (b < 0) {
			throw new IllegalArgumentException("b must be >= 0");
		}
		int retval = 2*a*a*a - 3*a + 4;
		retval /= b*b - b; // may throw ArithmeticException
		return retval;
	}

	public static void main(String[] args) {
		for (int a = 0; a < 5; a++) {
			for (int b = -1; b < 3; b++) {
				try {
					System.out.println(doTheWork(a, b));
				}
				catch (ArithmeticException ae) {
					System.out.println(0);
				}
				catch (IllegalArgumentException e) {
					// do nothing
				}
			}
		}
	}
}
