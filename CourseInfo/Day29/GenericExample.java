class Demo<TTT> {
	private TTT value;
	
	public Demo(TTT inp) { value = inp; }
	
	public String toString() {
		return "My value is " + value;
	}
}


public class GenericExample {
	static long factorial(long n) {
		// Need stopping condition!
		if (n <= 1) { return 1; }
		
		return n * factorial(n-1);
	}

	public static void main(String[] args) {
		Demo<Integer> demoInt = new Demo<>(33);
		Demo<String> demoString = new Demo<>("some string");
		factorial(7);
		System.out.println(demoInt + ", " + demoString);
	}

}
