package math.abstracts;

import org.apache.commons.math3.complex.Complex;

public interface Formula {

	Complex compute(Complex z, Complex c);
	
}
