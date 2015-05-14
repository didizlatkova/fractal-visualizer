package math.concrete;

import org.apache.commons.math3.complex.Complex;

import math.abstracts.Formula;

public class Formula16 implements Formula {
	
	@SuppressWarnings("unused")
	private static String notatation = "Z^2 + C ∗ е^(−Z)";

	@Override
	public Complex compute(Complex z, Complex c) {
		return z.multiply(z).add(c.multiply(Math.pow(Math.E, z.negate().getReal())));
	}

}
