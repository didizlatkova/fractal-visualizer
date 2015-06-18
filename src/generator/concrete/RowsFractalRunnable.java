package generator.concrete;

import org.apache.commons.math3.complex.Complex;

import generator.abstracts.FractalRunnable;
import image.abstracts.Painter;
import logging.abstracts.Logger;
import math.concrete.MandelbrotChecker;
import parameters.concrete.Rectangle;
import parameters.concrete.Size;

public class RowsFractalRunnable extends FractalRunnable {

	private int startRow;
	private int endRow;

	public RowsFractalRunnable(Painter painter, MandelbrotChecker checker,
			Size imageSize, Rectangle complexField, int startRow, int endRow,
			Logger logger) {
		super(painter, checker, imageSize, complexField, logger);
		this.startRow = startRow;
		this.endRow = endRow;
	}

	@Override
	public void run() {
		double heightStep = (1 / (double) imageSize.getHeight())
				* (startRow + 1);

		for (int imageY = startRow; imageY < endRow; imageY++) {
			double fieldY = complexField.getB().max
					- (complexField.getB().max - complexField.getB().min)
					* heightStep;

			double widthStep = 1 / (double) imageSize.getWidth();

			for (int imageX = 0; imageX < imageSize.getWidth(); imageX++) {
				double fieldX = complexField.getA().min
						+ (complexField.getA().max - complexField.getA().min)
						* widthStep;

				int stepsToInfinity = checker.getStepsToInfinity(new Complex(
						fieldX, fieldY), imageSize.getWidth());

				logger.log(String.format("(%.9f, %.9f) to (%3d, %3d) => %d\n",
						fieldX, fieldY, imageX, imageY, stepsToInfinity));

				painter.paintPixel(stepsToInfinity, imageX, imageY);

				widthStep += 1 / (double) imageSize.getWidth();
			}

			heightStep += 1 / (double) imageSize.getHeight();
		}
	}

}
