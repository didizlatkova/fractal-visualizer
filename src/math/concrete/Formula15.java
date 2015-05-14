package math.concrete;

import org.apache.commons.math3.complex.Complex;

import math.abstracts.Formula;

public class Formula15 implements Formula {

	@SuppressWarnings("unused")
	private static String notatation = "e^Z - C";
	
	@Override
	public Complex compute(Complex z, Complex c) {
		return Complex.valueOf(Math.pow(Math.E, z.getReal())).subtract(c);
	}

}
