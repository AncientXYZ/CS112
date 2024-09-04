interface StringDressing {
	String dress(String s);
}

class FormalDressing implements StringDressing {
	public String dress(String s) {
		return "<" + s + ">";
	}
}


public class ShowLambda
{
	public static void main(String[] args) {
		StringDressing inQuotes = s -> "\"" + s + "\"";
		StringDressing inBraces = s -> "{" + s + "}";
		StringDressing upper = s -> s.toUpperCase();
		StringDressing repeat = s -> s + ", " + s;
		StringDressing inBrackets = new FormalDressing();

		StringDressing myDress = null;
		final int randIndx = (int) (5.0 * Math.random());
		switch (randIndx) {
			case 0: myDress = inQuotes; break;
			case 1: myDress = inBraces; break;
			case 2: myDress = upper; break;
			case 3: myDress = repeat; break;
			case 4: myDress = inBrackets; break;
		}
		System.out.println(myDress.dress("wow"));
	}
} // end ShowLambda