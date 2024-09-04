class Program02 {
	public static void main(String[] args) {
		double pizzaPrice = 24.50; // dollars
		double taxRate = 0.08625; // percentage
		double tip = 0.20; // percentage
		double afterTip = pizzaPrice * tip;
		double total = pizzaPrice + pizzaPrice*taxRate + afterTip; // Add in the tip!
		System.out.println("Total price of a $" + total + " pizza is $" + pizzaPrice);
	}
}