
public class StaticAndRegularDemo {
	int regularVal;
	static int sharedVal;
	
	public String toString() {
		// return "" + regularVal + "," + sharedVal;
		return super.toString();
	}
	
	public boolean equals(StaticAndRegularDemo otherObject) {
		// if (otherObject.sharedVal == this.sharedVal) {
		if (otherObject.regularVal == this.regularVal) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		StaticAndRegularDemo obj1 = new StaticAndRegularDemo();
		StaticAndRegularDemo obj2 = new StaticAndRegularDemo();
		
		obj1.regularVal = 11;
		obj1.sharedVal = 111;
		System.out.println(obj1);
		System.out.println(obj2);
		
		obj2.regularVal = 22;
		obj2.sharedVal = 222;
		System.out.println(obj1);
		System.out.println(obj2);
		
		StaticAndRegularDemo.sharedVal = 333;
		System.out.println(obj1);
		System.out.println(obj2);
		
		String[] array = new String[44];
		System.out.println(array);
		
		if (obj1.equals(obj2)) {
			System.out.println("Match!");
		} else {
			System.out.println("No match");
		}
	}
}
