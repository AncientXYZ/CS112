class Collatz {
	static int runSteps(int n) {
		int numberOfSteps = 0;
		// STUDENT FILL IN HERE
		
		return numberOfSteps;
	}
	
	static public void main(String[] args) {
		int currentNumber = 1;
		while (currentNumber <= 200) {
			System.out.println(currentNumber + " " + runSteps(currentNumber));
			currentNumber++;
		}
	}
} // end class Collatz