package generator.abstracts;

import image.abstracts.Painter;
import math.concrete.MandelbrotChecker;
import parameters.concrete.Rectangle;
import parameters.concrete.Size;

public abstract class FractalRunnable implements Runnable {

	protected Painter painter;
	protected MandelbrotChecker checker;
	protected Size imageSize;
	protected Rectangle complexField;

	public FractalRunnable(Painter painter, MandelbrotChecker checker,
			Size imageSize, Rectangle complexField) {
		this.painter = painter;
		this.checker = checker;
		this.imageSize = imageSize;
		this.complexField = complexField;
	}

	public abstract void run();

}
