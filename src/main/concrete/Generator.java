package main.concrete;

import logging.abstracts.Logger;
import math.concrete.MandelbrotChecker;
import parameters.concrete.*;
import image.abstracts.Painter;

public class Generator {
	private Logger logger;

	public Generator(Logger logger) {
		this.logger = logger;
	}

	public void generateFractal(Painter painter, MandelbrotChecker checker,
			Size imageSize, Rectangle complexField, int maxThreads) {
		int workAmount = imageSize.getWidth() / maxThreads;
		int startColumn = 0;
		Thread threadArray[] = new Thread[maxThreads];

		for (int i = 0; i < maxThreads; i++) {
			FractalRunnable runnable = new FractalRunnable(painter, checker,
					imageSize, complexField, startColumn,
					(i != maxThreads - 1) ? startColumn + workAmount
							: imageSize.getWidth(), logger);
			Thread t = new Thread(runnable);
			threadArray[i] = t;
			t.start();

			startColumn += workAmount;
		}

		for (int i = 0; i < threadArray.length; i++) {
			try {
				threadArray[i].join();
			} catch (InterruptedException e) {
				logger.logAlways(e.getMessage());
			}
		}

	}
}
