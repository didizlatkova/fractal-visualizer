package math.concrete;

import org.apache.commons.math3.complex.Complex;

import math.abstracts.Formula;

public class FormulaExample implements Formula {

	@SuppressWarnings("unused")
	private static String notatation = "Z^2 + C";
	
	@Override
	public Complex compute(Complex z, Complex c) {
		return z.multiply(z).add(c);
	}

}
