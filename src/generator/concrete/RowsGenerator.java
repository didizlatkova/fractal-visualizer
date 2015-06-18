package generator.concrete;

import logging.abstracts.Logger;
import math.concrete.MandelbrotChecker;
import parameters.concrete.*;
import generator.abstracts.FractalRunnable;
import generator.abstracts.Generator;
import image.abstracts.Painter;

public class RowsGenerator extends Generator {

	public RowsGenerator(Logger logger) {
		super(logger);
	}

	public void generateFractal(Painter painter, MandelbrotChecker checker,
			Size imageSize, Rectangle complexField, int maxThreads) {
		int workAmount = imageSize.getHeight() / maxThreads;
		int startRow = 0;
		this.threadArray = new Thread[maxThreads];

		for (int i = 0; i < maxThreads; i++) {
			FractalRunnable runnable = new RowsFractalRunnable(painter,
					checker, imageSize, complexField, startRow,
					(i != maxThreads - 1) ? startRow + workAmount
							: imageSize.getHeight(), logger);
			Thread t = new Thread(runnable);
			threadArray[i] = t;
			t.start();

			startRow += workAmount;
		}

		super.generateFractal(painter, checker, imageSize, complexField,
				maxThreads);
	}

}
