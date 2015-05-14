package math.concrete;

import org.apache.commons.math3.complex.Complex;

import math.abstracts.Formula;

public class Formula18 implements Formula {

	@SuppressWarnings("unused")
	private static String notatation = "C*cos(Z)";
	
	@Override
	public Complex compute(Complex z, Complex c) {
		return c.multiply(Math.cos(z.getReal()));
	}

}
