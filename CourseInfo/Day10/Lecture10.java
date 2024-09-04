
public class Lecture10 {
	// Class instance variable for "Circle".
	private final double radius;
	
	// Constructor for "Circle"
	public Lecture10(double r) { radius = r; }

	public double area() {
		return 3.141592 * radius * radius;
	}
	
	// Demonstrate range of double variables
	static void test1() {
		double x = 1.0;
		int count = 0;
		while (x > 0) {
			x /= 2.0;
			count++;
		}
		System.out.println(count);
	}
	
	// Calculate "machine epsilon", a measure of accuracy
	// when doing arithmetic
	private static void test2() {
		double x = 1.0;
		double xPlusOne = x + 1.0;
		int count = 0;
		while (xPlusOne > 1.0) {
			System.out.println("Iteration " + count + ":  x=" + x);
			x /= 2.0;
			xPlusOne = x + 1.0;
			count += 1;
		}
		System.out.println("Failure at iteration " + count + ":  x=" + x);
	}
	
	// The problem with comparing floating point numbers directly.
	private static void test3() {
		double x = 1.0/3.0; // x = 0.3333333.....
		int count = 0;

		while (x == 1.0/3.0) {
			System.out.println("Iteration " + count + ":  x=" + x);
			x -= 0.3; // x = (1/30) = 0.0333333333...
			x *= 10.0; // x = (1/3) = 0.333333333...
			count += 1;
		}
		System.out.println("Failure at iteration " + count + ":  x=" + x);
	}


	public static void main(String[] args) {
		Lecture10 theCircle = new Lecture10(2.0);
		System.out.println(theCircle.area());
		
		double num = 1.0;
		double denom = 0.0;
		System.out.println(num/denom); // show 'Infinity'

		test1();
		test2();
		test3();
	}

}
