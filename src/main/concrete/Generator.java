package main.concrete;

import org.apache.commons.math3.complex.Complex;

import logging.abstracts.Logger;
import math.concrete.Formula15;
import math.concrete.MandelbrotChecker;
import parameters.concrete.*;
import image.abstracts.Painter;

public class Generator {
	private Logger logger;

	public Generator(Logger logger) {
		this.logger = logger;
	}

	public void generateFractal(Painter painter, MandelbrotChecker checker, Size imageSize,
			Rectangle complexField) {
		double widthStep = 1 / (double) imageSize.getWidth();

		for (int imageX = 0; imageX < imageSize.getWidth(); imageX++) {
			double fieldX = complexField.getA().min
					+ (complexField.getA().max - complexField.getA().min)
					* widthStep;

			double heightStep = 1 / (double) imageSize.getHeight();

			//logger.log("width step: " + widthStep);

			for (int imageY = 0; imageY < imageSize.getHeight(); imageY++) {
				double fieldY = complexField.getB().max
						- (complexField.getB().max - complexField.getB().min)
						* heightStep;

				//logger.log("height step: " + heightStep);

				int stepsToInfinity = checker.getStepsToInfinity(new Complex(
						fieldX, fieldY));

//				logger.log(String.format("(%.9f, %.9f) to (%3d, %3d) => %d\n",
//						fieldX, fieldY, imageX, imageY, stepsToInfinity));
				
				//logger.log(Integer.toString(stepsToInfinity));

				painter.paintPixel(stepsToInfinity, painter.getImage(), imageX,
						imageY);

				heightStep += 1 / (double) imageSize.getHeight();
			}

			widthStep += 1 / (double) imageSize.getWidth();
		}
	}

}
