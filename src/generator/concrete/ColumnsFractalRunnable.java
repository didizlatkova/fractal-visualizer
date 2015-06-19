package generator.concrete;

import org.apache.commons.math3.complex.Complex;

import generator.abstracts.FractalRunnable;
import image.abstracts.Painter;
import logging.concrete.MessageLogger;
import math.concrete.MandelbrotChecker;
import parameters.concrete.Rectangle;
import parameters.concrete.Size;

public class ColumnsFractalRunnable extends FractalRunnable {

	private int startColumn;
	private int endColumn;

	public ColumnsFractalRunnable(Painter painter, MandelbrotChecker checker,
			Size imageSize, Rectangle complexField, int startColumn,
			int endColumn) {
		super(painter, checker, imageSize, complexField);
		this.startColumn = startColumn;
		this.endColumn = endColumn;
	}

	@Override
	public void run() {
		double widthStep = (1 / (double) imageSize.getWidth())
				* (startColumn + 1);

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

				MessageLogger.getInstance().log(String.format("(%.9f, %.9f) to (%3d, %3d) => %d\n",
						fieldX, fieldY, imageX, imageY, stepsToInfinity));

				painter.paintPixel(stepsToInfinity, imageX, imageY);

				heightStep += 1 / (double) imageSize.getHeight();
			}

			widthStep += 1 / (double) imageSize.getWidth();
		}

	}

}
