
public class Car {
	// Class variables, instance variables.
	private String make;
	private String model;
	private double topSpeed;

	private double fuelRemaining;
	private double milesPerGallon;
	
	public void travel (double miles) {
		double gallonsUsed = miles / milesPerGallon;
		if (gallonsUsed > fuelRemaining) {
			System.out.println("You ran out of fuel");
			fuelRemaining = 0;
		} else {
			fuelRemaining -= gallonsUsed;
		}
	}
	
	public void setup(double fuel, double mpg) {
		fuelRemaining = fuel;
		milesPerGallon = mpg;
	}
	
	public static void main(String[] args) {
		Car paulsVan = new Car();
		paulsVan.setup(20, 20);
		System.out.println("Driving to USF");
		paulsVan.travel(49.5);
		System.out.println("Driving to Paso Robles");
		paulsVan.travel(230.0);
		System.out.println("Driving back home");
		paulsVan.travel(185.2);
	}
}
