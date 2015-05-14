package math.concrete;

import org.apache.commons.math3.complex.Complex;

import math.abstracts.Formula;

public class Formula17 implements Formula {

	@SuppressWarnings("unused")
	private static String notatation = "e^cos(C*Z)";
	
	@Override
	public Complex compute(Complex z, Complex c) {
		return Complex.valueOf(Math.pow(Math.E, Math.cos(c.multiply(z).getReal())));
	}

}
