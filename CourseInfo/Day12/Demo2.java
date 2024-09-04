class Demo {
	int value;
	Demo(int i) { value = i; }
}

public class Demo2 {

	public static void main(String[] args) {
		// Show two different toUpperCase() methods in two classes.
		String v = "testing 1, 2, 3";
		String w = v.toUpperCase();

		char a = Character.toUpperCase('=');
		Character b = new Character('k');
		char d = b.toUpperCase('k');
		System.out.println(a);
		
		// Show an "Objects and References" example.
		new Demo(7);
		Demo d1 = new Demo(11);
		Demo d2 = new Demo(22);
		d1 = d2;
		d2 = d1;
		
		// Show a Prefix and Postfix operator example.
		int v1 = 10;
		int v2 = v1++;
		int v3 = --v2;
		System.out.println(v1 + ", " + v2 + ", " + v3);
		System.out.println();

		int w1 = 10, w2, w3;
		for(int count = 0; count < 10; count++) {
			//w1 = 10;
			w2 = ++w1 + 5; // increment w1, create w2, set w2 to new value of w1
			w3 = w2--;
			System.out.println(w1 + ", " + w2 + ", " + w3);
		}
	}

}
