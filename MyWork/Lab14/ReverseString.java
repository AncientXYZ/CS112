// This program inputs a string from args[0], reverses it,
// and prints out the result.

class ReverseString {
	// Reverse the chars in 'input' and return the result.
	static char[] StringToCharsReverse(String input) {
		char[] output = new char[input.length()];
		int i = input.length() - 1;
		int j = 0;
		while (i >= 0) {
			output[j] = input.charAt(i);
			i--;
			j++;
		}
		return output;
	}

	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("ERROR: need input arg");
			return;
		}
		String input = "It was the best of times, it was the worst of times.";
		System.out.println(new String(StringToCharsReverse(input)));
	}
}
