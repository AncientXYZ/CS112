
class MyWork {
	// Class variable i.e. instance variable.
	// Variable "belongs to an object".
	// Value is saved from one call to ShiftRegister() to the next call.
	int s_state = 0xace1;
	
	int ShiftRegister() {
		int bit = ((s_state >>> 0) ^ (s_state >>> 2) ^ (s_state >>> 3) ^ (s_state >>> 5)) & 1;
		s_state = ((s_state >>> 1) | (bit << 15));
		return s_state;
	}

	public static void main(String[] args) {
		// Left-shift and right-shift operations.
		byte x = (byte) 6;
		x <<= 3;
		System.out.println(x); // multiplies by Math.pow(2, 3)
		x >>= 4; // divides by Math.pow(2, 4)
		System.out.println(x);
		
		// Random number generator.
		MyWork myObj = new MyWork();
		for(int i = 0; i < 1000; i++) {
			System.out.println(myObj.ShiftRegister());
		}
	}
}