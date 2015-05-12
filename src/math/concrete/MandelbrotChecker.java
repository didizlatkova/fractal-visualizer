package math.concrete;

import org.apache.commons.math3.complex.Complex;

public class MandelbrotChecker {

	// TODO: check if this is a constant value or depends on width/height
	private static final int NUMBER_OF_STEPS = 640;
	
	private Complex getNextMandelbrotNumber(Complex previous, Complex current){		
		//formula is: Z^2 + C ∗ е^(−Z)
		return previous.multiply(previous).add(current.multiply(Math.pow(Math.E, previous.negate().getReal())));
	}
	
	public int getStepsToInfinity(Complex number){
		for (int i = 0; i < MandelbrotChecker.NUMBER_OF_STEPS; i++) {
			
		}
		return 0;
	}
}
