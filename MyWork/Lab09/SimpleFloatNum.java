/** class SimpleFloat
 *
 * class SimpleFloat explores a few of the complexities involved in
 * floating point mathematics.  Comments below explain what the student
 * must implement.
 */
class SimpleFloat {
	// Member variables
	short mantissa;
		/* The mantissa value holds the precision detail of the SimpleFloat.
		 * We want as many "significant digits" as possible.
		 * So we must "scale" the mantissa and exponent value so that
		 * the mantissa is "as large as possible" and the exponent is "as small
		 * as possible".  How do we do that?
		 *
		 * The mantissa is stored as a short, so it must fit within 16 bits.
		 * And we use the 'isNegative' flag to track whether this SimpleFloat
		 * is positive or negative.  The most significant bit of a short is the
		 * sign bit, corresponding to value (-1)*(2<<15).  Since this bit represents
		 * a negative value, we choose NOT TO USE IT in our SimpleFloat mantissa.
		 * In conclusion, we choose to scale our SimpleFloat mantissa and exponent
		 * so that the "almost-most" significant bit of the mantissa,
		 * corresponding to value (+1)*(2<<14), is nonzero.
		 */
	short exponent; // scales value of SimpleFloat by pow(2, exponent)
	boolean isNegative; // tracks if our SimpleFloat has negative value

	// public constructors
	public SimpleFloat(int m, int e) {
		ConstructorWorker(m, e);
	}

	public SimpleFloat(int m) {
		this(m, 0);
	}

	public SimpleFloat(SimpleFloat sf) {
		mantissa = sf.mantissa;
		exponent = sf.exponent;
		isNegative = sf.isNegative;
	}

	/* SimpleFloat(double)
	 *
	 * Convert a double value to a SimpleFloat.
	 * Choose mantissa and exponent values to maximize mantissa precision,
	 * as explained above.
	 */
	public SimpleFloat(double d) {
		// Special case handling
		if (d == 0.0) {
			ConstructorWorker(0, 0);
			return;
		}
		if (d < 0) {
			d *= -1;
			isNegative = true;
		}
		
		// 'd' is now nonzero and positive
		//
		// Now scale the exponent and mantissa as described above,
		// to maximize precision.
		int tmpExponent = 0;
		while (d < 16384.0) { // 16384 = binary 0100 0000 0000 0000
			d *= 2.0; // make mantissa bigger
			tmpExponent--;
		}
		while (d > 32767.0) { // 32767 = binary 0111 1111 1111 1111
			d /= 2.0; // mantissa is too big--make it smaller
			tmpExponent++;
		}

		// Now we can initialize this SimpleFloat with well-chosen
		// mantissa and exponent values.
		ConstructorWorker((int) d, tmpExponent);
	}


	// This method finishes the actual work of the constructors: sets values
	// for 'mantissa', 'exponent', and 'isNegative'
	//
	// The design of SimpleFloat requires that mantissa values always are positive
	// and that we use the isNegative flag to signal when a SimpleValue's overall
	// value is negative.
	private void ConstructorWorker(int m, int e) {
		if (m < 0) {
			m *= -1;
			isNegative = true;
		}
		mantissa = (short) m;
		exponent = (short) e;
		normalize();
	}

	/** normalize()
	 *
	 * When we represent a SimpleFloat, we want lots of bits of accuracy in
	 * the mantissa i.e. we want the leftmost nonzero bit in the mantissa to
	 * be "near" the most significant bit.
	 *
	 * This function left-shifts the mantissa and adjusts
	 * the exponent so the mantissa's "almost-most" significant bit is nonzero.
	 * Since the MOST significant bit of a short is a SIGN BIT,
	 * and since we cannot have the mantissa be negative,
	 * if the sign bit (most significant bit) of 'mantissa' IS SET, then we must shift
	 * the mantissa TO THE RIGHT by one bit position.
	 */
	private void normalize() {
		if (mantissa == 0) { return; }

		// If our mantissa OVERFLOWED into the "sign bit" (e.g. after addTo()),
		// then shift one bit to the right.
		if ((mantissa & 0x8000) != 0) {
			mantissa = (short) (mantissa >> 1);
			mantissa &= 0x7fff; // clear "sign bit"
			exponent += 1;
		}

		// Now renormalize properly: shift the mantissa to the left until the
		// "almost-most" significant bit is nonzero.
		while ((mantissa & 0x4000) == 0) {
			mantissa <<= 1;
			exponent -= 1;
		}
	}

	//////
	////// Code to be created by students
	//////

	/** addTo()
	 *
	 * add a SimpleFloat 'x' to this SimpleFloat
	 * and return a new SimpleFloat with the resulting value.
	 * Neither 'x' nor 'this' should be modified.
	 *
	 * The student should supply the necessary code and should TEST HEAVILY.
	 * What are special cases?  HINT:  zero values, negative values,
	 * two SimpleFloats with opposite signs, "big" values, "small but nonzero" values, etc.
	 *
	 * As discussed in class, recall that before adding the two mantissas,
	 * the exponents must be made equal.
	 * And we always want the mantissa's "sign bit" to be zero: we use isNegative flag to
	 * represent that a SimpleFloat is negative.
	 *
	 * @param x the SimpleFloat that is added to this SimpleFloat
	 * @return SimpleFloat whose value = value of 'this' + value of 'x'	 */
	 public SimpleFloat addTo(SimpleFloat x) {
		SimpleFloat result = new SimpleFloat(this.mantissa, this.exponent);
		result.isNegative = this.isNegative;

		// align exponents
		while (result.exponent < x.exponent) {
			result.mantissa >>= 1;
			result.exponent++;
		}
		while (result.exponent > x.exponent) {
			x.mantissa >>= 1;
			x.exponent++;
		}

		// add mantissas
		if (result.isNegative == x.isNegative) {
			result.mantissa += x.mantissa;
		} else {
			result.mantissa -= x.mantissa;
		}

		// normalize
		result.normalize();
		return result;
	}
	
	/** toString()
	 * Student should supply code to match the specification in the lab doc.
	 *
	 * @return String representation of this SimpleFloat, per lab spec
	 */
	public String toString() {
		String result = isNegative ? "-" : "";
		result += mantissa + " x pow(2, " + exponent + ")";
		return result;
	}

	/** value()
	 * Student should supply code to match the specification in the lab doc.
	 *
	 * @return double value of this SimpleFloat
	 */
	public double value() {
		double result = mantissa * Math.pow(2, exponent);
		return (isNegative) ? -result : result;
	}

} // end class SimpleFloat


/** class SimpleFloatNum
 *
 * Tester class for SimpleFloat
 */
class SimpleFloatNum {
	public static void main(String[] args) {
		try {
			// create two SimpleFloats from the command line arguments
			SimpleFloat first = new SimpleFloat(Double.parseDouble(args[0]));
			SimpleFloat second = new SimpleFloat(Double.parseDouble(args[1]));
			SimpleFloat third = new SimpleFloat(Double.parseDouble(args[2]));

			// add the three SimpleFloats together
			SimpleFloat result = first.addTo(second).addTo(third);

			// test toString() and value()
			System.out.println(result.toString());
			System.out.println(result.value());
		} catch (NumberFormatException e) {
			// number format exception
			System.err.println("ERROR");
		}
	}
}