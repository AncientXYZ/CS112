class Program05 {
	public static void main(String[] args) {
		float radius = 5; // 5 centimeters
		double height = 10; //centimeters;
		double PI = 3.1415926;
		double baseArea = PI*(radius * radius);
		double coneVolume = 1.0/3.0 * (baseArea * height);
		System.out.println("The volume of our cone is " + coneVolume);
	}
}