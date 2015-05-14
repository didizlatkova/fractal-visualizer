package math.concrete;

import org.apache.commons.math3.complex.Complex;

import math.abstracts.Formula;

public class Formula19 implements Formula {

	@SuppressWarnings("unused")
	private static String notatation = "e^(Z^2+C)";
	
	@Override
	public Complex compute(Complex z, Complex c) {
		return Complex.valueOf(Math.pow(Math.E, z.multiply(z).add(c).getReal()));
	}

}
