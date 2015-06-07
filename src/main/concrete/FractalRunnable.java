package main.concrete;

import org.apache.commons.math3.complex.Complex;

import image.abstracts.Painter;
import logging.abstracts.Logger;
import math.concrete.MandelbrotChecker;
import parameters.concrete.Rectangle;
import parameters.concrete.Size;

public class FractalRunnable implements Runnable {

	private Painter painter;
	private MandelbrotChecker checker;
	private Size imageSize;
	private Rectangle complexField;
	private int startColumn;
	private int endColumn;
	private Logger logger;

	public FractalRunnable(Painter painter, MandelbrotChecker checker,
			Size imageSize, Rectangle complexField, int startColumn,
			int endColumn, Logger logger) {
		this.painter = painter;
		this.checker = checker;
		this.imageSize = imageSize;
		this.complexField = complexField;
		this.startColumn = startColumn;
		this.endColumn = endColumn;
		this.logger = logger;
	}

	@Override
	public void run() {
		double widthStep = (1 / (double) imageSize.getWidth()) * (startColumn + 1);

		for (int imageX = startColumn; imageX < endColumn; imageX++) {
			double fieldX = complexField.getA().min
					+ (complexField.getA().max - complexField.getA().min)
					* widthStep;

			double heightStep = 1 / (double) imageSize.getHeight();

			for (int imageY = 0; imageY < imageSize.getHeight(); imageY++) {
				double fieldY = complexField.getB().max
						- (complexField.getB().max - complexField.getB().min)
						* heightStep;

				int stepsToInfinity = checker.getStepsToInfinity(new Complex(
						fieldX, fieldY), imageSize.getWidth());

				logger.log(String.format("(%.9f, %.9f) to (%3d, %3d) => %d\n",
						fieldX, fieldY, imageX, imageY, stepsToInfinity));

				painter.paintPixel(stepsToInfinity, imageX, imageY);

				heightStep += 1 / (double) imageSize.getHeight();
			}

			widthStep += 1 / (double) imageSize.getWidth();
		}

	}

}
