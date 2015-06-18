package generator.abstracts;

import image.abstracts.Painter;
import logging.abstracts.Logger;
import math.concrete.MandelbrotChecker;
import parameters.concrete.Rectangle;
import parameters.concrete.Size;

public abstract class Generator {

	protected Logger logger;
	protected Thread[] threadArray;

	public Generator(Logger logger) {
		this.logger = logger;
	}

	public void generateFractal(Painter painter, MandelbrotChecker checker,
			Size imageSize, Rectangle complexField, int maxThreads) {
		for (int i = 0; i < threadArray.length; i++) {
			try {
				threadArray[i].join();
			} catch (InterruptedException e) {
				logger.logAlways(e.getMessage());
			}
		}
	}

}
