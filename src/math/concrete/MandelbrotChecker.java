package math.concrete;

import math.abstracts.Formula;

import org.apache.commons.math3.complex.Complex;

public class MandelbrotChecker {

	// TODO: check if this is a constant value or depends on width/height
	private static final int NUMBER_OF_STEPS = 640;
	
	private Formula formula;
	
	public Formula getFormula() {
		return formula;
	}

	public void setFormula(Formula formula) {
		this.formula = formula;
	}
	
	public MandelbrotChecker(Formula formula){
		this.setFormula(formula);
	}

	private Complex getNextMandelbrotNumber(Complex previous, Complex current){
		return formula.compute(previous, current);
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
