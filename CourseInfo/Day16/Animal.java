class Cat extends Animal {
	// String mySound; // NEVER "override" PARENT VARIABLE!
	
	Cat() {
		name = "cat";
		mySound = "meow";
	}
	public String sound() {
		return "Cats say " + super.sound();
	}
}

class Lion extends Cat {
	public String sound() { return "Roar!"; }
}

class Dog extends Animal {
	Dog() {
		name = "dog";
		mySound = "woof";
	}
	
	public String sound() {
		return "Dogs say " + super.sound();
	}
}

public class Animal {
	String name = "animal";
	String mySound = "";

	public String sound() { return mySound.toUpperCase(); }
	
	public static void main(String[] args) {
		Dog sparky = new Dog();
		System.out.println(sparky.sound());
		Cat courageous = new Cat();
		System.out.println(courageous.sound());

	}

}
