package main.concrete;

import java.awt.image.BufferedImage;

import org.apache.commons.math3.complex.Complex;

import math.concrete.MandelbrotChecker;
import parameters.concrete.*;
import image.abstracts.Painter;

public class Generator {

	public void generateFractal(Painter painter, Size imageSize,
			Rectangle complexField) {
		
		MandelbrotChecker checker = new MandelbrotChecker();
		int imageX = 1;
		int imageY = 1;
		
		for (double widthStep = 1 / imageSize.getWidth(); widthStep <= imageSize.getWidth(); widthStep += 1 / imageSize.getWidth()) {
			double fieldX = complexField.getA().min
					+ (complexField.getA().max - complexField.getA().min)
					* widthStep;
			
			for (double heightStep = 1 / imageSize.getHeight(); heightStep <= imageSize.getHeight(); heightStep += 1 / imageSize.getHeight()) {
				double fieldY = complexField.getB().max
						- (complexField.getB().max - complexField.getB().min)
						* heightStep;
				
				int stepsToInfinity = checker.getStepsToInfinity(new Complex(fieldX, fieldY));
				painter.paintPixel(stepsToInfinity, painter.getImage(), imageX, imageY);
				
				imageY += 1;
			}
			
			imageX += 1;			
		}
	}
	
}
