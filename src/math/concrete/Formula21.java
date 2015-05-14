package math.concrete;

import org.apache.commons.math3.complex.Complex;

import math.abstracts.Formula;

public class Formula21 implements Formula {

	@SuppressWarnings("unused")
	private static String notatation = "(Z+e^Z)^2 + C";
	
	@Override
	public Complex compute(Complex z, Complex c) {
		return Complex.valueOf(Math.pow(z.add(Math.pow(Math.E, z.getReal())).getReal(), 2.0)).add(c);
	}

}
