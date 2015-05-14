package math.concrete;

import org.apache.commons.math3.complex.Complex;

import math.abstracts.Formula;

public class Formula20 implements Formula {

	@SuppressWarnings("unused")
	private static String notatation = "Z*Z*e^(Z*Z)+C";
	
	@Override
	public Complex compute(Complex z, Complex c) {
		return z.multiply(z).multiply(Math.pow(Math.E, z.multiply(z).getReal())).add(c);
	}

}
