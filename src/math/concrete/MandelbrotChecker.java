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
		Complex zero = new Complex(0.0, 0.0);
		Complex previous = zero;
		Complex current = null;
		
		for (int stepsToInfinity = 1; stepsToInfinity <= MandelbrotChecker.NUMBER_OF_STEPS; stepsToInfinity++) {
			current = getNextMandelbrotNumber(previous, number);
			
			if (current.isInfinite() || current.isNaN()) {
				return stepsToInfinity;
			}
			
			previous = current;			
		}
		
		return 0;
	}
}
