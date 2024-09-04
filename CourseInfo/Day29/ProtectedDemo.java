class Dessert {
	private String name;
	protected int calories() { return 100; }
	public String recipe;
	
	public Dessert(String s) { name = s; }
}

class Sundae extends Dessert {
	public Sundae() {
		super("Sundae");
		// name = "it's obvious!";
		recipe = "Mix ice cream, sauce, and nuts";
	}
	protected int calories() {
		return 550 + super.calories();
	}
}

public class ProtectedDemo {

	public static void main(String[] args) {
		Sundae myFavorite = new Sundae();
		// myFavorite.name = "Fenton's black and tan";
		
		// Kinda weird that ProtectedDemo can call
		// calories(), since it is protected.
		// But ok since we are in the same "package".
		System.out.println(myFavorite.calories());
		
		System.out.println(myFavorite.recipe);
	}

}
