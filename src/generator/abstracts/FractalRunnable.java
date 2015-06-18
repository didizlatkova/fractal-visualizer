package generator.abstracts;

import image.abstracts.Painter;
import logging.abstracts.Logger;
import math.concrete.MandelbrotChecker;
import parameters.concrete.Rectangle;
import parameters.concrete.Size;

public abstract class FractalRunnable implements Runnable {

	protected Painter painter;
	protected MandelbrotChecker checker;
	protected Size imageSize;
	protected Rectangle complexField;
	protected Logger logger;

	public FractalRunnable(Painter painter, MandelbrotChecker checker,
			Size imageSize, Rectangle complexField, Logger logger) {
		this.painter = painter;
		this.checker = checker;
		this.imageSize = imageSize;
		this.complexField = complexField;
		this.logger = logger;
	}

	public abstract void run();

}
